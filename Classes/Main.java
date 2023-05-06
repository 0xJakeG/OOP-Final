import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a User object
        User user = new User();
        UserQuestions.setName(user);
        UserQuestions.setAge(user);
        UserQuestions.setRetirementAge(user);
        UserQuestions.setCurrentSavings(user);
        UserQuestions.setEstimatedExpenses(user);
        UserQuestions.handleAnnualIncomeQuestion(user);
        UserQuestions.handleIncomeGrowthRateQuestion(user);
        UserQuestions.handleSocialSecurityBenefitsQuestion(user);
        UserQuestions.handleDesiredRetirementIncomeQuestion(user);
        UserQuestions.handleInvestmentRateOfReturnQuestion(user);
        UserQuestions.handleInflationRateQuestion(user);
        UserQuestions.handleLifeExpectancyQuestion(user);

        // Ask if they have a 401k
        UserQuestions.handle401kQuestion(user);
        UserQuestions.handle401kContributionQuestion(user);

        // Handle the Roth IRA question
        UserQuestions.handleRothIraQuestion(user);
        UserQuestions.handleRothIraContributionQuestion(user);

        // Handle the annual savings contribution question
        UserQuestions.handleSavingsContributionQuestion(user);

        // Create a RetirementCalculator object
        RetirementCalculator retirementCalculator = new RetirementCalculator(user);

        // Display results
        System.out.println("----- Retirement Analysis -----");
        System.out.printf("Hello, %s! Here is your retirement analysis based on the information you provided:%n%n", user.getName());

        System.out.printf("Estimated future value of your savings: $%,.2f%n", retirementCalculator.calculateFutureValue());
        System.out.printf("Required savings to meet your retirement goal: $%,.2f%n", retirementCalculator.calculateRequiredSavings());
        System.out.printf("Projected monthly withdrawal amount: $%,.2f%n", retirementCalculator.calculateWithdrawalAmount());
        System.out.printf("Projected retirement duration: %.2f years%n", retirementCalculator.calculateRetirementDuration());

        if (retirementCalculator.canReachRetirementGoal()) {
            System.out.println("Congratulations! You are on track to meet your retirement goal!");
        } else {
            System.out.printf("It looks like you might fall short of your retirement goal by $%,.2f. You may need to adjust your savings or expenses to close the gap.%n", Math.abs(retirementCalculator.retirementGoalDifference()));
        }

    }
}





