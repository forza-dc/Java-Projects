import java.util.Scanner;

public class CappuccinoMakerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Cappuccino Maker App!");

        // Prompt for user input
        System.out.print("Enter the number of cups you want to make: ");
        int cups = scanner.nextInt();

        // Calculate ingredients based on the number of cups
        int espresso = cups * 1;
        int milk = cups * 1;
        int foam = cups * 1;

        // Display the recipe
        System.out.println("\n=== Recipe for Cappuccino ===");
        System.out.println("Espresso: " + espresso + " shots");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Foam: " + foam + " ml");

        // Prompt the user to start making the cappuccino
        System.out.print("\nStart making cappuccino? (Y/N): ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("Y")) {
            System.out.println("\nMaking " + cups + " cups of cappuccino...");
            // TODO: Implement the logic for making the cappuccino here

            System.out.println("Cappuccino is ready! Enjoy your drink!");
        } else {
            System.out.println("Cappuccino making cancelled.");
        }

        scanner.close();
    }
}
