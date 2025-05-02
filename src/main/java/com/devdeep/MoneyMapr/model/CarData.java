package com.devdeep.MoneyMapr.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CarData {

    private double salary;
    private double carPrice;
    private double loanTerm;
    private double emiRateOfInterest;
    private double downPayment;

}
