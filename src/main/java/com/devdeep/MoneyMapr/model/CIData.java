package com.devdeep.MoneyMapr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

public class CIData {

    private  double principal;
    private double rate;
    private double time;
    private String frequency;

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "CIData{" +
                "principal=" + principal +
                ", rate=" + rate +
                ", time=" + time +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
