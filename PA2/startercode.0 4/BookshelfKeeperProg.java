import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main Class BookshelfKeeperProg
 * allows the user to perform a series of pickPos and putHeight operations on a bookshelf 
 * in an interactive mode with user commands called pick and put. 
 * It can also be run in a batch mode by using input and output redirection.
 * Throws error if any operation other than pick or put is entered, if height of the book is negative and 
 * if array not in non-descending order.
 * 
*/
public class BookshelfKeeperProg {
   public static void main(String[] args){
      
        Boolean isValid=false;
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> myBooksList = new ArrayList<Integer>(); 
        
        // reading input for array elements 
        System.out.println("Please enter initial arrangement of books followed by newline: ");
        while(in.hasNextLine()&& !isValid){
            String val=in.nextLine();
            val=val.trim();
            // checking for end string, if end is entered exit the program
            if(val.equals("end")){
                System.out.println("Exiting Program.");
                break;
            }
            // get the integer from string of array input and parse it to into int and add to array list
            if(!val.equals("")){
                String[] tokens=val.split("\\s+");
                for(int i=0;i<tokens.length;i++){
                    if(!tokens[i].equals("")){
                        myBooksList.add(Integer.parseInt(tokens[i])); 
                    }
                }
            }
            // create BookShelf and BookshelfKeeper obj by passing the created arrayList myBooksList
            Bookshelf bsObj  = new Bookshelf(myBooksList);
            BookshelfKeeper keeperObj = new BookshelfKeeper(bsObj);
            System.out.println(keeperObj.toString());

            // checking if any of the book height values is negative, if so gives ERROR
            int heightStat = checkHeight(myBooksList);
            if(heightStat==-1){
                System.out.println("ERROR: Height of a book must be positive.\nExiting Program."); 
                isValid=false;
                break;
            }
            // checking if the given is sorted ot not
            boolean sortState=bsObj.isSorted();
            if(!sortState){
                System.out.println("ERROR: Heights must be specified in non-decreasing order.\nExiting Program.");
                isValid=true;
                break;
            }
             // taking input for operation pick index/ put height
            System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
             while(in.hasNextLine()){
                String pickput=in.nextLine().trim();
                int operStat = doPickPutOperation(pickput, bsObj.size(),keeperObj);
                
                if(operStat == -1) {
                    isValid=false;
                    break;
                }
              }
            if(isValid.equals(false)) { break; } 

        }
    }

    /// check constructor of boookshelf keeper 
    ///add exceptions
    /// add comment
    //check instance var
    //assert statements
    // representation invarient
    // use break statement alternative

    /**
     * Helper function which does the operation of calling the pick index/ put height calls to BookshelfKeeper class.
     * checks whether an operation given by the user is put or pick and calls respective methods from BookshelfKeeper.
     * If anything else other than pick or put is entered gives error and terminates the program
     * @param pickPutOper pick index/ put height string given by the user
     * @param arraySize size of the current bookshelf 
     * @param keeper keeper class object
     * @return 1 if the valid commands are entered and calls bookshelfKeeper else returns -1 if invalid oepration is entered
     */

    private static int doPickPutOperation(String pickPutOper, int arraySize, BookshelfKeeper keeper){
        //check for "end", if end then exit program
        if(pickPutOper.equals("end")){
            System.out.println("Exiting Program.");
            return -1;
        }
        // if it is a pick then call pickPos with index
        else if(pickPutOper.toLowerCase().matches("pick (.*)")) {
            String[] indexVal = pickPutOper.split("\\s+");
            int indexNumber=Integer.parseInt(indexVal[1]);
            if(indexNumber>(arraySize-1)){
                System.out.println("ERROR: Entered pick operation is invalid on this shelf.\nExiting Program.");
                return -1;
            }
             else{ 
               int count = keeper.pickPos(indexNumber);
             }
             System.out.println(keeper.toString()); 
        }
        // if it is a put then call putHeight with height as a parameter
        else if(pickPutOper.toLowerCase().matches("put (.*)")){
            String[] heightVal = pickPutOper.split("\\s+");
            int height=Integer.parseInt(heightVal[1]);
            if(height<0){
                System.out.println("ERROR: Height of a book must be positive.\nExiting Program.");
                return -1;
            }
             else{
                int count = keeper.putHeight(height);
            }
            System.out.println(keeper.toString());
        }
        else{
            System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.\nExiting Program.");
            return -1;
        }
        return 1; 

    }

    /**
     * Helper function used to check the height of all the books that is entered as initial values.
     * @param booksList contains the list of books that is added by the user
     * @return 1 if the height of none of the books is negative else returns -1 if any height is negative
     */
    private static int checkHeight(ArrayList<Integer> booksList){
        for(int i=0; i<booksList.size();i++){
            if(booksList.get(i)<0){
                return -1;
            }
        }
        return 1;
    }

}