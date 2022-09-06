package com.galvanize.demo.math;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathService {
    private final double PI = 3.14159265358979323846264338327950288419716939937510;

    public double getPi(){
        return PI;
    }

    public String operation(String operation, int x, int y){
        return switch (operation) {
            case ("add") -> String.format("%d + %d = %d", x, y, x + y);
            case ("subtract") -> String.format("%d - %d = %d", x, y, x - y);
            case ("multiply") -> String.format("%d * %d = %d", x, y, x * y);
            default -> String.format("%d / %d = %d", x, y, x / y);
        };
    }
    public String sum (List<Integer> numbers){
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (Integer n :numbers) {
            sb.append(n).append(" + ");
            sum += n;
        }
        sb.replace(sb.length()-3,sb.length()," = ").append(sum);
        return sb.toString();
    }

    public String volumeRectangular (int l, int w, int h){
        return String.format("The volume of a %dx%dx%d rectangle is %d", l, w, h, (l * w * h));
    }
    public String volumeSphere(double radius){
        return String.format("The volume of a radius %.2f sphere is %.3f", radius, (4.0/3.0)*radius*radius*radius*PI);
    }
    public String volumeCylindrical(int radius, int height){
        return String.format("The volume of a %dx%d cylinder is %.3f", radius, height, height*radius*radius*PI);
    }

}
