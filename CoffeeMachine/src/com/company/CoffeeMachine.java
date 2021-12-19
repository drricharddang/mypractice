package com.company;

import java.util.Scanner;

public class CoffeeMachine {
    static final Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int bean = 120;
    static int cups = 9;
    static int money = 550;

    enum CoffeeType {
        ESPRESSO (1,250, 0, 16, 4)
        , LATTE (2, 350, 75, 2, 7)
        , CAPPUCCINO (3,200, 100, 121, 6);

        final int menuNumber;
        final int water;
        final int milk;
        final int bean;
        final int price;

        CoffeeType (int menuNumber, int water, int milk, int bean, int price) {
            this.menuNumber = menuNumber;
            this.water = water;
            this.milk = milk;
            this.bean = bean;
            this.price = price;
        }

        public static CoffeeType getCoffeeType (int menuSelected) {
            CoffeeType coffeeType = null;
            for (CoffeeType v: CoffeeType.values()
            ) {
                if (v.menuNumber == menuSelected) {
                    coffeeType = v;
                }
            }
            return coffeeType;
        }
    }

    static boolean checkCoffeeResource (CoffeeType coffeeSelected) {
        boolean enoughResource = false;

        if (coffeeSelected.water > water) {
            System.out.println("Sorry, not enough water!");
        } else if (coffeeSelected.milk > milk ) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeSelected.bean > bean) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups == 0) {
            System.out.println("Sorry, not enough cups!");
        } else enoughResource = true;

        return enoughResource;
    }

    static void makeCoffee(CoffeeType coffeeSelected) {
        System.out.println("I have enough resources, making you a coffee!");
        water -= coffeeSelected.water;
        milk -= coffeeSelected.milk;
        bean -= coffeeSelected.bean;
        cups--;
        money += coffeeSelected.price;
    }

    static void fillResource() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        bean += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
    }

    static void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    static void printStatus() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                bean + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money\n");
    }

    public static void main(String[] args) {
        String option = "";

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            option = scanner.next();

            switch (option) {
                case "buy": {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String response = scanner.next();

                    if (response.equals("back")) {
                        break;
                    }

                    CoffeeType coffeeSelected = CoffeeType.getCoffeeType(Integer.parseInt(response));

                    boolean enoughResource = checkCoffeeResource(coffeeSelected);

                    if (enoughResource) { // check if enough resource, then make coffee and collect money
                        makeCoffee(coffeeSelected);
                    }
                    break;
                }

                case "fill": {
                    fillResource();
                    break;
                }

                case "take": {
                    takeMoney();
                    break;
                }

                case "remaining": {
                    printStatus();
                    break;
                }
            }
        } while (!option.equals("exit"));
    }
}
