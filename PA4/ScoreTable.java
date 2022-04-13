// Name: Meghana Putta Swamy
// USC NetID: mswamy
// CS 455 PA4
// Spring 2022 

/**
 * ScoreTable Class 
 * This class stores all the scores for a character as given in the assignment description
 * Has accessor methods to fetch the score for character ehich is used while calculating scores by WOrdFinder
 */ 
public class ScoreTable {

     /**
      Representation invariant:
      letterScoreArr.length == 26
   */
    int[] letterScoreArr;

    /**
     * constructor whihc creates an array of size 26, indexing representing alaphabets.
     * e.g for  a/A index is 0, b/B its 1, d/D its 3 etc.
     */
    public ScoreTable(){
     
       letterScoreArr= new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10}; 
      
    } 
    /**
     * This method calculates the score for a word.
     * This loops through the word and gets score for each character, adds all up and returns the totaol count.
     * @param word for whihc the score to be calculated. 
     * @return the total score, i.e. the  score of that word.
     */
    public int calculateScore(String word){
        int totalScore=0;
        int letterIndex=0;
        for(int i=0;i<word.length();i++){
            int ascii = (int)(word.charAt(i));
            if(ascii<97){
                 letterIndex = ascii-65;
                totalScore +=  getLetterScore(letterIndex);
            }
            else{
                letterIndex = ascii-97;
                totalScore +=  getLetterScore(letterIndex);
            }
        }
        return totalScore;
    }

    /**
     * Accessor for getting the score for a character's index value in a string
     * @param index represesnting a character. e.g. getLetterScore(5) is asking for the score of 'f'
     * @return int the score of the character.
     */
    public int getLetterScore(int index){
        return letterScoreArr[index];
    }

}