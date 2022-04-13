// Name: Meghana Putta Swamy
// USC NetID: mswamy
// CS 455 PA4
// Spring 2022 

/**
 * StringProcessing class used to process any string that is passed to this.
 * String is processed to get its unique letters, multiplicity count of each letter.
 * This class is used by both WordFinder(to process input) and AnagramDictionary(to processs each word and store in a map) for processing words
 */
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class StringProcessing {

     /**
      Representation invariant:
      uniqueLetters string should contain unique letters and size > 0 for any word enterd in the rack and should be in ascending order. 
      multiplicityCount.length()>0 if uniqueLetter.size()>0 
        multiplicityArr.length >0 if uniqueLetter.size()>0 
   */
    
    private String uniqueLetter;
    private String multiplicityCount;
    private int[] multiplicityArr;
    
    /**
     * contructor, which initializes values.
     */
    public StringProcessing(){
        
        uniqueLetter="";
        multiplicityCount=""; 
    }
    /**
     * processString adds the character from the given string to a treemap so that the values are arranged in the ascending order.
     * This calls calculateUniqueLettersCount() which constructs the unique letters string and multiplicity count.
     * @param rackString the word string  whose unique characters and multiplicity count are to be extracted.
     * 
     */
    public void processString(String rackString){
        Map<Character,Integer> individualLetters= new TreeMap<Character,Integer>();

        for(int i=0;i<rackString.length();i++){ 
            Integer val = individualLetters.get(rackString.charAt(i));
            if(val == null){
               individualLetters.put(rackString.charAt(i),1);
            }
            else{
            individualLetters.put(rackString.charAt(i),val+1);  
            }
         } 
    
        calculateUniqueLettersCount(individualLetters); 
    
     } 
 
    /**
     * Helper method for processString().
     * calculateUniqueLettersCount extracts the unique letters/character in the given word, 
     * calculate its multipilicty count as a string and sets multiplicity arr
     * This is used while pre-processing the dictionary, processing the input string and processinf every subset.
     */
    private void calculateUniqueLettersCount(Map<Character,Integer> individualLetters){ 
        
        multiplicityArr = new int[individualLetters.size()];
        int count=0;
        uniqueLetter="";
        multiplicityCount="";  
        Iterator<Map.Entry<Character,Integer>> iter = individualLetters.entrySet().iterator();

        while(iter.hasNext()){
           if(count<=individualLetters.size()){
           Map.Entry<Character,Integer> currVal =iter.next();
           Character key =currVal.getKey();
           uniqueLetter+=key;
           int keysVal = currVal.getValue();
                multiplicityCount+=keysVal;
              multiplicityArr[count]=keysVal;
              count++; 
           }
        }
        //System.out.println("uniquletter: "+uniqueLetter+" multiplcitycnt: "+multiplicityCount); 
    }
    /**
     * Accesssor for getting the multiplicity count String
     * @return multiplicity count in the String format
     */
    public String getMultiplicityCount(){
        return multiplicityCount;     
    }
    /**
     * Accesssor for getting the unique characters in the given word string.
     * @return uniqueLetters String
     */
    public String getUniqueLetters(){
        return uniqueLetter;
    }
    /**
     * Accesssor for getting the multiplicity count Array
     * @return multiplicity count arr, which contains the the number of occurances of each letter/character in a word
     */
    public int[] getMultiplicityArr(){
        return multiplicityArr;
    }
    
}
 