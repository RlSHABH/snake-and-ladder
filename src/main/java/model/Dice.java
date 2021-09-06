package model;


import utils.RandomUtils;

public class Dice {
    final String name;
     final int minValue;
     final int maxValue;

   public Dice(int maxValue,int minValue,String name){
            this.minValue=minValue;
            this.maxValue=maxValue;
            this.name=name;
   }
    public String getName() {
        return name;
    }

    public int roll() {
        return RandomUtils.getRandomNumberUsingNextInt(minValue, maxValue + 1);
    }
}
