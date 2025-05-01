package com.devdeep.MoneyMapr.Service;

import com.devdeep.MoneyMapr.dto.BudgetCorrectionData;
import com.devdeep.MoneyMapr.model.ElaborateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BudgetCorrectionService {

    public ElaborateData data  = new ElaborateData();

    public List<List<BudgetCorrectionData>> budgetCorrectionService(ElaborateData data) {

        List<List<BudgetCorrectionData>> ansList = new ArrayList<>();
        //want section......
        List<Double> lst = new ArrayList<>();
        List<Integer> priority = new ArrayList<>();
        List<String> name = new ArrayList<>();

        double userSubscriptionsAmount = data.getSubscriptionsAmount();
        lst.add(userSubscriptionsAmount);
        name.add("subscriptionsAmount");
        int userSubscriptionsPriority = data.getSubscriptionsPriority();
        priority.add(userSubscriptionsPriority);

        double userTravelAmount = data.getTravelAmount();
        lst.add(userTravelAmount);
        name.add("travelAmount");
        int userTravelPriority = data.getTravelPriority();
        priority.add(userTravelPriority);

        double userEntertainmentAmount= data.getEntertainmentAmount();
        lst.add(userEntertainmentAmount);
        name.add("entertainmentAmount");
        int userEntertainmentPriority = data.getEntertainmentPriority();
        priority.add(userEntertainmentPriority);

        double userDiningOutAmount= data.getDiningOutAmount();
        lst.add(userDiningOutAmount);
        name.add("diningOutAmount");
        int userDiningPriority = data.getDiningOutPriority();
        priority.add(userDiningPriority);

        double userLuxuryShoppingAmount= data.getLuxuryShoppingAmount();
        lst.add(userLuxuryShoppingAmount);
        name.add("luxuryShoppingAmount");
        int userLuxuryShoppingPriority = data.getLuxuryShoppingPriority();
        priority.add(userLuxuryShoppingPriority);

        double userGymAmount= data.getGymAmount();
        lst.add(userGymAmount);
        name.add("gymAmount");
        int userGymPriority = data.getGymPriority();
        priority.add(userGymPriority);

        List<Pair> pairs = new ArrayList<>();

        for(int i=0; i<lst.size(); i++){
            pairs.add(new Pair( name.get(i),lst.get(i),priority.get(i)) );
        }

        //sort pair in desc order by priority if priority same then sort by value....
        pairs.sort( (a,b) ->{

            if(b.priority != a.priority){
                return Integer.compare(a.priority, b.priority); // asc order by priority
            }
            else{
                return Double.compare(b.value, a.value);  //desc order by val
            }
        });

        /////////////////////////////// printing pairs list
        double totalSumOfWants = 0;
        for(Pair p : pairs){
            System.out.printf(p.name + " ");
            System.out.printf(p.value + " ");
            System.out.println(p.priority + " ");
            totalSumOfWants += p.value;
        }
        double idealSaving = data.getUserSalary()*0.2;
        double differenceInSaving = idealSaving - data.getUserSavings();

        System.out.println("diff In saving:  "+differenceInSaving);

        List<BudgetCorrectionData> ansPairs1 = new ArrayList<>();
        double sum = 0;
        int index = 0;

        while( totalSumOfWants > 0 && sum < differenceInSaving ){
            index = 0;
            while(index < pairs.size()){

                if(differenceInSaving <= sum){
                    break;
                }

                Pair pair = pairs.get(index++);
                int curPriority = pair.priority;
                String curName = pair.name;

                double curVal = 0;

                if(curPriority == 1){
                    curVal = (pair.value)*.5;
                }
                else if(curPriority == 2){
                    curVal = (pair.value)*.4;
                }
                else if(curPriority == 3){
                    curVal = (pair.value)*.3;
                }
                else if(curPriority == 4){
                    curVal = (pair.value)*.2;
                }
                else{
                    curVal = (pair.value)*.1;
                }
                // Check if already present and remove
                boolean replaced = false;
                for (int i = 0; i < ansPairs1.size(); i++) {
                    if (ansPairs1.get(i).getName().equals(curName)) {
                        ansPairs1.set(i, new BudgetCorrectionData(curName, curVal, curPriority));
                        replaced = true;
                        break;
                    }
                }

                if (!replaced) {
                    ansPairs1.add(new BudgetCorrectionData(curName, curVal, curPriority));
                }
                sum += curVal;
                totalSumOfWants -= curVal;

//                System.out.printf("totalSumOfWants: "+ totalSumOfWants);
//                System.out.println("    sum :  "+sum);
            }
        }


        System.out.println("sum from wants : "+sum);
//

        ///////////////////////////////////////////////////
        //Need section...
        List<BudgetCorrectionData> ansPairs2 = new ArrayList<>();
        if(sum < differenceInSaving){

            List<Double> input = new ArrayList<>();
            List<Integer> inputPriority = new ArrayList<>();
            List<String> inputName = new ArrayList<>();

            double userHousingAmount= data.getHousingAmount();
            input.add(userHousingAmount);
            inputName.add("housingAmount");
            int userHousingPriority = data.getHousingPriority();
            inputPriority.add(userHousingPriority);

            double userFoodAmount= data.getFoodAmount();
            input.add(userFoodAmount);
            inputName.add("foodAmount");
            int userFoodPriority = data.getFoodPriority();
            inputPriority.add(userFoodPriority);

            double userTransportationAmount= data.getTransportationAmount();
            input.add(userTransportationAmount);
            inputName.add("transportationAmount");
            int userTransportationPriority = data.getTransportationPriority();
            inputPriority.add(userTransportationPriority);

            double userUtilitiesAmount= data.getUtilitiesAmount();
            input.add(userUtilitiesAmount);
            inputName.add("utilitiesAmount");
            int userUtilitiesPriority = data.getUtilitiesPriority();
            inputPriority.add(userUtilitiesPriority);

            double userInsuranceAmount= data.getInsuranceAmount();
            input.add(userInsuranceAmount);
            inputName.add("insuranceAmount");
            int userInsurancePriority = data.getInsurancePriority();
            inputPriority.add(userInsurancePriority);

            double userLoanPaymentsAmount= data.getLoanPaymentsAmount();
            input.add(userLoanPaymentsAmount);
            inputName.add("loanPaymentsAmount");
            int userLoanPaymentsPriority = data.getLoanPaymentsPriority();
            inputPriority.add(userLoanPaymentsPriority);

            double userChildCareAmount= data.getChildCareAmount();
            input.add(userChildCareAmount);
            inputName.add("childCareAmount");
            int userChildCarePriority = data.getChildCarePriority();
            inputPriority.add(userChildCarePriority);

            List<Pair> pairs2 = new ArrayList<>();

            for(int i=0; i<input.size(); i++){
                pairs2.add(new Pair( inputName.get(i),input.get(i),inputPriority.get(i)) );
            }

            //sort pair in desc order by priority if priority same then sort by value....
            pairs2.sort( (a,b) ->{

                if(b.priority != a.priority){
                    return Integer.compare(a.priority, b.priority); // asc order by priority
                }
                else{
                    return Double.compare(b.value, a.value);  //desc order by val
                }
            });

            /////////////////////////////// printing pairs list
            double totalSumOfNeeds = 0;
            for(Pair p : pairs2){
                System.out.printf(p.value + " ");
                System.out.printf(p.priority + " ");
                System.out.println(p.name);
                totalSumOfNeeds += p.value;
            }

            double EightyPercentOfNeeds = totalSumOfNeeds*.8;
            while(totalSumOfNeeds > EightyPercentOfNeeds  && sum < differenceInSaving){
                index =0;
                while(index < pairs2.size()){

                    if(differenceInSaving <= sum){
                        break;
                    }

                    Pair pair = pairs2.get(index++);
                    int curPriority = pair.priority;
                    String curName = pair.name;
                    double curVal = 0;

                    if(curPriority == 1){
                        curVal = (pair.value)*.1;
                    }
                    else if(curPriority == 2){
                        curVal = (pair.value)*.07;
                    }
                    else if(curPriority == 3){
                        curVal = (pair.value)*.05;
                    }
                    else if(curPriority == 4){
                        curVal = (pair.value)*.003;
                    }
                    else{
                        curVal = (pair.value)*.001;
                    }
                    ansPairs2.add(new BudgetCorrectionData(curName,curVal,curPriority));
                    sum += curVal;
                    totalSumOfNeeds -= curVal;
                }
            }

            System.out.println("remaining sum are  fulfilled from needs : "+sum);
        }

        //add into saving section......................
        List<Double> savingInput = new ArrayList<>();
        List<Integer> savingPriority = new ArrayList<>();
        List<String> savingName = new ArrayList<>();

        double userEmergencyFundAmount= data.getEmergencyFundAmount();
        savingInput.add(userEmergencyFundAmount);
        savingName.add("emergencyFundAmount");
        int userEmergencyFundAmountPriority = data.getEmergencyFundPriority();
        savingPriority.add(userEmergencyFundAmountPriority);

        double userRetirementAmount= data.getRetirementAmount();
        savingInput.add(userRetirementAmount);
        savingName.add("retirementAmount");
        int userRetirementAmountPriority= data.getRetirementPriority();
        savingPriority.add(userRetirementAmountPriority);

        double userRealEstateAmount= data.getRealEstateAmount();
        savingInput.add(userRealEstateAmount);
        savingName.add("realEstateAmount");
        int userRealEstateAmountPriority= data.getRealEstatePriority();
        savingPriority.add(userRealEstateAmountPriority);

        List<Pair> pairs3 = new ArrayList<>();
        int prioritySum = 0;
        for(int i=0; i<savingInput.size(); i++){
            prioritySum += savingPriority.get(i);
            pairs3.add(new Pair( savingName.get(i),savingInput.get(i),savingPriority.get(i)) );
        }

        //sort pair in desc order by priority if priority same then sort by value....
        pairs3.sort( (a,b) ->{

            if(b.priority != a.priority){
                return Integer.compare(a.priority, b.priority); // asc order by priority
            }
            else{
                return Double.compare(b.value, a.value);  //desc order by val
            }
        });

        int idx = 0;

        List<BudgetCorrectionData> ansPairs3 = new ArrayList<>();

        while(idx < pairs3.size()){

            Pair pair = pairs3.get(idx++);
            int curPriority = pair.priority;
            String curName = pair.name;

            System.out.println(sum);
            double curVal = ((sum*curPriority)/prioritySum)*10000 / 10000;

            ansPairs3.add(new BudgetCorrectionData(curName,curVal,curPriority));
        }

        ansList.add(ansPairs1);
        ansList.add(ansPairs2);
        ansList.add(ansPairs3);

        return ansList;
    }
    static class Pair {
        String name;
        double value;
        int priority;

        Pair(String name, double value, int priority) {
            this.name = name;
            this.value = value;
            this.priority = priority;
        }
    }
}
