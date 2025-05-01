package com.devdeep.MoneyMapr.controller;

import com.devdeep.MoneyMapr.Service.BudgetCalculatorService;
import com.devdeep.MoneyMapr.dto.BudgetStatus;
import com.devdeep.MoneyMapr.model.MonthlyExpenseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class BudgetController {

    @Autowired
    public BudgetCalculatorService service;

    @PostMapping("/api/budget-calculation")
    public ResponseEntity<BudgetStatus> budgetCalculate(@RequestBody MonthlyExpenseData monthlyExpenseData){

        BudgetStatus response = service.calculateBudget(monthlyExpenseData);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }
}
