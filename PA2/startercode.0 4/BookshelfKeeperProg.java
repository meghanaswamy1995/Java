import java.util.Scanner;
import java.util.ArrayList;

public class BookshelfKeeperProg {
    public static void main(String[] args){
        ArrayList<Integer> myBooksList;
        Boolean isValid=true;
        int pickCount=0;
        int putCount=0;

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter initial arrangement of books followed by newline: ");
        
        while(in.hasNextLine()&& isValid){
            String val=in.nextLine();
            myBooksList = new ArrayList<Integer>();
            
            if(val.equals("end")){
                System.out.println("Exiting Program.");
                break;
            }

            String[] tokens=val.split("\\s+");
            for(int i=0;i<tokens.length;i++){
            myBooksList.add(Integer.parseInt(tokens[i])); 
            }
            
            int heightStat = checkHeight(myBooksList);
            if(heightStat==-1){
                System.out.println("ERROR: Height of a book must be positive.\nExiting Program.");
                isValid=false;
            }

            int sortStat = checkSort(myBooksList);
            if(sortStat==-1){
                System.out.println("ERROR: Heights must be specified in non-decreasing order.\nExiting Program.");
                //isValid=false;
                break;
            }
            System.out.println(myBooksList.toString()+" "+pickCount+" "+putCount);
            
            System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");

            while(in.hasNextLine()){
                String pickput=in.nextLine();
                int operStat = doPickPutOperation(pickput, myBooksList.size());
                
                if(operStat == -1) {
                    isValid=false;
                    break;
                }
            }
            if(isValid.equals(false)) break;

        }
    }

    public static int doPickPutOperation(String pickPutOper, int arraySize){
        if(pickPutOper.equals("end")){
            System.out.println("Exiting Program.");
            return -1;
        }
        else if(pickPutOper.toLowerCase().matches("pick (.*)")) {
            String[] indexVal = pickPutOper.split("\\s+");
            int number=Integer.parseInt(indexVal[1]);
            if(number>(arraySize-1)){
                System.out.println("ERROR: Entered pick operation is invalid on this shelf.\nExiting Program.");
                return -1;
            }
            System.out.println("pick index: "+number);
        }
        else if(pickPutOper.toLowerCase().matches("put (.*)")){
            String[] heightVal = pickPutOper.split("\\s+");
            int height=Integer.parseInt(heightVal[1]);
            if(height<0){
                System.out.println("ERROR: Height of a book must be positive.\nExiting Program.");
                return -1;
            }
        }
        else{
            System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.\nExiting Program.");
            return -1;
        }
        return 1; 

    }

    public static int checkHeight(ArrayList<Integer> booksList){
        for(int i=0; i<booksList.size();i++){
            if(booksList.get(i)<0){
                return -1;
            }
        }
        return 1;
    }

    public static int checkSort(ArrayList<Integer> booksList){
        for(int i =0; i<booksList.size()-1;i++){
            if(booksList.get(i)>booksList.get(i+1)){
                return -1;
            }
        }
        return 1;
    }



}