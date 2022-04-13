// Name: Meghana Putta Swamy
// USC NetID: mswamy
// CS 455 PA4
// Spring 2022

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Main Class WordFinder
 * This contains the main method that's responsible for processing the command-line argument (dictionary file name)if any.
 * This does error processing. If the dictionary file is not proper or if the dictionary file not found, throws errror. 
 * in a terminal based interactive mode with user input for rack String. 
 * It can also be run in a batch mode by using input and output redirection.
 */ 
public class WordFinder {  
    public static void main(String[] args){ 
        
        String fileName=""; 
        boolean doneProcessing=false; 

        while(! doneProcessing){
            try{
                if(args.length>0){
                     fileName = args[0]; 
                }
                else{
                    fileName="sowpods.txt"; 
                }
                AnagramDictionary dictProcessor = new AnagramDictionary(fileName);
                Scanner in = new Scanner(System.in); 
                getProcessInputRack(in,dictProcessor); 
                doneProcessing=true; 
            }  
            catch(FileNotFoundException e){
                System.out.println("File not found : "+ fileName+"\nExiting program."); 
                doneProcessing=true;
            }
            catch(IllegalDictionaryException e){
                System.out.println( e.getMessage()+"\nExiting program."); 
                doneProcessing=true; 
            } 
        }  
    } 
 /**
 * Helper method to main, 
 * This method gets the input rack string from the user, process the given rack, gets all subsets using Rack class object
 * This checks and process input untill "." is given to quit the program.
 * This calls getAllWordsPrinted method for getting all the associated words from dictionary.
 * @param in Scanner obj used to take input from user.
 * @param dictProcessor AnagramDictionary object used to process dictionary and get all the words associated with a particular subset.
 * @return void
 */
    private static void getProcessInputRack(Scanner in, AnagramDictionary dictProcessor){
        StringProcessing stringProcessor = new StringProcessing();
        Rack rack = new Rack();
        System.out.println("Type . to quit.");
                System.out.print("Rack? ");
                String wordRack = in.nextLine();
                int[] multiplicityArr;
                String uniqueLetters;
                
                ArrayList<String> subsets;
                 while(!wordRack.equals(".")){
                    
                    stringProcessor.processString(wordRack);
                    uniqueLetters = stringProcessor.getUniqueLetters();
                    multiplicityArr = stringProcessor.getMultiplicityArr();

                    subsets = rack.createSubStrings(uniqueLetters,multiplicityArr,0); 
                     getAllWordsPrinted(subsets,stringProcessor,dictProcessor,wordRack);
                    
                    System.out.print("Rack? ");
                    wordRack = in.nextLine();    
                }
    }
/**
 * Helper method gets list subsets from getProcessInput() method.
 * gets all the words corresponding to each subset. calculates score for each word and adds to the finalMap.
 * Calls printSorteed() for printing all the words finally.
 * @param subsets ArrayList of subsets possible for the given rack.
 * @param stringProcessor StringProcessing class object used to process the string at any time.
 * @param dictProcessor AnagramDictionary object used to process dictionary and get all the words associated with a particular subset.
 * @param wordrack the input rack given by the user.
 * @return void
 */
    private static void  getAllWordsPrinted(ArrayList<String> subsets, StringProcessing stringProcessor, 
                                                    AnagramDictionary dictProcessor, String wordRack ){ 
        ArrayList<String> finalWords = new ArrayList<>();
        Map<String,Integer> finalMap = new TreeMap<String,Integer>();
        ScoreTable scoreT = new ScoreTable();
        for(int i=0; i<subsets.size();i++){ 
            String subset = subsets.get(i); 
            if(subset.length()>1){
                stringProcessor.processString(subset);
                String uniqueLetters = stringProcessor.getUniqueLetters(); 
                subset =uniqueLetters+"_"+stringProcessor.getMultiplicityCount();
                finalWords = dictProcessor.getAnagramsOf(subset); 
                if(finalWords!=null){
                    for(int j=0; j<finalWords.size();j++){ 
                        String word=finalWords.get(j);
                        int score=scoreT.calculateScore(word); 
                        finalMap.put(word,score); 
                    } 
                } 
            }      
        } 
        printSorted(finalMap,wordRack);    
    }

/**
 * Helper method prints all the words possible for a given word Rack from the dictionary
 * Prints all words in the no ascending order of its score by using collections.sort()
 * @param finalMap whihc coints all the words correspoding to the ArrayList of subsets possible for the given rack.
 * @param wordrack the input rack given by the user.
 * @return void
 */
    private static void printSorted(Map<String,Integer> finalMap, String wordRack){
        System.out.println("We can make "+finalMap.size()+" words from \""+ wordRack+"\"");
        if(finalMap.size()>0){
        System.out.println("All of the words with their scores (sorted by score):");
        }                   
        ArrayList<Map.Entry<String,Integer>> finalWordsArray = new ArrayList<>(finalMap.entrySet()); 
        Collections.sort(finalWordsArray, new ScoreComparator());
        for (Map.Entry<String, Integer> curr : finalWordsArray) {
            System.out.println(curr.getValue()+": "+curr.getKey()); 
         }

    }

}
//INNER CLASS ScoreComparator
/**
 * ScoreComparator implemets Comparator interface.
 * This class implements compare() method which compares two objects of map entry 
 * returns value such that the if a>b returns 1 else if a<b return -1 else return 0 if a=b
 */
class ScoreComparator implements Comparator<Map.Entry<String,Integer>> {

    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ){
       return o2.getValue()-o1.getValue(); 

    }

 }