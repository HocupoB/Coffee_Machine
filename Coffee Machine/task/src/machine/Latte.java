package machine;

public class Latte implements Coffee {
    final int WATER = 350 ;
    final int MILK = 75;
    final int BEANS = 20;
    final int PRICE = 7;

    public int getBEANS() {
        return BEANS;
    }

    public int getMILK() {
        return MILK;
    }

    public int getWATER() {
        return WATER;
    }

    public int getPRICE() {
        return PRICE;
    }
}
