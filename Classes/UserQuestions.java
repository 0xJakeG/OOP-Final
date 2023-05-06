import java.util.Scanner;

public class UserQuestions {

    public static void setName(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        user.setName(name);
    }

    public static void setAge(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();
        user.setAge(age);
    }

    public static void setRetirementAge(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your retirement age: ");
        int retirementAge = scanner.nextInt();
        user.setRetirementAge(retirementAge);
    }

    public static void setCurrentSavings(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your current savings: ");
        double currentSavings = scanner.nextDouble();
        user.setCurrentSavings(currentSavings);
    }

    public static void handleAnnualIncomeQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your current annual income: ");
        double annualIncome = scanner.nextDouble();
        user.setAnnualIncome(annualIncome);
    }

    public static void handleIncomeGrowthRateQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your expected annual income growth rate (in percentage): ");
        double incomeGrowthRate = scanner.nextDouble();
        user.setIncomeGrowthRate(incomeGrowthRate);
    }

    public static void handleSocialSecurityBenefitsQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the expected monthly social security benefits during retirement: ");
        double socialSecurityBenefits = scanner.nextDouble();
        user.setSocialSecurityBenefits(socialSecurityBenefits);
    }

    public static void handleDesiredRetirementIncomeQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your desired yearly retirement income: ");
        double desiredRetirementIncome = scanner.nextDouble();
        user.setDesiredRetirementIncome(desiredRetirementIncome);
    }
    
    

    public static void handleInvestmentRateOfReturnQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your expected annual investment rate of return (in percentage): ");
        double investmentRateOfReturn = scanner.nextDouble();
        user.setInvestmentRateOfReturn(investmentRateOfReturn);
    }

    public static void handleInflationRateQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the expected annual inflation rate (in percentage): ");
        double inflationRate = scanner.nextDouble();
        user.setInflationRate(inflationRate);
    }

    public static void handleLifeExpectancyQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of years you expect to live during retirement: ");
        int lifeExpectancy = scanner.nextInt();
        user.setLifeExpectancy(lifeExpectancy);
    }

    public static void handle401kQuestion(User user) {
        // Create a Question object for the 401k question
        Question has401kQuestion = new Question("Do you have a 401k? (Enter 'yes' or 'no')", "yes");
    
        // Ask the question
        has401kQuestion.askQuestion();
    
        // Get the user's answer
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
    
        // Check if the user has a 401k
        boolean has401k = has401kQuestion.isAnswerCorrect(userAnswer);
    
        if (has401k) {
            System.out.print("Enter the total amount in your 401k(s) in dollars: ");
            double total401kAmount = scanner.nextDouble();
            user.setTotal401kAmount(total401kAmount);
            //System.out.println("You have $" + total401kAmount + " in your 401k(s).");
        } else {
            String link = "https://www.irs.gov/retirement-plans/401k-plans";
            System.out.println("You don't have a 401k. To learn more about 401ks, visit: " + link);
        }
    }
    
    public static void handleRothIraQuestion(User user) {
        // Create a Question object for the Roth IRA question
        Question hasRothIraQuestion = new Question("Do you have a Roth IRA? (Enter 'yes' or 'no')", "yes");
    
        // Ask the question
        hasRothIraQuestion.askQuestion();
    
        // Get the user's answer
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
    
        // Check if the user has a Roth IRA
        boolean hasRothIra = hasRothIraQuestion.isAnswerCorrect(userAnswer);
    
        if (hasRothIra) {
            System.out.print("Enter the total amount in your Roth IRA(s) in dollars: ");
            double totalRothIraAmount = scanner.nextDouble();
            user.setTotalRothIraAmount(totalRothIraAmount);
            //System.out.println("You have $" + totalRothIraAmount + " in your Roth IRA(s).");
        } else {
            String link = "https://investor.vanguard.com/accounts-plans/iras/roth-ira";
            System.out.println("You don't have a Roth IRA. To learn more about Roth IRAs, visit: " + link);
        }
    }

    public static void setEstimatedExpenses(User user) {
        double estimatedExpenses = ExpenseCalculator.calculateEstimatedExpenses();
        user.setMonthlyExpenses(estimatedExpenses);
    }

    public static void handle401kContributionQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much do you plan to contribute to your 401k annually (in dollars)? ");
        double annual401kContribution = scanner.nextDouble();
        user.setAnnual401kContribution(annual401kContribution);
    }
    
    public static void handleRothIraContributionQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much do you plan to contribute to your Roth IRA annually (in dollars)? ");
        double annualRothIraContribution = scanner.nextDouble();
        user.setAnnualRothIraContribution(annualRothIraContribution);
    }
    
    public static void handleSavingsContributionQuestion(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much do you plan to contribute to your savings annually (in dollars)? ");
        double annualSavingsContribution = scanner.nextDouble();
        user.setAnnualSavingsContribution(annualSavingsContribution);
    }
    
    
}
