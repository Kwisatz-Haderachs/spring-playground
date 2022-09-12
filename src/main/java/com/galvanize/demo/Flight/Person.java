package com.galvanize.demo.Flight;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Person {
    private String firstName;
    private String lastName;

    @JsonGetter("FirstName")
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    @JsonGetter("LastName")
    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}
}
