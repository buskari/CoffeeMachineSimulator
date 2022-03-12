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
        int cupsOfCoffee;

        System.out.println("Write how many cups of coffee you will need:");
        cupsOfCoffee = scanner.nextInt();

       calculateIngredients(cupsOfCoffee);
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
