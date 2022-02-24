import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int book=in.nextInt();
        //arr.add(5);
        arr.add(5);arr.add(10);arr.add(15);arr.add(20);arr.add(25);arr.add(30);arr.add(35);
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int middleLoc=(arr.size()-1)/2;
        int count=0;
        int removedbook;
        int target=0;
        int middleElement=arr.get(middleLoc);
        
        if(book>middleElement){
                for(int ab=middleLoc;ab<arr.size();ab++){
                    if(book<arr.get(ab)){
                        target=ab;
                        break; 
                    }

                }
            }
        else{
            for(int ab=0;ab<middleLoc;ab++){
                if(book>arr.get(ab)){
                    target=ab;
                }
            }
        }

        if(book<arr.get(0)){ addFront(arr, book);}
        else if(book>arr.get(arr.size()-1)){addLast(arr,book);}
        else if(target>middleLoc){
                System.out.println("target greate than middle");
                for(int i=arr.size()-1;i>=target;i--){
                newArr.add(arr.get(i));
                removedbook=removeLast(arr);
                System.out.println("removed book is: "+removedbook);
                count++;

            }

            System.out.println("array after removal: "+arr.toString());
            addLast(arr,book);
            System.out.println("array after adding new book: "+arr.toString()+"\nnew arr: "+newArr.toString());

            for(int k=newArr.size()-1;k>=0;k--){
                addLast(arr,newArr.get(k));
            
            }  
        }
        else{
            System.out.println("target less than midle");
            int target_count=0;
            while(target_count<=target){
                for(int j=0;j<=target;j++){
                    //if(j!=target){
                        //System.out.println("check target and i: "+j+"  target "+target);
                        newArr.add(j,arr.get(0));
                        System.out.println("new arr: "+newArr.toString()); 
                    //}
                    removedbook=removeFront(arr);
                   // System.out.println("removed book is: "+removedbook);
                    count++;
                    target_count++; 
                }
                
            }
            addFront(arr,book);
            System.out.println("array after removal: "+arr.toString());
            for(int k=newArr.size()-1;k>=0;k--){
                addFront(arr,newArr.get(k));
            
            }  
        }
        System.out.println(" count of call to remove: "+count);
        
        System.out.println("----\nFinal ARR is: "+ arr.toString()); 
    }



    private static int removeFront(ArrayList<Integer> myPileOfBooks) {
        
        int removedBookHeight;
        removedBookHeight=myPileOfBooks.get(0);
        myPileOfBooks.remove(0);
        return removedBookHeight;  
     }
  
     /**
      * Removes book at the end of the Bookshelf and returns the height of the
      * removed book.
      * 
      * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
      */
     private static int removeLast(ArrayList<Integer> myPileOfBooks) {
        int removedBookHeight;
        
        removedBookHeight= myPileOfBooks.get(myPileOfBooks.size()-1);
        myPileOfBooks.remove(myPileOfBooks.size()-1);
        return removedBookHeight;        
     }

     private static void addFront(ArrayList<Integer> myPileOfBooks, int height) {
        assert height>0;
        myPileOfBooks.add(0,height);
        //assert isValidBookshelf(); 
     }
  
     /**
      * Inserts book with specified height at the end of the Bookshelf.
      * 
      * PRE: height > 0 (height of book is always positive)
      */
     private static void addLast(ArrayList<Integer> myPileOfBooks,int height) {
        assert height>0;
        myPileOfBooks.add(myPileOfBooks.size(),height);
        //assert isValidBookshelf(); 
        
     }
    
}
