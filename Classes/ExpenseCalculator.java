import java.util.Scanner;

public class ExpenseCalculator {
    private User user;

    // Constructor
    public ExpenseCalculator(User user) {
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
    public static double calculateEstimatedExpenses() {
        Scanner scanner = new Scanner(System.in);
        double totalExpenses = 0;

        System.out.print("Do you know your total monthly expenses during retirement? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("Enter your total monthly expenses during retirement: ");
            totalExpenses = scanner.nextDouble();
        } else {
            System.out.print("Enter your estimated monthly mortgage or rent payments during retirement: ");
            double mortgageOrRent = scanner.nextDouble();

            System.out.print("Enter your estimated monthly food expenses during retirement: ");
            double food = scanner.nextDouble();

            System.out.print("Enter your estimated monthly transportation expenses during retirement (e.g., car, public transport): ");
            double transportation = scanner.nextDouble();

            System.out.print("Enter your estimated monthly utility expenses during retirement (e.g., electricity, water, gas): ");
            double utilities = scanner.nextDouble();

            System.out.print("Enter your estimated monthly healthcare expenses during retirement: ");
            double healthcare = scanner.nextDouble();

            System.out.print("Enter your estimated monthly insurance expenses during retirement (e.g., home, car, life, health): ");
            double insurance = scanner.nextDouble();

            System.out.print("Enter your estimated monthly entertainment expenses during retirement: ");
            double entertainment = scanner.nextDouble();

            System.out.print("Enter any other estimated monthly expenses during retirement: ");
            double other = scanner.nextDouble();

            totalExpenses = mortgageOrRent + food + transportation + utilities + healthcare + insurance + entertainment + other;
        }

        return totalExpenses;
    }
}