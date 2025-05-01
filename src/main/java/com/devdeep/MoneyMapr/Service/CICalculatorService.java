package com.devdeep.MoneyMapr.Service;

import com.devdeep.MoneyMapr.model.CIData;
import org.springframework.stereotype.Service;

@Service
public class CICalculatorService {

    public double getCIValue(CIData ciData) {

        double amt = ciData.getPrincipal();
        double rate = ciData.getRate();
        double time = ciData.getTime();
        String freq = ciData.getFrequency();

        double finalAmt = 0;

        if(freq.matches("Annually")){

            finalAmt = amt*( Math.pow(1+(rate/100),time) );
        }
        else if(freq.matches("Half-Yearly")){
            int n = 2; //Number of times interest is compounded per half-year
            time *= n;
            finalAmt = amt*( Math.pow(1+(rate/(n*100)),time) );
        }
        else if(freq.matches("Quarterly")){
            int n = 4; //Number of times interest is compounded per quarter
            time *= n;
            finalAmt = amt*( Math.pow(1+(rate/(n*100)),time) );
        }
        else{
            int n = 12; //Number of times interest is compounded per month
            time *= n;
            finalAmt = amt*( Math.pow(1+(rate/(n*100)),time) );
        }
        return finalAmt;
    }
}
