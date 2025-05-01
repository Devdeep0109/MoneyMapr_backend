package com.devdeep.MoneyMapr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetStatus {

    private double needs;       // The monetary amount for needs
    private boolean needsMet;   // Boolean flag indicating if needs are met

    private double wants;       // The monetary amount for wants
    private boolean wantsMet;   // Boolean flag indicating if wants are met

    private double savings;     // The monetary amount for savings
    private boolean savingsMet;


    public double getNeeds() {
        return needs;
    }

    public void setNeeds(double needs) {
        this.needs = needs;
    }

    public boolean isNeedsMet() {
        return needsMet;
    }

    public void setNeedsMet(boolean needsMet) {
        this.needsMet = needsMet;
    }

    public double getWants() {
        return wants;
    }

    public void setWants(double wants) {
        this.wants = wants;
    }

    public boolean isWantsMet() {
        return wantsMet;
    }

    public void setWantsMet(boolean wantsMet) {
        this.wantsMet = wantsMet;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public boolean isSavingsMet() {
        return savingsMet;
    }

    public void setSavingsMet(boolean savingsMet) {
        this.savingsMet = savingsMet;
    }

    @Override
    public String toString() {
        return "BudgetStatus{" +
                "needs=" + needs +
                ", needsMet=" + needsMet +
                ", wants=" + wants +
                ", wantsMet=" + wantsMet +
                ", savings=" + savings +
                ", savingsMet=" + savingsMet +
                '}';
    }
}
