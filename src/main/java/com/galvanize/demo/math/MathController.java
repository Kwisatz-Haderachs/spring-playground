package com.galvanize.demo.math;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {
    private MathService ms;
    public MathController(MathService ms){
        this.ms  = ms;
    }
    @GetMapping("/pi")
    public String servePi(){
        return ms.getPi()+"";
    }
    @GetMapping("/calculate")
    public String calculate(@RequestParam String operation, @RequestParam int x, @RequestParam int y){
        return ms.operation(operation, x, y);
    }
    @PostMapping("/sum")
    public String sum(@RequestParam MultiValueMap<String, String> nums) {
        return ms.sum(nums.get("n"));
    }
    @PostMapping("/volume/rectangle/{length}/{width}/{height}")
    public String volumeRec(@PathVariable int length, @PathVariable int width, @PathVariable int height) {
        return ms.volumeRectangular(length, width, height);
    }
    @PostMapping("/volume/sphere/{radius}")
    public String volumeSph(@PathVariable double radius){
        return ms.volumeSphere(radius);
    }
    @PostMapping("/volume/cylinder/{radius}/{height}")
    public String volumeCyl(@PathVariable int radius, @PathVariable int height){
        return ms.volumeCylindrical(radius, height);
    }

}
