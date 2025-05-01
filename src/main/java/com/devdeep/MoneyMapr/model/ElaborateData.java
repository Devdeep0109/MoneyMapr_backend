    package com.devdeep.MoneyMapr.model;

    import lombok.*;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class ElaborateData {

        // ===== Needs Section =====
        private double housingAmount;
        private int housingPriority;

        private double foodAmount;
        private int foodPriority;

        private double transportationAmount;
        private int transportationPriority;

        private double utilitiesAmount;
        private int utilitiesPriority;

        private double insuranceAmount;
        private int insurancePriority;

        private double loanPaymentsAmount;
        private int loanPaymentsPriority;

        private double childCareAmount;
        private int childCarePriority;

        // ===== Wants Section =====

        private double subscriptionsAmount;
        private int subscriptionsPriority;

        private double travelAmount;
        private int travelPriority;

        private double entertainmentAmount;
        private int entertainmentPriority;

        private double diningOutAmount;
        private int diningOutPriority;

        private double luxuryShoppingAmount;
        private int luxuryShoppingPriority;

        private double gymAmount;
        private int gymPriority;

        // ===== Savings Section =====

        private double emergencyFundAmount;
        private int emergencyFundPriority;


        private double retirementAmount;
        private int retirementPriority;

        private double realEstateAmount;
        private int realEstatePriority;

        private double userSavings;
        private double userSalary;
}
