import java.util.ArrayList;
import java.util.Scanner;

public class test {

    public static void main(String[] args){
        Boolean isValid=true;
        Boolean check=true;
        Boolean pickcheck = true;
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> myBooksList = new ArrayList<Integer>(); 
       
        System.out.println("Please enter initial arrangement of books followed by newline:");
        while(check && isValid &&  in.hasNextLine()){ 
            String val=in.nextLine();
            val=val.trim();
            
            if(val.equals("end")){
                System.out.println("Exiting Program.");
                isValid=false;
            }
    
                if(!val.equals("")){
                    String[] tokens=val.split("\\s+");
                    for(int i=0;i<tokens.length;i++){ 
                        if(!tokens[i].equals("")){
                            myBooksList.add(Integer.parseInt(tokens[i])); 
                        }
                    }
                }
                System.out.println("array added");
                for(int i=0; i<myBooksList.size();i++){
                    if(myBooksList.get(i)<0){
                        System.out.println("ERROR: Height of a book must be positive.\nExiting Program."); 
                        isValid=false;
                        //break;
                    }
                }
                System.out.println("height checked");
                for(int i =0; i<myBooksList.size()-1;i++){
                    if(myBooksList.get(i)>myBooksList.get(i+1)){
                        System.out.println("ERROR: Heights must be specified in non-decreasing order.\nExiting Program.");
                        isValid=false;
                        //break;
                        //return -1;
                    }
                }
                System.out.println("sort checked");
                check=false;
              
        }
        System.out.println(myBooksList.toString()); 
        System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
        while( isValid && pickcheck && in.hasNextLine() ){
            
           //in.nextLine();
            String pickput=in.nextLine().trim();
            if(pickput.equals("end")){
                System.out.println("Exiting Program.");
                isValid=false;
            }
            else{
                System.out.println("operation :"+pickput); 
                //pickcheck=false;
            }
        }
    
    }
}
