import java.util.ArrayList;

public class BookshelfTester {
    
    public static void main(String[] args){
        
        ArrayList<Integer> pileOfBooks;
        
        System.out.println("\nTester for Bookshelf");
        Bookshelf emptyShelf = new Bookshelf(); 
        System.out.println("Bookshelf array string values with empty contructor (expected []): "+emptyShelf.toString());

        pileOfBooks = new ArrayList<Integer>();
        pileOfBooks.add(15);
        pileOfBooks.add(10); 
        pileOfBooks.add(13);

        Bookshelf newShelf = new Bookshelf(pileOfBooks);

        //Executing toString method 
        System.out.println("Is array sorted? "+newShelf.isSorted()); 
        System.out.println("Bookshelf array string values (expected [5, 10, 13]): "+newShelf.toString());

        //Testing the size of ArrayList
        System.out.println("The current size of arrayList is (Expected 3): "+newShelf.size());

        //The height of the book @index 2
        System.out.println("The height of the book at position 2 is (expected 13): "+newShelf.getHeight(2));

        //Testing add/remove to the arraylist
        newShelf.addFront(2);
        System.out.println("ArrayList after adding 2 to the front  (expected [2, 5, 10, 13]): "+newShelf.toString());

        newShelf.addLast(1);
        System.out.println("ArrayList after adding 21 to the last (expected [2, 5, 10, 13, 1]): "+newShelf.toString());
        System.out.println("Is array sorted?? "+newShelf.isSorted());

        //Test size
        System.out.println("The current size of arrayList is (Expected 5): "+newShelf.size());

        //The height of the book @index 2
        System.out.println("The height of the book at position 2 is (expected 10): "+newShelf.getHeight(2));

        newShelf.removeFront();
        System.out.println("ArrayList after removing front (expected [5, 10, 13, 21]): "+newShelf.toString());

        newShelf.removeLast();
        System.out.println("ArrayList after removing last (expected [5, 10, 13]): "+newShelf.toString());

        newShelf.removeLast();
        System.out.println("ArrayList after removing last (expected [5, 10]): "+newShelf.toString());

        newShelf.removeLast();
        System.out.println("ArrayList after removing last (expected [5]): "+newShelf.toString());

        newShelf.removeLast();
        System.out.println("ArrayList after removing last (expected []): "+newShelf.toString());

        newShelf.addFront(2);
        System.out.println("ArrayList after adding 2 to the front  (expected [2]): "+newShelf.toString());


        //Testing sort
        System.out.println("Is array sorted? "+newShelf.isSorted()); 
        System.out.println("\n"); 
    }
}
