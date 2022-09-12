package com.galvanize.demo.Flight;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FlightController {

    public List<Flight.Person> createPeople(){
        List<Flight.Person> people = new ArrayList<>();
        Flight.Person a = new Flight.Person();
        a.setFirstName("Gordon");
        a.setLastName("Ryan");
        people.add(a);
        Flight.Person b = new Flight.Person();
        b.setFirstName("Nikolas");
        b.setLastName("Meregali");
        people.add(b);
        Flight.Person c = new Flight.Person();
        c.setFirstName("John");
        c.setLastName("Danaher");
        people.add(c);
        Flight.Person d = new Flight.Person();
        d.setFirstName("Craig");
        d.setLastName("Jones");
        people.add(d);
        return people;
    }

    public List<Flight.Ticket> createTickets(){
        List<Flight.Person> people = createPeople();
        List<Flight.Ticket> ticketList = new ArrayList<>();
        Flight.Ticket a = new Flight.Ticket();
        a.setPassenger(people.get(0));
        a.setPrice(230);
        Flight.Ticket b = new Flight.Ticket();
        b.setPassenger(people.get(1));
        b.setPrice(234);
        Flight.Ticket c = new Flight.Ticket();
        c.setPassenger(people.get(2));
        c.setPrice(130);
        Flight.Ticket d = new Flight.Ticket();
        d.setPassenger(people.get(3));
        d.setPrice(243);
        ticketList.add(a);
        ticketList.add(b);
        ticketList.add(c);
        ticketList.add(d);
        return ticketList;
    }

    public List<Flight> createFlights(){
        List<Flight.Ticket> tickets = createTickets();
        List<Flight> flights = new ArrayList<>();
        Flight a = new Flight();
        a.setTickets(tickets);
        a.setDestination("London");
        a.setDeparts(LocalDateTime.of(2021,4,6, 14,36));
        Flight b = new Flight();
        b.setTickets(tickets);
        b.setDestination("Las Vegas");
        b.setDeparts(LocalDateTime.of(2022,9,12,15,36));
        flights.add(a);
        flights.add(b);
        return flights;
    }

    @RequestMapping("/json/flights/flight")
    public Flight getFlight(){
        List<Flight> flights = createFlights();
        return flights.get(0);
    }

    @RequestMapping("/json/flights")
    public List<Flight> getFlights(){
        return createFlights();
    }
}
