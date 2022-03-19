package com.company;

/**
 CoinTossSimulatorTester, the tester code to test the CoinTossSimulator class.
 */
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
            printTestOutput(numTrials,twoHeads,twoTails,tailhead,0); 

         toss.run(1);
            System.out.println("\nAfter run(1): \n");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
            printTestOutput(numTrials,twoHeads,twoTails,tailhead,1);

        toss.run(10);
            System.out.println("After run(10): ");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
            printTestOutput(numTrials,twoHeads,twoTails,tailhead,11);


        toss.run(100);
            System.out.println("\nAfter run(100)\n");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
            twoHeadPercent = toss.getTwoHeadsPercent();
            printTestOutput(numTrials,twoHeads,twoTails,tailhead,111);

        toss.reset();
            System.out.println("\nAfter Reset\n");
            numTrials = toss.getNumTrials();
            twoHeads = toss.getTwoHeads();
            twoTails = toss.getTwoTails();
            tailhead = toss.getHeadTails();
            printTestOutput(numTrials,twoHeads,twoTails,tailhead,0);

    }
    /**
     PrintTestOutput function to just print out all the statements from tester code.
     Also checks if each individual output counts match with the total number of trials.
     @param numoftrials  number of trails given as input.
     @param twoHead count of tosses which came up as two heads
     @param twoTail count of tosses which came up as two tails
     @param headtail count of tosses which came up as a head and a tail
     @param exp_val expected value
     */
    public static void printTestOutput(int numoftrials, int twoHead, int twoTail, int headtail, int exp_val){
        int numTrials;
        int twoHeads;
        int twoTails;
        int tailhead;
        int totalTosses;
        boolean correctTosses=false;

        //System.out.println("\nAfter run("+runsNum+")\n");

        System.out.print("Number of trials [exp:"+exp_val+"]: "+numoftrials);

        System.out.print("\nTwo-head tosses: "+twoHead);

        System.out.print("\nTwo-tail tosses: "+twoTail);

        System.out.print("\nOne-head one-Tail tosses: "+headtail);

        totalTosses = twoHead+twoTail+headtail;
        if(totalTosses == numoftrials) { correctTosses = true; }
        System.out.println("\nTosses add up correctly? "+ correctTosses);
    }
}
