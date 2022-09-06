package com.galvanize.demo.math;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {
    private final MathService ms;
    public MathController(MathService ms){
        this.ms  = ms;
    }
    @GetMapping("/pi")
    public String servePi(){
        return ms.getPi()+"";
    }
    @GetMapping("/calculate")
    public String calculate(
            @RequestParam(required = false, defaultValue = "add") String operation,
            @RequestParam int x,
            @RequestParam int y){
        return ms.operation(operation, x, y);
    }
    @PostMapping("/sum")
    public String sum(@RequestParam List<Integer> n) {
        return ms.sum(n);
    }
    @RequestMapping("/volume/rectangle/{l}/{w}/{h}")
    public String volumeRec(@PathVariable int l, @PathVariable int w, @PathVariable int h) {
        return ms.volumeRectangular(l, w, h);
    }
    @RequestMapping("/volume/sphere/{radius}")
    public String volumeSph(@PathVariable double radius){
        return ms.volumeSphere(radius);
    }
    @RequestMapping("/volume/cylinder/{radius}/{height}")
    public String volumeCyl(@PathVariable double radius, @PathVariable double height){
        return ms.volumeCylindrical(radius, height);
    }

}
