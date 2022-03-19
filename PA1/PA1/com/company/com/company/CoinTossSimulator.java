package com.company;
// Name: Meghana Putta Swamy
// USC NetID:mswamy
// CS 455 PA1
// Spring 2022

import java.util.Random;
/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {

   private int twoHeadCount;
   private int twoTailCount;
   private int tailHeadCount;
   private int totalNumberOfTrials;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      totalNumberOfTrials=0;
      twoHeadCount=0;
      twoTailCount=0;
      tailHeadCount=0;

   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {

   totalNumberOfTrials += numTrials;

   for(int i=0; i<numTrials; i++){
     Random generator = new Random();
     int coin1 = generator.nextInt(2);
     int coin2 = generator.nextInt(2);
     if( (coin1 == 0) && (coin2 == 0)) { twoTailCount++; }
     else if (coin1 == 1 && coin2 == 1) { twoHeadCount++; }
     else { tailHeadCount++; }
   }

   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return totalNumberOfTrials;
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeadCount;
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTailCount;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return tailHeadCount;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      totalNumberOfTrials=0;
      twoHeadCount=0;
      twoTailCount=0;
      tailHeadCount=0;
   }

    /**
     Calculates the percentage of Two Heads and returns int.
     */
   public int getTwoHeadsPercent(){
       int twoHeadPercent = (int) Math.round((twoHeadCount/((double)totalNumberOfTrials))*100);
       return twoHeadPercent;
   }

    /**
     Calculates the percentage of Two Tails and returns int.
     */
    public int getTwoTailsPercent(){
        int twoTailPercent = (int) Math.round((twoTailCount/((double)totalNumberOfTrials))*100);
        return twoTailPercent;
    }
    /**
     Calculates the percentage of Tail and a Head and returns int.
     */
    public int getTailHeadPercent(){
        int tailHeadPercent = (int) Math.round((tailHeadCount/((double)totalNumberOfTrials))*100);
        return tailHeadPercent;
    }

}
