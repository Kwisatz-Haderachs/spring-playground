package com.galvanize.demo.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ComponentScan(basePackages = "com.galvanize.demo.math")
@RestController
public class MathController {
    private MathService ms;
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
    @PostMapping("/math/volume/{length}/{width}/{height}")
    public String volume(@PathVariable int length, @PathVariable int width, @PathVariable int height){
        return ms.volume(length, width, height);
    }
}
