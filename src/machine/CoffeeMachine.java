package machine;

    /*
    * v3.0
    * Buy, fill and take features
    *
    * */

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stored = {400, 540, 120, 9, 550};
        String option;

        printState(stored);

        System.out.println("Write action (buy, fill, take): ");
        option = scanner.next();

        switch (option) {
            case "buy" -> buy(scanner, stored);
            case "fill" -> fill(scanner, stored);
            case "take" -> updateState("take", stored, stored);
            default -> System.out.println("Enter a valid option!");
        }

    }

    public static void printState(int[] storedIngredients) {
        System.out.println("The coffee machine has: ");
        System.out.println(storedIngredients[0] + " ml of water");
        System.out.println(storedIngredients[1] + " ml of milk");
        System.out.println(storedIngredients[2] + " g of coffee beans");
        System.out.println(storedIngredients[3] + " disposable cups");
        System.out.println("$" + storedIngredients[4] + " of money");
    }

    public static void buy(Scanner scanner, int[] stored) {
        int variety;
        int[] espresso = {250, 0, 16, 0, 4};
        int[] latte = {350, 75, 20, 0, 7};
        int[] cappuccino = {200, 100, 12, 0, 6};

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        variety = scanner.nextInt();

        switch (variety) {
            case 1 -> updateState("buy", stored, espresso);
            case 2 -> updateState("buy", stored, latte);
            case 3 -> updateState("buy", stored, cappuccino);
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
                printState(stored);
            }
            case "fill" -> {
                stored[0] += quantity[0];
                stored[1] += quantity[1];
                stored[2] += quantity[2];
                stored[3] += quantity[3];
                printState(stored);
            }
            case "take" -> {
                stored[4] = 0;
                System.out.println("I gave you " + stored[4]);
                printState(stored);
            }
        }
    }

}
