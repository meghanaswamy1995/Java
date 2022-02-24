import java.util.Random;

public class DiceSimulator {
    // constructs a dice simulator using dice with the given number of sides
    // pre: numSides >= 1

    private int numberSides;
    private Random r = new Random();
    private int total;
    private int[] arr = new int[12+1]; 

    public DiceSimulator(int numSides) {
        numberSides=numSides;

    }
    // run the simulation for the given number of rolls of the pair of dice
    // pre: numRolls >= 0
    public void run(int numRolls) {
        for(int i=0;i<numRolls;i++){
           int dice1=  r.nextInt(1,7);
           int dice2= r.nextInt(1,7); 
           total=dice1+dice2;
           System.out.println(dice1+"  "+dice2+"  "+total);
           int val = arr[total];
           val++;
           arr[total]=val;

        }
    }
    // prints out the results of the simulation:
    // shows for each of the values from 2 to 2*numSides,
    // how many times the roll of the pair summed up to that value
    // [see sample output for details of output format]
    public void printResults() {
    // to save you some typing... here's *part* of the code for printing
    // the headers for the table of results
    System.out.print("Results of rolling the dice ");
    System.out.println("sum number of rolls"); 
    for(int j=2;j<arr.length;j++){ 
        System.out.println(j+"  "+arr[j]); 
    }
    
    }
   }