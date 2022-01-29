package com.company;

public class PercentageTester {
    public static void main(String[] args){
        int count=0;
        CoinTossSimulator cs = new CoinTossSimulator();
        for(int i=0;i<20000;i++){
            cs.run(50);
            //System.out.println("2H:"+cs.getTwoHeadsPercent()+" 2t: "+cs.getTwoTailsPercent()+" ht: "+cs.getTailHeadPercent());
            if (Math.abs(25 - cs.getTwoHeadsPercent()) > 2 || Math.abs(25 - cs.getTwoHeadsPercent()) > 2 ||
                    Math.abs(50 - cs.getTailHeadPercent()) > 2) {
                continue;

            }
            else {
                count++;
            }
        }
        System.out.printf("count:"+count);

    }
}

