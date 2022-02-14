// Name: Meghana Putta Swamy
// USC NetID: mswamy
// CSCI455 PA2
// Spring 2022

import java.util.ArrayList;
/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

public class Bookshelf {  

    /**
      Representation invariant:
      myPileOfBooks contains the list of books in non-decresing order
      myPileOfBooks should contains 0 or more positive integers
      myPileOfBooks should always be in non-decresing order
      Height of the books should always be greater than 0


   */
   
   private ArrayList<Integer> myPileOfBooks;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      myPileOfBooks = new ArrayList<Integer>();
      assert isValidBookshelf();  
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      assert pileOfBooks.size()>=0;
      myPileOfBooks = new ArrayList<Integer>(pileOfBooks);
      assert isValidBookshelf(); 
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      assert height>0;
      myPileOfBooks.add(0,height);
      assert isValidBookshelf(); 
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      assert height>0;
      myPileOfBooks.add(myPileOfBooks.size(),height);
      assert isValidBookshelf(); 
      
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      assert myPileOfBooks.size()>0;
      int removedBookHeight;
      removedBookHeight=myPileOfBooks.get(0);
      myPileOfBooks.remove(0);
       
      assert isValidBookshelf(); 
      return removedBookHeight;  
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      int removedBookHeight;
      assert myPileOfBooks.size()>0;
      removedBookHeight=myPileOfBooks.get(myPileOfBooks.size()-1);
      myPileOfBooks.remove(myPileOfBooks.size()-1);

      assert isValidBookshelf(); 
      return removedBookHeight;        
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      
      assert position>=0 && position<myPileOfBooks.size();
      assert isValidBookshelf(); 
      return myPileOfBooks.get(position);   
      
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      assert isValidBookshelf(); 
      return myPileOfBooks.size();   

   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
      return myPileOfBooks.toString();
      /*
      String stringVal="";
      if(myPileOfBooks.size()>0){
      stringVal+="["+myPileOfBooks.get(0);
      for(int i =1;i<myPileOfBooks.size();i++){
         if(i!=(myPileOfBooks.size()-1)){
             stringVal+=", "+myPileOfBooks.get(i);
             }
             else {
                 stringVal+=", "+myPileOfBooks.get(i);
             }
         }
         stringVal+="]";
         assert isValidBookshelf();  
      return stringVal; 
   }
      else {
         assert isValidBookshelf(); 
         return "[]";}
*/
   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {

      for(int val=0;val<myPileOfBooks.size()-1;val++){
         if(myPileOfBooks.get(val)<myPileOfBooks.get(val+1))continue;
         else return false;
      }
      return true; 
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      if(myPileOfBooks.size()<0) return false;
      for(int i=0;i<myPileOfBooks.size();i++){
         if(myPileOfBooks.get(i)<1) return false;
      }

      // for(int val=0;val<myPileOfBooks.size()-1;val++){
      //    if(myPileOfBooks.get(val)<myPileOfBooks.get(val+1))continue;
      //    else return false;
      // }

      return true;

   }

}