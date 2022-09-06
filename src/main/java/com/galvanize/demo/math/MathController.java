package com.galvanize.demo.math;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MathController {
    private final MathService ms;
    public MathController(MathService ms){
        this.ms  = ms;
    }

    @GetMapping("/math/pi")
    public String servePi(){
        return "3.14159265358979323846264338327950288419716939937510";
    }

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam String operation, @RequestParam int x, @RequestParam int y){
        return ms.operation(operation, x, y);
    }
    @PostMapping("/math/sum")
    public String sum(@RequestParam MultiValueMap<String, String> nums) {
        return ms.sum(nums.get("n"));
    }

}
