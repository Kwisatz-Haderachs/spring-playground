package com.galvanize.demo.Flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

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

    @JsonSetter("DESTINATION")
    public void setDestination(String destination) { this.destination = destination; }

    @JsonGetter("Tickets")
    public List<Ticket> getTickets() {
        return tickets;
    }

    @JsonSetter("TICKETS")
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public LocalDateTime getDeparts() { return departs; }

    public void setDeparts(LocalDateTime dateTime) { this.departs = dateTime; }

    public Person getPilot() { return pilot; }

    public void setPilot(Person pilot) { this.pilot = pilot; }

}
