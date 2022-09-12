package com.galvanize.demo.Flight;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FlightController {

    @RequestMapping("/json/flights/flight")
    public Flight getFlight(){
        Flight f = new Flight();
        List<Flight.Ticket> ticketList = new ArrayList<>();
        f.setTickets(ticketList);
        f.setDestination("London");
        f.setDeparts(LocalDateTime.of(2017,4,6, 14,36));
        Flight.Ticket t = new Flight.Ticket();
        Flight.Person p = new Flight.Person();
        p.setFirstName("Dwayne");
        p.setLastName("Johnson");
        t.setPassenger(p);
        t.setPrice(200);
        f.getTickets().add(t);
        return f;
    }

    @RequestMapping("/json/flights")
    public List<Flight> getFlights(){
        List<Flight> flights = new ArrayList<>();
        Flight f = new Flight();
        List<Flight.Ticket> ticketList1 = new ArrayList<>();
        f.setTickets(ticketList1);
        f.setDestination("London");
        f.setDeparts(LocalDateTime.of(2017,4,6, 14,36));
        Flight.Ticket t = new Flight.Ticket();
        Flight.Person p = new Flight.Person();
        p.setFirstName("Dwayne");
        p.setLastName("Johnson");
        t.setPassenger(p);
        t.setPrice(200);
        f.getTickets().add(t);
        flights.add(f);

        Flight g = new Flight();
        List<Flight.Ticket> ticketList2 = new ArrayList<>();
        g.setTickets(ticketList2);
        g.setDestination("Las Vegas");
        g.setDeparts(LocalDateTime.of(2022,9,12, 15,36));
        Flight.Ticket a = new Flight.Ticket();
        Flight.Person b = new Flight.Person();
        b.setFirstName("Nikolas");
        b.setLastName("Meregali");
        a.setPassenger(b);
        a.setPrice(200);
        g.getTickets().add(a);
        flights.add(g);


        return flights;
    }
}
