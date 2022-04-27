import java.util.Scanner;
import java.util.ArrayList;
import java.awt.*;
import java.util.Arrays;

public class myTest {
public static void main(String[] args){
    ArrayList<Point> list = new ArrayList<>();
    Point myPoint =new Point(1,1);
    list.add(myPoint);
    myPoint.translate(2,2);
    System.out.println(list.get(0)+" "+myPoint);
    myPoint=new Point(10,10);
    System.out.println(list.get(0)+" "+myPoint); 
}
}