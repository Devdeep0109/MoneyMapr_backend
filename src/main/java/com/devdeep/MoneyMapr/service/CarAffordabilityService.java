package com.devdeep.MoneyMapr.service;

import com.devdeep.MoneyMapr.model.CarData;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarAffordabilityService {

    public List<Double> checkCarAffordability(CarData carData){

        double remainingMoneyToPay = carData.getCarPrice() - carData.getDownPayment();
        double loanAmount = remainingMoneyToPay;
        double monthlyROIOfEMI = carData.getEmiRateOfInterest()/ (12*100);
        monthlyROIOfEMI = Math.round(monthlyROIOfEMI * 1000.0) / 1000.0;
        double months = carData.getLoanTerm()*12;

        double actualEMI = (loanAmount* monthlyROIOfEMI* Math.pow(1+monthlyROIOfEMI,months)) /
                (Math.pow(1+monthlyROIOfEMI,months)-1);

        actualEMI = Math.round(actualEMI * 1000.0) / 1000.0;
        double idealEMI = carData.getSalary()*.1;
        idealEMI = Math.round(idealEMI * 1000.0) / 1000.0;

        //sending response to controller....
        List<Double>  lst = new ArrayList<>();
        double ans = 0.0;
        System.out.println("actualEMI:  "+actualEMI);
        System.out.println("idealEMI:  "+idealEMI);

        if(actualEMI <= idealEMI){
            lst.add(0.0);
            lst.add(actualEMI);
            return lst;
        }
        else{
            // suggest no. of months to wait...
            double diffInEMI = Math.abs(idealEMI - actualEMI);
            while(diffInEMI > 0){
                ans++;
                diffInEMI -= carData.getSalary()*(0.1);
            }
        }
        lst.add(ans);
        lst.add(actualEMI);
        lst.add(idealEMI);
        return lst;
    }
}
