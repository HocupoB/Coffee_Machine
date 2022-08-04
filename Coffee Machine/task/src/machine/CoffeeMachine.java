package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner;
    private int totalWater = 400;
    private int totalMilk = 540;
    private int totalBeans = 120;
    private int totalCups = 9;
    private int totalProfit = 550;

    public void chooseAction() {
        while(true){
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    showIngredients();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong action!");
                    return;

            }
        }
    }
    public void buy() {
        scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();
        if(!coffeeType.equals("back")) {
            Coffee coffee = chooseType(Integer.parseInt(coffeeType));
            if (coffee.getWATER() <= getTotalWater() && coffee.getMILK() <= getTotalMilk() &&
                    coffee.getBEANS() <= getTotalBeans() && getTotalCups() > 0) {
                setTotalWater(getTotalWater() - coffee.getWATER());
                setTotalMilk(getTotalMilk() - coffee.getMILK());
                setTotalBeans(getTotalBeans() - coffee.getBEANS());
                setTotalProfit(getTotalProfit() + coffee.getPRICE());
                setTotalCups(getTotalCups() - 1);
                System.out.println("I have enough resources, making you a coffee!");
            } else {
                if(coffee.getWATER() > getTotalWater())
                    System.out.println("Sorry, not enough water!");
                else if(coffee.getMILK() > getTotalMilk())
                    System.out.printf("Sorry, not enough milk!");
                else if(coffee.getBEANS() > getTotalBeans())
                    System.out.println("Sorry, not enough milk!");
                else
                    System.out.println("Sorry, not enough disposable cups!");
            }

        }
    }
    public void fill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        setTotalWater(sc.nextInt() + getTotalWater());
        System.out.println("Write how many ml of milk you want to add: ");
        setTotalMilk(sc.nextInt() + getTotalMilk());
        System.out.println("Write how many grams of coffee beans you want to add:");
        setTotalBeans(sc.nextInt() + getTotalBeans());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        setTotalCups(sc.nextInt() + getTotalCups());

    }
    public void take() {
        System.out.println("I gave you " + getTotalProfit());
        setTotalProfit(0);
    }

    public void showIngredients() {
        System.out.println( "\nThe coffee machine has:\n" +
                getTotalWater() + " ml of water\n" +
                getTotalMilk() + " ml of milk\n" +
                getTotalBeans() + " g of coffee beans\n" +
                getTotalCups() + " disposable cups\n$" +
                getTotalProfit() + " of money");
    }

    public Coffee chooseType(int coffeeType) {

        switch (coffeeType) {
            case 1:
                return new Espresso();
            case 2:
                return new Latte();
            case 3:
                return new Cappuchino();
            default:
                throw new IllegalArgumentException(
                        "Wrong coffee type!");
        }
    }





    public int getTotalWater() {
        return totalWater;
    }

    public int getTotalMilk() {
        return totalMilk;
    }

    public int getTotalBeans() {
        return totalBeans;
    }

    public int getTotalCups() {
        return totalCups;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public void setTotalWater(int totalWater) {
        this.totalWater = totalWater;
    }

    public void setTotalMilk(int totalMilk) {
        this.totalMilk = totalMilk;
    }

    public void setTotalBeans(int totalBeans) {
        this.totalBeans = totalBeans;
    }

    public void setTotalCups(int totalCups) {
        this.totalCups = totalCups;
    }

    public void setTotalProfit(int totalProfit) {
        this.totalProfit = totalProfit;
    }




    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.chooseAction();


    }
}
