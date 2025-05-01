package com.devdeep.MoneyMapr.Service;

import com.devdeep.MoneyMapr.dto.BudgetStatus;
import com.devdeep.MoneyMapr.model.ElaborateData;
import com.devdeep.MoneyMapr.model.MonthlyExpenseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetCalculatorService {

    public double userSaving = 0;
    public double idealSaving = 0;

    public BudgetStatus calculateBudget(MonthlyExpenseData expData) {

        BudgetStatus calBudget = new BudgetStatus();

        double userSalary = expData.getSalary();
        double userNeeds = expData.getNeeds();
        double userWants = expData.getWants();
        userSaving = expData.getSavings();

        double idealNeeds = userSalary*(.5);
        double idealWants = userSalary*(.3);
        idealSaving = userSalary*(.2);

        double calculatedNeed = Math.round((idealNeeds-userNeeds)*10000)/10000.0;
        double calculatedWant = Math.round((idealWants-userWants)*10000)/10000.0;
        double calculatedSaving = Math.round((userSaving-idealSaving)*10000)/10000.0;

        calBudget.setNeeds(calculatedNeed);
        calBudget.setNeedsMet(calculatedNeed >= 0);

        calBudget.setWants(calculatedWant);
        calBudget.setWantsMet(calculatedWant >= 0);

        calBudget.setSavings(calculatedSaving);
        calBudget.setSavingsMet(calculatedSaving >= 0);

        return calBudget;
    }
}
