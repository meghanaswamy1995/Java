// Name: Meghana Putta Swamy
// USC NetID: mswamy
// CS 455 PA4
// Spring 2022 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {
   
    /**
      Representation invariant:
      processedMap should contain value which is a AraayList, whose size will be greate than one and unique
      checkDictionary contains unique key words with Value always one
   */
   private Map<String,ArrayList<String>> processedMap;
   private Map<String,Integer> checkDictionary;

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException,
                                                    IllegalDictionaryException {
      processedMap = new HashMap<>();
      checkDictionary = new HashMap<>();
      Scanner fileRead = new Scanner(new File(fileName));
      
      processDictionary(fileRead);

   }

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String string) {
      ArrayList<String> dictWords = new ArrayList<>();
      dictWords = processedMap.get(string);
      //System.out.print("rewquired for "+string+" values fetched are " );
      if(dictWords==null){
         return null;
      }
      return dictWords; 
   } 
   
/**
* Helper method for the constructor. This pre processes the dictionary.
* This method gets all the unique letters in a word and stores it in a map.
*Map contains a key as "abc_111" string and value as an arrayList with all the words of abc.
@param fileRead scanner object to read words from dictionary text.
@throws FileNotFoundException  if the file is not found
@throws IllegalDictionaryException  if the dictionary has any duplicate words
*/
private void processDictionary (Scanner fileRead) throws FileNotFoundException,IllegalDictionaryException {
   StringProcessing stringProcessor = new StringProcessing();
   while(fileRead.hasNext()){
      String currWord= fileRead.next();
      if(checkDictionary.get(currWord)!=null){
         throw new IllegalDictionaryException("ERROR: Illegal dictionary: dictionary file has a duplicate word: "+currWord); 
      }
      else{
         checkDictionary.put(currWord,1);
         stringProcessor.processString(currWord);
         String uniqueLetters = stringProcessor.getUniqueLetters();
         String multiplicityCount = stringProcessor.getMultiplicityCount(); 
         String newHashMapKey = uniqueLetters+"_"+multiplicityCount;
      
         ArrayList<String> listPresent = processedMap.get(newHashMapKey);
          
         if(listPresent == null){
            ArrayList<String> listOfDictWords = new ArrayList<String>(); 
            listOfDictWords.add(currWord);
            
            processedMap.put(newHashMapKey,listOfDictWords);  
         }
         else{
            listPresent.add(currWord); 
            processedMap.put(newHashMapKey,listPresent);
         } 
      }
   }
} 
}
