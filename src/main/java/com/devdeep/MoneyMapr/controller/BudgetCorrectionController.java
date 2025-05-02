package com.devdeep.MoneyMapr.controller;

import com.devdeep.MoneyMapr.service.BudgetCorrectionService;
import com.devdeep.MoneyMapr.dto.BudgetCorrectionData;
import com.devdeep.MoneyMapr.model.ElaborateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class BudgetCorrectionController {

    @Autowired
    public BudgetCorrectionService service;

    @PostMapping("/api/budget-correction")
    public ResponseEntity<List<List<BudgetCorrectionData>>> budgetCorrection(@RequestBody ElaborateData elaborateData){

        System.out.println(elaborateData);

        List<List<BudgetCorrectionData>> response = service.budgetCorrectionService(elaborateData);
        for(List<BudgetCorrectionData> inner: response){
            for(BudgetCorrectionData p : inner){
                System.out.println(p);
            }
        }
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }
}
