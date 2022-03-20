package machine;

/*
 * v4.0
 * Keep track of the supplies
 *
 * */

import java.sql.SQLOutput;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        int[] resources = {400, 540, 120, 9, 550};
        String option = "";

        while (!option.equals("exit")) {
            option = mainCycle(resources, option);
        }
    }

    public static String mainCycle(int[] resources, String option) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        option = scanner.next();

        switch (option) {
            case "buy" -> buy(scanner, resources, option);
            case "fill" -> fill(scanner, resources);
            case "take" -> updateState("take", resources, resources);
            case "remaining" -> printState(resources);
            case "exit" -> System.out.println("Turning machine off...");
            default -> System.out.println("Enter a valid option!");
        }

        return option;
    }

    public static void printState(int[] storedIngredients) {
        System.out.println("The coffee machine has: ");
        System.out.println(storedIngredients[0] + " ml of water");
        System.out.println(storedIngredients[1] + " ml of milk");
        System.out.println(storedIngredients[2] + " g of coffee beans");
        System.out.println(storedIngredients[3] + " disposable cups");
        System.out.println("$" + storedIngredients[4] + " of money");
    }

    public static void buy(Scanner scanner, int[] stored, String option) {
        String variety;
        int[] espresso = {250, 0, 16, 0, 4};
        int[] latte = {350, 75, 20, 0, 7};
        int[] cappuccino = {200, 100, 12, 0, 6};

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        variety = scanner.next();

        switch (variety) {
            case "1" -> System.out.println(estimateServings(stored, espresso));
            case "2" -> System.out.println(estimateServings(stored, latte));
            case "3" -> System.out.println(estimateServings(stored, cappuccino));
            case "back" -> mainCycle(stored, option);
            default -> System.out.println("Invalid option!");
        }
    }

    public static void fill(Scanner scanner, int[] stored) {
        int[] fill = new int[5];

        System.out.println("Write how many ml of water you want to add: ");
        fill[0] = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        fill[1] = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        fill[2] = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        fill[3] = scanner.nextInt();

        updateState("fill", stored, fill);
    }

    public static void updateState(String action, int[] stored, int[] quantity) {
        switch (action) {
            case "buy" -> {
                stored[0] -= quantity[0];
                stored[1] -= quantity[1];
                stored[2] -= quantity[2];
                stored[3]--;
                stored[4] += quantity[4];
            }
            case "fill" -> {
                stored[0] += quantity[0];
                stored[1] += quantity[1];
                stored[2] += quantity[2];
                stored[3] += quantity[3];
            }
            case "take" -> {
                System.out.println("I gave you $" + stored[4]);
                stored[4] = 0;
            }
        }
    }

    public static String estimateServings(int[] resources, int[] drinkType) {
        int waterServings;
        int milkServings;
        int coffeeServings;
        boolean waterSmallerMilk;
        boolean waterSmallerCoffee;
        boolean milkSmallerCoffee;

        if (drinkType[1] == 0) {
            waterServings = resources[0] / drinkType[0];
            coffeeServings = resources[2] / drinkType[2];

            if (waterServings < coffeeServings && waterServings <= 0) {
                return "Sorry, not enough water!";
            } else if (coffeeServings <= 0) {
                return "Sorry, not enough coffee!";
            }

            updateState("buy", resources, drinkType);
            return "I have enough resources, making you a coffee!\n";
        }

        waterServings = resources[0] / drinkType[0];
        milkServings = resources[1] / drinkType[1];
        coffeeServings = resources[2] / drinkType[2];

        waterSmallerMilk = waterServings < milkServings;
        waterSmallerCoffee = waterServings < coffeeServings;
        milkSmallerCoffee = milkServings < coffeeServings;

        if (waterSmallerMilk && waterSmallerCoffee && waterServings <= 0) {
            return "Sorry, not enough water!\n";
        } else if (!waterSmallerMilk && milkSmallerCoffee && milkServings <= 0) {
            return "Sorry, not enough milk!\n";
        } else if (coffeeServings <= 0) {
            return "Sorry, not enough coffee!\n";
        } else if (resources[3] <= 0) {
            return "Sorry, not enough cups\n";
        }

        updateState("buy", resources, drinkType);
        return "I have enough resources, making you a coffee!\n";
    }
}



