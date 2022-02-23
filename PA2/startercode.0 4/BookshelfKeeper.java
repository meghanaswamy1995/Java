// Name: Meghana Putta Swamy
// USC NetID: 6565038173
// CSCI455 PA2
// Spring 2022

import java.util.ArrayList;
/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper { 

    /**
      Representation invariant:

      <put rep. invar. comment here>

   */
   
   // <add instance variables here>
   
   private Bookshelf sortedBookshelf;
   private ArrayList<Integer> pileOfBooks;
   private int totalMutatorCount;
   private int operCount;
   private static final String PICK_OPERATION="pick";
   private static final String PUT_OPERATION="put";
   

   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      Bookshelf bs = new Bookshelf();

   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      assert sortedBookshelf.isSorted() == true;

      this.sortedBookshelf=sortedBookshelf;
      pileOfBooks = sortedBookshelf.myPileOfBooks;
      totalMutatorCount=0;
      operCount=0;
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: 0 <= position < getNumBooks()
    */
    

    //****  ADD HELPER METHODS ********/

   public int pickPos(int position) {
      
      assert (position>=0 && position<getNumBooks());

      int target = position;
      String operation=PICK_OPERATION;
      int book=0;
      //
      operCount=doOperation(target,operation,book); 
      return operCount;   
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {
         
      assert height>0;

         int book =height;
         int middleElement;
         String operation = PUT_OPERATION; 
         int target=0;
         int middleLoc = (sortedBookshelf.myPileOfBooks.size()-1)/2;
         operCount=0;

         if(pileOfBooks.size()>0){
               middleElement=pileOfBooks.get(middleLoc);
               // getting the location to add the new book
               if(book>middleElement){
                     for(int loc=middleLoc;loc<pileOfBooks.size();loc++){
                        if(book<pileOfBooks.get(loc)){
                           target=loc;
                           break; 
                        }
                     }
                  }
                  else{
                     for(int loc=0;loc<middleLoc;loc++){
                           if(book>pileOfBooks.get(loc)){ 
                              target=loc;
                           } 
                     }
                  } 

                  // checking if the new book height is less than 0th element or last element, if so we can directly addFront or addLast repectively, else call doOperation method
                  if(book<pileOfBooks.get(0)){ 
                     sortedBookshelf.addFront( book); 
                     operCount++;
                     return operCount; 
                  }
                  else if(book>pileOfBooks.get(pileOfBooks.size()-1)){ 
                     sortedBookshelf.addLast(book); 
                     operCount++;
                     return operCount; 
                  }
                  else { operCount=doOperation(target,operation,book);  }
         }
            else{
               target=0;
               operCount=doOperation(target,operation,book);

            }
      return operCount;  
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {

      totalMutatorCount+=operCount;
       return totalMutatorCount;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      
       return pileOfBooks.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {
      String arrString= pileOfBooks.toString()+" "+operCount +" "+getTotalOperations();
      return arrString;   
      
   }
    /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
    private boolean isValidBookshelfKeeper() {

      return false;  // dummy code to get stub to compile

   }

   /**
    * A helper method to which actually does the operation of pick or put by checking the index. 
    * This function is used by both put and pick operations using Bookshelf class methods addFront, addLast, removeFront, remove Last.
    * this method works for both pick or put operations.
    * Returns count of mutator calls that is done 
    @param targetLoc location of the target element ot be put or picked from
    @param currentOperation defines what operation that is currently being done
    @param book is the height of the book that is needed to be put in case of a put operation
   */

   private int doOperation(int targetLoc, String currentOperation, int book){
      int count=0;
      ArrayList<Integer> tempArr = new ArrayList<Integer>();
      int middleLoc = (sortedBookshelf.myPileOfBooks.size()-1)/2; 

      // if the target location is grater than the middle location of the array then the computation begins from the 2nd half of array after the middle else starts from the start to middleLoc
         if(targetLoc>middleLoc){  
               for(int i=pileOfBooks.size()-1;i>=targetLoc;i--){
                  if(i!=targetLoc){
                     tempArr.add(pileOfBooks.get(i));
                  }
                  if(i==targetLoc && currentOperation.equals(PUT_OPERATION)){
                     tempArr.add(pileOfBooks.get(i));
                  }
                  sortedBookshelf.removeLast();
                  count++;

            }
            if(currentOperation.equals(PUT_OPERATION)){
               sortedBookshelf.addLast(book);
               count++;
            }
            for(int k=tempArr.size()-1;k>=0;k--){
                  sortedBookshelf.addLast(tempArr.get(k));
                  count++;
            }  
         }
         
         else{
            int target_count=0;
            if(pileOfBooks.size()>0){ 
                  while(target_count<=targetLoc){
                        tempArr.add(pileOfBooks.get(0));
                        sortedBookshelf.removeFront();
                        count++;
                        target_count++; 
                  }
                  if(currentOperation.equals(PUT_OPERATION)){
                     sortedBookshelf.addFront(book);
                     count++;
                  }
                  if(tempArr.size()>0){
                  for(int temp=tempArr.size()-1;temp>=0;temp--){
                     if(temp!=targetLoc){
                     sortedBookshelf.addFront(tempArr.get(temp));
                     count++;
                     }
                     else if(temp==targetLoc && currentOperation.equals(PUT_OPERATION)){
                           sortedBookshelf.addFront(tempArr.get(temp));
                           count++; 
                     }
                  }
               } 
            }
            //if the target is 0 for either put or pick operation we just directly add or remove from front/last accordingly
            else{
               if(currentOperation.equals(PICK_OPERATION)){
                  sortedBookshelf.removeFront();
                        count++;

               }
               if(currentOperation.equals(PUT_OPERATION)){
                  sortedBookshelf.addFront(book);
                  count++;
               }
            }
         }
      return count; 
   }

}