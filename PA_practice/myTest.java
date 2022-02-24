import java.util.Scanner;
import java.util.ArrayList;
import java.awt.*;
import java.util.Arrays;

public class myTest {
        public static void main(String[] args){
           
            int[] value = {2,1,-5,-3,4}; 
            System.out.println("test");
            System.out.println(removeNegatives(value,5));


            // while (in.hasNext())
            // {
            // String input = in.next();
            // System.out.println(input); 
            // }


            //int minimum = mode(value);
            //System.out.println("mini "+minimum); 

            // Duration dr = new Duration(8,30);
            // Duration newdr = dr.add(dr) ;
            // System.out.println(newdr.toString());

            
            //System.out.println("t/f : "+isLine(value));
                // CoinTossSimulator cs = new CoinTossSimulator(3);
                // System.out.println(cs.getResultsWith(2)); 

                // Scanner in = new Scanner(System.in);

                // System.out.print("Please enter your age: "); 
                // int age = in.nextInt();
                // in.nextLine();
        
                // System.out.print("Please enter your whole name: ");
                // String name = in.nextLine();
        
                // System.out.println("You are awesome, " + name + "!");
                // System.out.println("And so young.  Only " + age + "!");
      

                // DiceSimulator sim = new DiceSimulator(6); // two 6-sided dice
                // sim.run(10); // what happens over 10000 rolls of the pair of dice
                // sim.printResults();

                // int[] arr={12,8,8,5,5,12,4,3,2};
                // int largest=0;
                // int total=0;
                // int count=0;
                // if(arr.length>1){
                //     for(int i=0; i<(arr.length);i++){
                //         if(arr[i]>largest && arr[i]!=largest){
                //             largest=arr[i];
                //             System.out.println("largest "+largest);
                //         }
                //         else{
                //             total+=arr[i];
                //             count++;
                //             System.out.println("val adding = "+arr[i]+" count "+count);
                //         }
                        
                //         }
                // }
                // System.out.println(total/(double)count);

            // Scanner in = new Scanner(System.in);
            // String word = in.next();
            // boolean check=false;
            // word=in.nextLine();
            // while (!check) {
            //     if(word.charAt(word.length()-1) == '.'){
            //         word.replaceAll(".","");}
            //         System.out.println(word);
            //         if(word.charAt(word.length()-1) == '!'){
            //             check =true;

            //         }

                   
            //     }
            
            // word = in.next();
            
           


            // int nums=1;
            //     ArrayList<String> namesArr = new ArrayList<String>();
            //     int[] arr={12,8,8,5,5,4,3,2};
            //     System.out.println(arr.length%3); 
            //     assert (arr.length%3) == 0;
            
            //     int newSize = arr.length/3;
            //     int count=0;

            // double[] newArr= new double[newSize];

            // for(int i=0;i<arr.length-2;i++){
            //     int total = arr[i]+arr[i+1]+arr[i+2];
            //     double avg = total/(double)3;
            //     i+=2;
            //     if(count<newSize){
            //         newArr[count]=avg;
            //         count++;
            //     }
            // }
            // System.out.println( Arrays.toString(newArr)); 


            // int target=8;
            // int indexVal=-1;
            

            // int set;

            // for(int i=0;i<arr.length;i++){
            //     if(arr[i]==target){
            //         indexVal=i;
            //     }
            // }
            // if(indexVal!=-1){
            //     int count= arr.length-(indexVal+1);
            //     int firstelement=indexVal+1;
            //     int[] newArr= new int[count];
            //     for(int j=0;j<count;j++){
            //         newArr[j]=arr[firstelement];
            //         firstelement++;
            //     }
            //     System.out.println(Arrays.toString(newArr));

            //     set=indexVal;
                
            // }
            // else set=-1;
            //  System.out.println("---"+set);
          // arr={5,5};
            // arr={5,7,5,8,5};
            // arr={1,8,8,2,5,5,3,3,2};
            // arr={2,17,5,8,8,5};
            // arr={};


            // for(int i=0;i<n;i++){
            //     if(i==0){
            //         numsArr[i]=1;
            //         nums++;
            //     }
            //     else{
            //         int newSize=nums*(nums+1)/2;
            //         int val=1;
            //         int size=numsArr.length;
            //         System.out.println("newsize - "+newSize);
            //         System.out.println(Arrays.toString(numsArr));
            //         numsArr=Arrays.copyOf(numsArr,newSize);
            //         for(int j=size;j<newSize;j++){
            //             numsArr[j]=val;
            //             val++;
                        
            //         }
            //         nums++;

            //     }
            // }
            // System.out.println("final -- "+Arrays.toString(numsArr));

            // int[] result = new int[n*(n+1)/2];
      
            //     int loc = 0;
            //     for (int upTo = 1; upTo <= n; upTo++) {  // upTo is the number we are counting up to
            //                                                 // in this iteration of outer loop
            //         for (int count = 1; count <= upTo; count++) {
            //             result[loc] = count;
            //             loc++;
            //         }
            //         }
            //         System.out.println(Arrays.toString(result));  
                    
            // int val;
            // for (int i = 0; i < namesArr.size(); i++) {

            //     int result = target.compareTo(namesArr.get(i));
            //     System.out.println("rr-   "+result);
            //     if (result < 0) { val= -1;System.out.println("result-"+result); break; } 
            //     if(result==0){ val=1; }
            // }
            // val=-1;

            // System.out.println(val);

            // int count=0;
            // boolean finalVal;
            //                 for(int i=0;i<arr.length;i++){
                                
            //                     if((i<arr.length-1) && arr.length>1 ){
            //                             int val=arr[i];
            //                             if((val==5||val==8)&&val==arr[i+1]){
                                        
            //                                 count++;
            //                             }
            //                         }
            //                     //else{count=0;}
            //                 }
            //                 if(count==1){
            //                     finalVal=true;
            //                 }
            //                 else{finalVal=false;}
            //                 System.out.println("t/f "+finalVal);





        }
        
        // public static boolean isLine(int[] vals) {
        //     int setval=0;
        //     int newVal;
        //     boolean tf=false;
        //     System.out.println("in is line");
        //     if(vals.length>1){
        //         for(int i=0;i<vals.length-1;i++){
        //             if(i==0){
        //                 setval=Math.abs(vals[i]-vals[i+1]);
        //                 System.out.println("val- "+vals[i]+" set: "+setval);
        //             }
        //             else{
        //                 newVal=Math.abs(vals[i]-vals[i+1]);
        //                 System.out.println("val- "+vals[i]+" new: "+newVal);
        //                 if(newVal != setval){
        //                     return false;
                            
        //                 }
        //             }
        //         }
        //         return true;
        //     }
        //     else{
        //     return false;} 

        //}
        // private static void foo(Point f1, Point f2) {
        //     f1.translate(5, 5);
        //     f2 = new Point(19, 6);
        //     }

        // public static int mode(int[] arr) {
        //     int[] newarr = new int[arr.length];
            
        //         for(int i=0;i<arr.length;i++){
        //             for(int j=i+1;j<arr.length;j++){
        //                 if(arr[j]==arr[i]){
        //                     newarr[i]++;
        //                 }
        //             }
        //         }
        //         int largest = newarr[0];
        //         int largeidx = 0;
        //         for(int k=0;k<newarr.length;k++){
        //             if(newarr[k]>largest){
        //                 largest=newarr[k];
        //                 largeidx=k;
        //             }
        //             else if(newarr[k]==largest){
        //                 if(arr[k]<arr[largeidx]){
        //                     largeidx=k;
        //                 }
        //             }
                    
        //         }
        //         return arr[largeidx];


            
            
            //return arr[0];}

            public static int removeNegatives(int[] arr, int size) {
            int[] nums = Arrays.copyOf(arr,arr.length);
            for(int i=0;i<size;i++){
                System.out.println("i"+i+" val: "+nums[i]);
                if(nums[i]<0){
                    System.out.println("value found "+nums[i]);
                    for(int j=i;j<size-1;j++){ 
                        System.out.println("value before remove "+nums[j]);
                        nums[j]=nums[j+1];
                        System.out.println("value after  "+nums[j]); 
                    }
                    size--;
                    i--;
                    System.out.println("size and i after removal "+size+" i: "+i);
                }
                
            }
            return size; 
            }
        
 }