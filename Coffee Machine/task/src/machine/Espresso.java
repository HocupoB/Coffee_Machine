package machine;

public class Espresso implements Coffee {
    final int WATER = 250 ;
    final int MILK = 0;
    final int BEANS = 16;
    final int PRICE = 4;


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
