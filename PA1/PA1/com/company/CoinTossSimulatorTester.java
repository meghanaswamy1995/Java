package com.company;

public class CoinTossSimulatorTester {
    public static void main(String[] args){
        int numTrials;
        int twoHeads;
        int twoTails;
        int tailhead;
        boolean correctTosses=false;
        int totalTosses;
        int twoHeadPercent;


        CoinTossSimulator toss = new CoinTossSimulator();
            System.out.println("After constructor: ");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
            //printTestOutput(numTrials,twoHeads,twoTails,tailhead,0);

         toss.run(1);
            System.out.println("\nAfter run(1): \n");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
            //printTestOutput(numTrials,twoHeads,twoTails,tailhead,1);

        toss.run(10);
            System.out.println("After run(10): ");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
            //printTestOutput(numTrials,twoHeads,twoTails,tailhead,11);


        toss.run(100);
            System.out.println("\nAfter run(100)\n");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
            twoHeadPercent = toss.getTwoHeadsPercent();
            printTestOutput(numTrials,twoHeads,twoTails,tailhead,111, twoHeadPercent);

        toss.reset();
            System.out.println("\nAfter Reset\n");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
           // printTestOutput(numTrials,twoHeads,twoTails,tailhead,0);

    }

    public static void printTestOutput(int numoftrials, int twoHead, int twoTail, int headtail, int exp_val, int twoHeadPercent){
        int numTrials;
        int twoHeads;
        int twoTails;
        int tailhead;
        int totalTosses;
        boolean correctTosses=false;
        //int runsNum = runNum;


        //System.out.println("\nAfter run("+runsNum+")\n");

        System.out.print("Number of trials [exp:"+exp_val+"]: "+numoftrials);

        System.out.print("\nTwo-head tosses: "+twoHead);

        System.out.print("\nTwo-tail tosses: "+twoTail);

        System.out.print("\nOne-head one-Tail tosses: "+headtail);
        System.out.print("\ntwo head percent : "+ twoHeadPercent+"%");

        totalTosses = twoHead+twoTail+headtail;
        if(totalTosses == numoftrials) { correctTosses = true; }
        System.out.println("\nTosses add up correctly? "+ correctTosses);
    }
}
