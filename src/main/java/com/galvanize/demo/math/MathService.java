package com.galvanize.demo.math;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathService {
    private List<Integer> numbers;
    private final double PI = 3.14159265358979323846264338327950288419716939937510;
    public List<Integer> getNumbers(){
        return numbers;
    }
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

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
    public String sum (List<String> nums){
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (String n :nums) {
            sb.append(n).append(" + ");
            sum += Integer.parseInt(n);
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
