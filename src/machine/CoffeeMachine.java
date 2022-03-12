package machine;

    /*
    * v1.2
    * Estimate the amount of servings
    *
    * 1 cup of coffee
    *   200 ml of watter
    *   50 ml of milk
    *   15g of coffee beans
    *
    * */

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cupsOfCoffee = 0;
        int waterStored = 0;
        int milkStored = 0;
        int coffeeBeansStored = 0;

        System.out.println("Write how many ml of water the coffee machine has: ");
        waterStored = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        milkStored = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        coffeeBeansStored = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        cupsOfCoffee = scanner.nextInt();

       calculateIngredients(cupsOfCoffee);
    }

    public static int estimateServings(int waterStored, int milkStored, int coffeeBeansStored) {

        return 0;
    }

    public static void calculateIngredients(int cupsOfCoffee) {
        int water = 200;
        int milk = 50;
        int coffee = 15;

        water *= cupsOfCoffee;
        milk *= cupsOfCoffee;
        coffee *= cupsOfCoffee;

        System.out.println("For " + cupsOfCoffee + " cups of coffee you will need: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + "g of coffee beans");
    }
}
