package com.devdeep.MoneyMapr.controller;

import java.util.*;
import com.devdeep.MoneyMapr.model.CarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.devdeep.MoneyMapr.service.CarAffordabilityService;


@CrossOrigin(origins = {"http://localhost:5173/","https://money-mapr-frontend.vercel.app/"})
@RestController
public class carAffordabilityController {

    @Autowired
    public CarAffordabilityService service;

    @PostMapping("/api/newcar")
    public ResponseEntity<List<Double>> carAffordability(@RequestBody CarData carData){

        List<Double> response = service.checkCarAffordability(carData);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }
}
