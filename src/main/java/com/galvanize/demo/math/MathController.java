package com.galvanize.demo.math;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/area")
    public String areaCalc(@RequestParam Map<String, String> shape){
        String type = shape.get("type");
        if (type.equals("rectangle") && shape.containsKey("length") && shape.containsKey("width")){
            return ms.areaRectangle(Integer.parseInt(shape.get("length")), Integer.parseInt(shape.get("width")));
        }
        if (type.equals("circle") && shape.containsKey("radius")){
            return ms.areaCircle(Double.parseDouble(shape.get("radius")));
        }
        return "Invalid";
    }
    @PostMapping("/area/rectangle")
    public String areaRectangle(Rectangular rectangle){
        return ms.areaRectangle(rectangle);
    }
    @PostMapping("/area/circle")
    public String areaCircle(Circular circle){
        return ms.areaCircle(circle);
    }

    @PostMapping("/volume/rectangle")
    public String volumeRectangle(Rectangular rec){
        return ms.volumeRectangular(rec.getLength(), rec.getWidth(), rec.getHeight());
    }

    @PostMapping("/volume/sphere")
    public String volumeSphereShape(Circular s){
        return ms.volumeSphere(s.getRadius());
    }
    @PostMapping("/volume/cylinder")
    public String volumeCylinderShape(Circular cyl){
        return ms.volumeCylindrical(cyl.getRadius(), cyl.getHeight());
    }
}
