package com.galvanize.demo.Flight;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FlightController {

    public List<Person> createPeople(){
        List<Person> people = new ArrayList<>();
        Person a = new Person();
        a.setFirstName("Gordon");
        a.setLastName("Ryan");
        people.add(a);
        Person b = new Person();
        b.setFirstName("Nikolas");
        b.setLastName("Meregali");
        people.add(b);
        Person c = new Person();
        c.setFirstName("John");
        c.setLastName("Danaher");
        people.add(c);
        Person d = new Person();
        d.setFirstName("Craig");
        d.setLastName("Jones");
        people.add(d);
        return people;
    }

    public List<Ticket> createTickets(){
        List<Person> people = createPeople();
        List<Ticket> ticketList = new ArrayList<>();
        Ticket a = new Ticket();
        a.setPassenger(people.get(0));
        a.setPrice(230);
        Ticket b = new Ticket();
        b.setPassenger(people.get(1));
        b.setPrice(234);
        Ticket c = new Ticket();
        c.setPassenger(people.get(2));
        c.setPrice(130);
        Ticket d = new Ticket();
        d.setPassenger(people.get(3));
        d.setPrice(243);
        ticketList.add(a);
        ticketList.add(b);
        ticketList.add(c);
        ticketList.add(d);
        return ticketList;
    }

    public List<Flight> createFlights(){
        List<Ticket> tickets = createTickets();
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

    @PostMapping("/flights/tickets/total")
    public Map<String, Integer> calculateTicketTotal(@RequestBody Map<String, List<Ticket>> tickets ){
        int sum = 0;
        for (Ticket t : tickets.get("tickets")) {
            sum += t.getPrice();
        }
        Map<String, Integer> calculate = new HashMap<>();
        calculate.put("result", sum);
        return calculate;
    }

    @PostMapping("/flights/tickets/passengers")
    public Map<String, List<String>> listOfPassengers(@RequestBody Map<String, List<Ticket>> tickets ){
        List<String> passenger = new ArrayList<>();
        for (Ticket t : tickets.get("tickets")) {
            String p = t.getPassenger().getFirstName() + " " + t.getPassenger().getLastName();
            passenger.add(p);
        }
        Map<String, List<String>> passengers = new HashMap<>();
        passengers.put("passengers", passenger);
        return passengers;
    }
}
