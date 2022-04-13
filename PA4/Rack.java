// Name: Meghana Putta Swamy
// USC NetID: mswamy
// CS 455 PA4
// Spring 2022

import java.util.ArrayList; 

/**
   A Rack Class of Scrabble tiles
   This class takes in the unique characters of the input rack string and computes all the possible substes of that string as a list
 */

public class Rack { 
   
    /**
      Representation invariant:
      listOfSubsets should contain unique subsets of a given string 
      listOfSubsets size should be greater than zero
   */

   private ArrayList<String> listOfSubsets;

   /**
    * contructor which creates a new arraylist when the object of this type is created.
    */
   public Rack(){
      listOfSubsets = new ArrayList<>();
   }
   
   /**
    * public method whihc can be called from the user, 
    * this inturn calls allSubsets private method whihc calculates the subsets
    * @param unique a string of unique letters
    * @param mult the multiplicity of each letter from unique.  
    * @param k the smallest index of unique and mult to consider.
    * @return ArrayList<String> which contains all the subsets possible for a given rack.
    */
   public ArrayList<String> createSubStrings(String unique, int[] mult, int k ){

      listOfSubsets=allSubsets(unique, mult, k);
      return listOfSubsets;
   }

   /**
    * Accessor for getting the list of subets formed by allSubsets()
    * @return ArrayList<String> which contains all the subsets possible for a given rack.
    */
   public ArrayList<String> getAllSubsets(){
      return listOfSubsets;
   }
   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
}
