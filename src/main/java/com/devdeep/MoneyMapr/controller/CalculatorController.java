package com.devdeep.MoneyMapr.controller;

import com.devdeep.MoneyMapr.MoneyMaprApplication;
import com.devdeep.MoneyMapr.Service.CICalculatorService;
import com.devdeep.MoneyMapr.model.CIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class CalculatorController {

    @Autowired
    public CICalculatorService service;

    @PostMapping("/api/compoundcalculator")
    public ResponseEntity<Double []> compoundInterestCalculator(@RequestBody CIData ciData){

        double newAmt = service.getCIValue(ciData);
        double totalPrincipal = newAmt + ciData.getPrincipal();

        newAmt  = Math.round(newAmt*10000)/10000.0;
        totalPrincipal  = Math.round(totalPrincipal*10000)/10000.0;

        Double [] result = {newAmt,totalPrincipal};

        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }
}
