package com.galvanize.demo.math;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathService {
    private List<Integer> numbers;
    public List<Integer> getNumbers(){
        return numbers;
    }
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
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

    public String volume (int l, int w, int h){
        return String.format("The volume of a %dx%dx%d rectangle is %d", l, w, h,(l*w*h));
    }

}
