// // Name: Meghana Putta Swamy
// // USC NetID: 6565038173
// // CSCI455 PA2
// // Spring 2022

// import java.util.ArrayList;
// /**
//  * Class BookshelfKeeper 
//  *
//  * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
//  * non-decreasing order by height, with the restriction that single books can only be added 
//  * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
//  * operation.  Pick or put operations are performed with minimum number of such adds or removes.
//  */
// public class BookshelfKeeper { 

//     /**
//       Representation invariant:

//       <put rep. invar. comment here>

//    */
   
//    // <add instance variables here>
//    private ArrayList<Integer> tempArr;
//    private Bookshelf sortedBookshelf;
//    private int middleLoc;
//    private int target;
//    private ArrayList<Integer> pileOfBooks;
//    private int totalMutatorCount;
//    private int putOperCount;
//    private int pickOperCount;

//    /**
//     * Creates a BookShelfKeeper object with an empty bookshelf
//     */
//    public BookshelfKeeper() {
//       Bookshelf bs = new Bookshelf();

//    }

//    /**
//     * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
//     * Note: method does not make a defensive copy of the bookshelf.
//     *
//     * PRE: sortedBookshelf.isSorted() is true.
//     */
//    public BookshelfKeeper(Bookshelf sortedBookshelf) {
//       assert sortedBookshelf.isSorted() == true;

//       tempArr = new ArrayList<Integer>();
//       this.sortedBookshelf=sortedBookshelf;
//       middleLoc = sortedBookshelf.myPileOfBooks.size()/2;
//       pileOfBooks = sortedBookshelf.myPileOfBooks;
//       totalMutatorCount=0;
//       putOperCount=0;
//       pickOperCount=0;

//    }

//    /**
//     * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
//     * after picking up the book.
//     * 
//     * Returns the number of calls to mutators on the contained bookshelf used to complete this
//     * operation. This must be the minimum number to complete the operation.
//     * 
//     * PRE: 0 <= position < getNumBooks()
//     */
    

//     //****  ADD HELPER METHODS ********/

//    public int pickPos(int position) {
//       target = position;
//       pickOperCount=0;
      
//       if(target>middleLoc){
//           for(int i=pileOfBooks.size()-1;i>=target;i--){
//              if(i!=target){
//                  tempArr.add(pileOfBooks.get(i));
//              }
//              sortedBookshelf.removeLast();
//              pickOperCount++;

//          }
//          //System.out.println("array after removal: "+pileOfBooks.toString());
//          for(int k=tempArr.size()-1;k>=0;k--){
//              System.out.println("adding back "+ tempArr.get(k));
//              sortedBookshelf.addLast(tempArr.get(k));
//          }  
//       }
      
//       else{
//          int target_count=0;
//          while(target_count<=target){
//                tempArr.add(pileOfBooks.get(0));
//                sortedBookshelf.removeFront();
//                pickOperCount++;
//                target_count++; 
//          }
//          System.out.println("tempArr- "+tempArr.toString());
//          for(int k=tempArr.size()-1;k>=0;k--){
//             if(k!=target){
//             sortedBookshelf.addFront(tempArr.get(k));}
//          } 
//       }

//       System.out.println("arr after pick - "+pileOfBooks.toString());
//       tempArr.clear();
//       return pickOperCount++;   
//    }

//    /**
//     * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
//     * after the insertion.
//     * 
//     * Returns the number of calls to mutators on the contained bookshelf used to complete this
//     * operation. This must be the minimum number to complete the operation.
//     * 
//     * PRE: height > 0
//     */
//    public int putHeight(int height) {
//          int putOperCount=0;
//          int book =height;
//          int middleElement=pileOfBooks.get(middleLoc);

//          if(book>middleElement){
//             for(int ab=middleLoc;ab<pileOfBooks.size();ab++){
//                if(book<pileOfBooks.get(ab)){
//                   target=ab;
//                   break; 
//                }
//             }
//          }
//          else{
//             for(int ab=0;ab<middleLoc;ab++){
//                   if(book>pileOfBooks.get(ab)){
//                      target=ab;
//                   }
//             }
//          }

//         if(book<pileOfBooks.get(0)){ sortedBookshelf.addFront( book); }
//         else if(book>pileOfBooks.get(pileOfBooks.size()-1)){ sortedBookshelf.addLast(book); }

//         else if(target>middleLoc){
//                 for(int i=pileOfBooks.size()-1;i>=target;i--){
//                 tempArr.add(pileOfBooks.get(i));
//                 sortedBookshelf.removeLast();
//                 putOperCount++;

//             }
//             sortedBookshelf.addLast(book);
//             //System.out.println("array after adding new book: "+pileOfBooks.toString()+"\nnew arr: "+tempArr.toString());
//             for(int k=tempArr.size()-1;k>=0;k--){
//                 sortedBookshelf.addLast(tempArr.get(k));
//              }  

//          }
//         else{
//             int target_count=0;
//             while(target_count<=target){
//                   tempArr.add(pileOfBooks.get(0));
//                   sortedBookshelf.removeFront();
//                   putOperCount++;
//                   target_count++; 
//                }
//             sortedBookshelf.addFront(book);
//             for(int k=tempArr.size()-1;k>=0;k--){
//                sortedBookshelf.addFront(tempArr.get(k));
//             }  
//          }
//       return putOperCount;   
//    }

//    /**
//     * Returns the total number of calls made to mutators on the contained bookshelf
//     * so far, i.e., all the ones done to perform all of the pick and put operations
//     * that have been requested up to now.
//     */
//    public int getTotalOperations() {
//       totalMutatorCount=pickOperCount+putOperCount;
//        return totalMutatorCount;
//    }

//    /**
//     * Returns the number of books on the contained bookshelf.
//     */
//    public int getNumBooks() {
      
//        return pileOfBooks.size();
//    }

//    /**
//     * Returns string representation of this BookshelfKeeper. Returns a String containing height
//     * of all books present in the bookshelf in the order they are on the bookshelf, followed 
//     * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
//     * followed by the total number of such calls made since we created this BookshelfKeeper.
//     * 
//     * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
//     * 
//     */
//    public String toString() {
      
//       return "";   // dummy code to get stub to compile
      
//    }

//    private int doOperation(int targetLoc){

//       if(target>middleLoc){
//          for(int i=pileOfBooks.size()-1;i>=target;i--){
//             if(i!=target){
//                 tempArr.add(pileOfBooks.get(i));
//             }
//             sortedBookshelf.removeLast();
//             pickOperCount++;

//         }
//         //System.out.println("array after removal: "+pileOfBooks.toString());
//         for(int k=tempArr.size()-1;k>=0;k--){
//             System.out.println("adding back "+ tempArr.get(k));
//             sortedBookshelf.addLast(tempArr.get(k));
//         }  
//      }
     
//      else{
//         int target_count=0;
//         while(target_count<=target){
//               tempArr.add(pileOfBooks.get(0));
//               sortedBookshelf.removeFront();
//               pickOperCount++;
//               target_count++; 
//         }
//         System.out.println("tempArr- "+tempArr.toString());
//         for(int k=tempArr.size()-1;k>=0;k--){
//            if(k!=target){
//            sortedBookshelf.addFront(tempArr.get(k));}
//         } 
//      }

//      System.out.println("arr after pick - "+pileOfBooks.toString());
//      tempArr.clear();

//       return 0;
//    }
//    /**
//     * Returns true iff the BookshelfKeeper data is in a valid state.
//     * (See representation invariant comment for details.)
//     */
//    private boolean isValidBookshelfKeeper() {

//       return false;  // dummy code to get stub to compile

//    }

//    // add any other private methods here


// }
