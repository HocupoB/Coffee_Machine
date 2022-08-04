package machine;

public class Cappuchino implements Coffee {
    final int WATER = 200 ;
    final int MILK = 100;
    final int BEANS = 12;
    final int PRICE = 6;

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
