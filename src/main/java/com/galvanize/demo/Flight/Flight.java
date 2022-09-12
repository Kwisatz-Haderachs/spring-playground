package com.galvanize.demo.Flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;

public class Flight {
    private int id;
    private String destination;
    private LocalDateTime departs;
    private Person pilot;
    private List<Ticket> tickets;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @JsonGetter("Destination")
    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public LocalDateTime getDeparts() { return departs; }

    public void setDeparts(LocalDateTime dateTime) { this.departs = dateTime; }

    public Person getPilot() { return pilot; }

    public void setPilot(Person pilot) { this.pilot = pilot; }

    static class Ticket{
        private Person passenger;
        private int price;

        @JsonGetter("Passenger")
        public Person getPassenger() {return passenger;}

        public void setPassenger(Person person) {this.passenger = person;}

        @JsonGetter("Price")
        public int getPrice() {return price;}

        public void setPrice(int price) {this.price = price;}
    }

    static class Person {
        private String firstName;
        private String lastName;

        @JsonGetter("FirstName")
        public String getFirstName() { return firstName; }

        public void setFirstName(String firstName) { this.firstName = firstName; }

        @JsonGetter("LastName")
        public String getLastName() {return lastName;}

        public void setLastName(String lastName) {this.lastName = lastName;}
    }
}
