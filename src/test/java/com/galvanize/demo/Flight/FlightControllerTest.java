package com.galvanize.demo.Flight;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testGetFlight() throws Exception {
        this.mvc.perform(get("/json/flights/flight")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departs", is("2021-04-06 14:36")))
                .andExpect(jsonPath("$.Destination", is("London")))
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("Gordon")))
                .andExpect(jsonPath("$.Tickets[0].Passenger.LastName", is("Ryan")))
                .andExpect(jsonPath("$.Tickets[0].Price", is(230)));
    }

    @Test
    public void testGetFlights() throws Exception {
        this.mvc.perform(get("/json/flights")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].departs", is("2021-04-06 14:36")))
                .andExpect(jsonPath("$[0].Destination", is("London")))
                .andExpect(jsonPath("$[0].Tickets[0].Passenger.FirstName", is("Gordon")))
                .andExpect(jsonPath("$[0].Tickets[0].Passenger.LastName", is("Ryan")))
                .andExpect(jsonPath("$[0].Tickets[0].Price", is(230)))

                .andExpect(jsonPath("$[1].departs", is("2022-09-12 15:36")))
                .andExpect(jsonPath("$[1].Destination", is("Las Vegas")))
                .andExpect(jsonPath("$[1].Tickets[1].Passenger.FirstName", is("Nikolas")))
                .andExpect(jsonPath("$[1].Tickets[1].Passenger.LastName", is("Meregali")))
                .andExpect(jsonPath("$[1].Tickets[1].Price", is(234)));
    }

    @Test
    public void testTicketSumLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                        "tickets": [
                            {
                                "PASSENGER": {
                                    "firstName": "Paul",
                                    "lastName": "Atreides"
                                },
                                "PRICE": 250
                            },
                            {
                            "PASSENGER":{
                                    "firstName": "Saito",
                                    "lastName": "Kubaiashi"
                                },
                                "PRICE": 250
                            }
                        ]
                        }
                        """);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(500)));
    }

    //objectmapper uses Jackson, if the property setting for names is different the code will break
    ObjectMapper objectMapper = new ObjectMapper();                    // 1
    @Test
    public void testTicketSumMap() throws Exception {
        Person p = new Person();
        p.setFirstName("John");
        p.setLastName("Wick");
        Person t = new Person();
        t.setFirstName("Kobyashi");
        t.setLastName("Maru");
        Ticket a = new Ticket();
        a.setPassenger(p);
        a.setPrice(250);
        Ticket b = new Ticket();
        b.setPassenger(t);
        b.setPrice(250);
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(a);
        ticketList.add(b);
        HashMap<String, List<Ticket>> tickets = new HashMap<>(){  // 2
            {
                put("tickets", ticketList);
            }
        };

        String json = objectMapper.writeValueAsString(tickets);            // 3

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);                                         // 4

        this.mvc.perform(request).andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(500)));
    }

    @Test
    public void testRawBody() throws Exception {
        String json = getJSON();
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(500)));
    }

    private String getJSON() throws Exception {
        URL url = this.getClass().getResource("/data.json");
        assert url != null;
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
