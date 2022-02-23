import java.util.ArrayList;
import java.util.Scanner;

public class keeperTester {
        public static void main(String[] args){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            Scanner in = new Scanner(System.in);
            int target=in.nextInt();
            int height =in.nextInt();
            arr.add(5);
            arr.add(5);arr.add(10);arr.add(15);arr.add(20);arr.add(25);arr.add(30);arr.add(35);
            Bookshelf bs = new Bookshelf(arr);
            BookshelfKeeper keeper = new BookshelfKeeper(bs);
            int count=0;
           count= keeper.pickPos(target);
            
            int putCount= keeper.putHeight(height);
            //Final System.out.println("FINAL arr: "+arr.toString()+" pick count "+count+ " put count "+putCount); 
            System.out.println("total count so far: "+keeper.getTotalOperations()); 
            System.out.println("no of books now: "+keeper.getNumBooks());
            System.out.println("FINAL arr: "+keeper.toString());
    }
    
}
