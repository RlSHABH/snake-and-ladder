package model;


import utils.RandomUtils;

public class CrookedDice extends Dice {

    public CrookedDice(int maxValue, int minValue, String diceName) {
        super(maxValue, minValue,diceName);
    }

    public int roll() {
        int value= RandomUtils.getRandomNumberUsingNextInt(minValue, maxValue + 1);
        if(value%2!=0){
            value+=1;
        }
        return value;
    }
}
