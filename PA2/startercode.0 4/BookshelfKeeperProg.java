import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main Class BookshelfKeeperProg
 * Allows the user to perform a series of pickPos and putHeight operations on a bookshelf 
 * in a terminal based interactive mode with user commands called pick and put. 
 * It can also be run in a batch mode by using input and output redirection.
 * Throws error if any operation other than pick or put is entered, if height of the book is negative and 
 * if bookshelf not in non-descending order.
 * 
*/
public class BookshelfKeeperProg {
  public static void main(String[] args){
      
        Boolean isValid=true;
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> myBooksList = new ArrayList<Integer>(); 
        
        System.out.println("Please enter initial arrangement of books followed by newline:");
        while(in.hasNextLine()&& isValid){
            String val=in.nextLine();
            val=val.trim();
            
            if(val.equals("end")){
                System.out.println("Exiting Program.");
                break;
            }

            if(!val.equals("")){
                String[] tokens=val.split("\\s+");
                for(int i=0;i<tokens.length;i++){ 
                    if(!tokens[i].equals("")){
                        myBooksList.add(Integer.parseInt(tokens[i])); 
                    }
                }
            }
            Bookshelf bsObj  = new Bookshelf(myBooksList);
            BookshelfKeeper keeperObj = new BookshelfKeeper(bsObj);
            System.out.println(keeperObj.toString()); 

            isValid = checkHeight(myBooksList,isValid); 
            if(isValid==false){
                break;
            }

            isValid = checkSort(myBooksList,isValid); 
            if(isValid==false){
                break;
            }

            // Bookshelf bsObj  = new Bookshelf(myBooksList);
            // BookshelfKeeper keeperObj = new BookshelfKeeper(bsObj);
            // System.out.println(keeperObj.toString());
 
            System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
            isValid=getOperation(in,isValid,keeperObj); 
            if(isValid.equals(false)) { 
                break;
             } 

        }
    }

    /**
     * Helper method to main, 
     * This method gets the operation to be performed either pick index or Put height thorugh user input or through input file
     * @param in Scanner obj used to take input from user
     * @param isValid boolean value returns false if the  input is anything but pick or put
     * @param keeperObj BookshelfKeeper obj used for pick / put operation
     * @return boolean value of isValid.
     */
     private static boolean getOperation(Scanner in, boolean isValid, BookshelfKeeper keeperObj){
        while(in.hasNextLine()){
            String pickput=in.nextLine().trim();
            //int operStat = doPickPutOperation(pickput, bsObj.size(),keeperObj);
            int operStat = doPickPutOperation(pickput,keeperObj);
            
            if(operStat == -1) {
                isValid=false;
                break;
            }
          }
          return isValid;

     }

    /**
     * Helper function for main which calls doPickOperation/doPutOperation methods to pick or put operations
     * Checks whether an operation given by the user is put or pick and calls respective helper methods below.
     * If anything else other than pick or put is entered gives error and terminates the program
     * @param pickPutOper pick index/ put height string given by the user
     * @param keeper keeper class object
     * @return 1 if the valid commands are entered and calls bookshelfKeeper else returns -1 if invalid oepration is entered
     */

    private static int doPickPutOperation(String pickPutOper, BookshelfKeeper keeper){ 

        if(pickPutOper.equals("end")){
            System.out.println("Exiting Program.");
            return -1;
        }

        else if(pickPutOper.toLowerCase().matches("pick (.*)")) {
            if((doPickOperation(pickPutOper, keeper))==-1){
                return -1;
            }
            
        }

        else if(pickPutOper.toLowerCase().matches("put (.*)")){
            if((doPutOperation(pickPutOper, keeper))==-1){
                return -1;
            }
        }
        else{
            System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.\nExiting Program.");
            return -1;
        }
        return 1; 

    }
     /**
     * Helper function for doPickPutOperation which does the operation of calling the pick index call to BookshelfKeeper class.
     * If anything else other than pick is entered gives error and terminates the program
     * @param oper pick <index> string given by the user
     * @param keeper keeper class object
     * @return 1 if the valid commands are entered and calls bookshelfKeeper else returns -1, if invalid oepration is entered
     */
    private static int doPickOperation(String oper, BookshelfKeeper keeper){
        int arraySize=keeper.getNumBooks();
        String[] indexVal = oper.split("\\s+");
            int indexNumber=Integer.parseInt(indexVal[1]);
            if(indexNumber>(arraySize-1)){
                System.out.println("ERROR: Entered pick operation is invalid on this shelf.\nExiting Program.");
                return -1;
            }
             else{ 
               int count = keeper.pickPos(indexNumber);
             }
             System.out.println(keeper.toString()); 
             return 1;

    }
    /**
     * Helper function for doPickPutOperation which calls the putHeight(height) method of BookshelfKeeper class.
     * If anything else other than pick is entered gives error and terminates the program
     * @param oper put <height> string given by the user
     * @param keeper keeper class object
     * @return 1 if the valid commands are entered and calls bookshelfKeeper else returns -1, if invalid oepration is entered
     */
    private static int doPutOperation(String oper, BookshelfKeeper keeper){
        String[] heightVal = oper.split("\\s+");
            int height=Integer.parseInt(heightVal[1]);
            if(height<0){
                System.out.println("ERROR: Height of a book must be positive.\nExiting Program.");
                return -1;
            }
             else{
                int count = keeper.putHeight(height);
            }
            System.out.println(keeper.toString()); 
            return 1;

    }

    /**
     * Helper function used to check the height of all the books that is entered as initial values.
     * @param booksList contains the list of books that is added by the user
     * @return 1 if the height of none of the books is negative else returns -1 if any height is negative
     */
    private static boolean checkHeight(ArrayList<Integer> booksList, boolean isValid){
        for(int i=0; i<booksList.size();i++){
            if(booksList.get(i)<0){
                System.out.println("ERROR: Height of a book must be positive.\nExiting Program."); 
                isValid=false;
                break;
            }
        }
        return isValid;
    }

    private static boolean checkSort(ArrayList<Integer> booksList, boolean isValid){
        for(int i =0; i<booksList.size()-1;i++){
            if(booksList.get(i)>booksList.get(i+1)){
                System.out.println("ERROR: Heights must be specified in non-decreasing order.\nExiting Program.");
                isValid=false;
                break;
                //return -1;
            }
        }
        return isValid;
    }

}