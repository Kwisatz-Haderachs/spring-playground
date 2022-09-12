package com.galvanize.demo.Flight;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Ticket {
    private Person passenger;
    private int price;

    @JsonGetter("Passenger")
    public Person getPassenger() {return passenger;}

    @JsonSetter("PASSENGER")
    public void setPassenger(Person person) {this.passenger = person;}

    @JsonGetter("PRICE")
    public int getPrice() {return price;}

    @JsonSetter("PRICE")
    public void setPrice(int price) {this.price = price;}
}
