package com.galvanize.demo.Dogs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DogsController {

    //basic, with RequestParams
    @GetMapping("/dog")
    public String getDog(@RequestParam String name, @RequestParam(required = false, defaultValue = "translucent") String color){
        return String.format("Name: %s\nColor: %s", name, color);
    }

    //using Map
    @GetMapping("/dogs")
    public String getDogs(@RequestParam Map<String,String> queries){
        return String.format("Name: %s\nColor: %s", queries.get("name"), queries.get("color"));
    }

    //class constructor example "POJO"
    @GetMapping("/doggy")
    public String getDoggy(Dog newDog){
        return String.format("Name: %s\nColor: %s", newDog.getName(), newDog.getColor());
    }

    @GetMapping("/dog/{id}")
    public String doggyID(@PathVariable int id){
        return String.format("ID: %d", id);
    }
}
