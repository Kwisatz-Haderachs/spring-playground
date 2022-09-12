package com.galvanize.demo.Flight;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
                .andExpect(jsonPath("$.departs", is("2017-04-06 14:36")))
                .andExpect(jsonPath("$.Destination", is("London")))
                .andExpect(jsonPath("$.tickets[0].Passenger.FirstName", is("Dwayne")))
                .andExpect(jsonPath("$.tickets[0].Passenger.LastName", is("Johnson")))
                .andExpect(jsonPath("$.tickets[0].Price", is(200)));
    }

    @Test
    public void testGetFlights() throws Exception {
        this.mvc.perform(get("/json/flights")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].departs", is("2017-04-06 14:36")))
                .andExpect(jsonPath("$[0].Destination", is("London")))
                .andExpect(jsonPath("$[0].tickets[0].Passenger.FirstName", is("Dwayne")))
                .andExpect(jsonPath("$[0].tickets[0].Passenger.LastName", is("Johnson")))
                .andExpect(jsonPath("$[0].tickets[0].Price", is(200)))

                .andExpect(jsonPath("$[1].departs", is("2022-09-12 15:36")))
                .andExpect(jsonPath("$[1].Destination", is("Las Vegas")))
                .andExpect(jsonPath("$[1].tickets[0].Passenger.FirstName", is("Nikolas")))
                .andExpect(jsonPath("$[1].tickets[0].Passenger.LastName", is("Meregali")))
                .andExpect(jsonPath("$[1].tickets[0].Price", is(200)));
    }

}
