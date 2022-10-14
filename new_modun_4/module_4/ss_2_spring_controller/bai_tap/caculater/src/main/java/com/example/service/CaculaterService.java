package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CaculaterService implements ICaculater {
    @Override
    public String  caculater(double number1, double number2, String option) {
        String note="Không thể chia cho 0";
        String result = "";
        switch (option) {
            case "cong":
                result = number1 + number2+"";
                break;
            case "tru":
                result = number1 - number2+"";
                break;
            case "nhan":
                result = number1 * number2+"";
                break;
            case "chia":
                if (number2==0){
                    result=note+"";
                    break;
                }else {
                result = number1 / number2+"";
                break;}
        }
        return result;
    }
}