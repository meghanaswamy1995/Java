import java.util.ArrayList;
public class TestAssert{

    public static void main(String[] args){
    System.out.println("TestAssert class");
       ArrayList<Integer> arr = new ArrayList<Integer>();
       arr.add(2);
       arr.add(10);
       arr.add(26);
       Bookshelf shelf = new Bookshelf(arr);

       ArrayList<Integer> newarr = new ArrayList<Integer>();
       newarr.add(-2);
       newarr.add(10);
       newarr.add(26);
       Bookshelf newShelf = new Bookshelf(newarr);
    }
 }