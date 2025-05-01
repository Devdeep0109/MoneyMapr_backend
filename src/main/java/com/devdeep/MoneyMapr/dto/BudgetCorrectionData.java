package com.devdeep.MoneyMapr.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BudgetCorrectionData {

    private String name;
    private double value;
    private  int priority;

    public BudgetCorrectionData(String name, double value, int priority) {
        this.name = name;
        this.value = value;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "BudgetCorrectionData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", priority=" + priority +
                '}';
    }
}
