public class RetirementCalculator {
    private User user;

    // Constructor
    public RetirementCalculator(User user) {
        this.user = user;
    }

    // Getters
    public User getUser() {
        return user;
    }

    // Setters
    public void setUser(User user) {
        this.user = user;
    }

    // Methods
    public double calculateTotalSavings(double... savingsAmounts) {
        double totalSavings = 0;

        for (double savingsAmount : savingsAmounts) {
            totalSavings += savingsAmount;
        }

        return totalSavings;
    }

    public double calculateFutureValue() {
        // Calculate the number of years until retirement
        int yearsToRetirement = user.getRetirementAge() - user.getAge();
        
        // Calculate the annual contributions to each account type that are growing with interest
        double annual401kContributionsGrowing = user.getAnnual401kContribution() * (Math.pow(1 + user.getInvestmentRateOfReturn() / 100, yearsToRetirement) - Math.pow(1 + user.getIncomeGrowthRate() / 100, yearsToRetirement)) / (user.getInvestmentRateOfReturn() / 100 - user.getIncomeGrowthRate() / 100);
        double annualRothIraContributionsGrowing = user.getAnnualRothIraContribution() * (Math.pow(1 + user.getInvestmentRateOfReturn() / 100, yearsToRetirement) - Math.pow(1 + user.getIncomeGrowthRate() / 100, yearsToRetirement)) / (user.getInvestmentRateOfReturn() / 100 - user.getIncomeGrowthRate() / 100);
        double annualSavingsContributionsGrowing = user.getAnnualSavingsContribution() * (Math.pow(1 + user.getInvestmentRateOfReturn() / 100, yearsToRetirement) - Math.pow(1 + user.getIncomeGrowthRate() / 100, yearsToRetirement)) / (user.getInvestmentRateOfReturn() / 100 - user.getIncomeGrowthRate() / 100);
        
        // Calculate the future value of each account type
        double future401kValue = user.getTotal401kAmount() * Math.pow(1 + user.getInvestmentRateOfReturn() / 100, yearsToRetirement) + annual401kContributionsGrowing;
        double futureRothIraValue = user.getTotalRothIraAmount() * Math.pow(1 + user.getInvestmentRateOfReturn() / 100, yearsToRetirement) + annualRothIraContributionsGrowing;
        double futureSavingsValue = user.getCurrentSavings() * Math.pow(1 + user.getInvestmentRateOfReturn() / 100, yearsToRetirement) + annualSavingsContributionsGrowing;
        
        // Return the sum of the future values for all account types
        return future401kValue + futureRothIraValue + futureSavingsValue;
    }
    
    
    

    public double calculateRequiredSavings() {
        // Calculate the number of years until retirement
        int yearsToRetirement = user.getRetirementAge() - user.getAge();
        
        // Adjust the desired retirement income for inflation
        double inflationAdjustedDesiredIncome = user.getDesiredRetirementIncome() * Math.pow(1 + user.getInflationRate() / 100, yearsToRetirement);
        
        // Calculate the required savings to achieve the desired retirement income
        double requiredSavings = (inflationAdjustedDesiredIncome - (user.getSocialSecurityBenefits() * 12)) * (1 - Math.pow(1 + user.getInvestmentRateOfReturn() / 100, -user.getLifeExpectancy())) / (user.getInvestmentRateOfReturn() / 100);
        
        // Ensure the required savings value is non-negative
        return Math.max(requiredSavings, 0);
    }
    
    public double calculateWithdrawalAmount() {
        // Calculate the required savings to achieve the desired retirement income
        double requiredSavings = calculateRequiredSavings();
        
        // Calculate the monthly withdrawal amount based on the required savings and life expectancy
        double withdrawalAmount = (requiredSavings / (user.getLifeExpectancy() * 12));
        
        // Ensure the withdrawal amount is non-negative
        double adjustedWithdrawalAmount = Math.max(withdrawalAmount, 0);
        
        // Return the adjusted withdrawal amount
        return adjustedWithdrawalAmount;
    }
    
    
    

    public double calculateRetirementDuration() {
        // Calculate future value and withdrawal amount
        double futureValue = calculateFutureValue();
        double withdrawalAmount = calculateWithdrawalAmount();
        double totalAnnualWithdrawal = withdrawalAmount * 12;
        
        // Calculate retirement duration based on future value and total annual withdrawal
        double retirementDuration = futureValue / totalAnnualWithdrawal;
        
        // Return the calculated retirement duration
        return retirementDuration;
    }
    
    public boolean canReachRetirementGoal() {
        // Calculate the required savings and future value
        double requiredSavings = calculateRequiredSavings();
        double futureValue = calculateFutureValue();
        
        // Determine if the future value is greater than or equal to the required savings
        return futureValue >= requiredSavings;
    }
    
    public double retirementGoalDifference() {
        // Calculate the required savings and future value
        double requiredSavings = calculateRequiredSavings();
        double futureValue = calculateFutureValue();
        
        // Calculate the difference between the future value and the required savings
        return futureValue - requiredSavings;
    }
    
    public void updateSavingsOnIncomeIncrease(double newIncome) {
        // Calculate the percentage increase in income and the resulting increase in savings
        double percentageIncrease = (newIncome - user.getAnnualIncome()) / user.getAnnualIncome() * 100;
        double savingsIncrease = percentageIncrease * user.getAnnualSavingsContribution() / 100;
        
        // Adjust the annual savings contribution based on the new income and savings increase
        double annualSavingsContribution = user.getAnnualSavingsContribution() * Math.pow(1 + user.getIncomeGrowthRate() / 100, user.getRetirementAge() - user.getAge());
        double adjustedAnnualSavingsContribution = annualSavingsContribution + savingsIncrease;
        
        // Update the user's income and savings contribution
        user.setAnnualIncome(newIncome);
        user.setAnnualSavingsContribution(adjustedAnnualSavingsContribution);
        
        // Adjust the desired retirement income based on inflation
        double adjustedDesiredRetirementIncome = user.getDesiredRetirementIncome() * Math.pow(1 + user.getInflationRate() / 100, user.getRetirementAge() - user.getAge());
        user.setDesiredRetirementIncome(adjustedDesiredRetirementIncome);
    }
    
    
}

