package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/")
    public String hello(){
        return "Hello From Spring!";
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        Employee one = new Employee("John", "Wick", 02);
        employeeList.add(one);
        return employeeList;
    }
}
