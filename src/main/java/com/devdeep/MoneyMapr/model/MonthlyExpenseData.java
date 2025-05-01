package com.devdeep.MoneyMapr.model;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MonthlyExpenseData {

    private double salary;
    private double needs;
    private double wants;
    private double savings;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getNeeds() {
        return needs;
    }

    public void setNeeds(double needs) {
        this.needs = needs;
    }

    public double getWants() {
        return wants;
    }

    public void setWants(double wants) {
        this.wants = wants;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    @Override
    public String toString() {
        return "MonthlyExpenseData{" +
                "salary=" + salary +
                ", needs=" + needs +
                ", wants=" + wants +
                ", savings=" + savings +
                '}';
    }
}
