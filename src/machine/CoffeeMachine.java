package machine;

    /*
    * v2.0
    * Estimate the amount of servings
    * */

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cupsOfCoffee = 0;
        int waterStored = 0;
        int milkStored = 0;
        int coffeeStored = 0;
        final int waterNeeded = 200;
        final int milkNeeded = 50;
        final int coffeeNeed = 15;
        int waterServings = 0;
        int milkServings = 0;
        int coffeeServings = 0;
        int cupsServingsAvailable = 0;
        boolean waterSmallerMilk;
        boolean waterSmallerCoffee;
        boolean milkSmallerCoffee;

        System.out.println("Write how many ml of water the coffee machine has: ");
        waterStored = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        milkStored = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        coffeeStored = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        cupsOfCoffee = scanner.nextInt();

        waterServings = waterStored / waterNeeded;
        milkServings = milkStored / milkNeeded;
        coffeeServings = coffeeStored / coffeeNeed;

        waterSmallerMilk = waterServings < milkServings;
        waterSmallerCoffee = waterServings < coffeeServings;
        milkSmallerCoffee = milkServings < coffeeServings;

        cupsServingsAvailable = waterSmallerMilk && waterSmallerCoffee ? waterServings : milkSmallerCoffee ? milkServings : coffeeServings;

        if (cupsServingsAvailable == cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsServingsAvailable > cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (cupsServingsAvailable - cupsOfCoffee) + " more than that)");
        } else {
            System.out.println("No, I can make only " + cupsServingsAvailable + " cup(s) of coffee");
        }
    }
}
