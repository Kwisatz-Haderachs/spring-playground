package com.galvanize.demo.Flight;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Ticket {
    private Person passenger;
    private int price;

    @JsonProperty("PASSENGER")
    public Person getPassenger() {return passenger;}

    @JsonProperty("PASSENGER")
    public void setPassenger(Person person) {this.passenger = person;}

    @JsonProperty("PRICE")
    public int getPrice() {return price;}

    @JsonProperty("PRICE")
    public void setPrice(int price) {this.price = price;}
}
