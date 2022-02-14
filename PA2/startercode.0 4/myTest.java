import java.util.Scanner;
import java.util.ArrayList;
import java.awt.*;
import java.util.Arrays;

public class myTest {
        public static void main(String[] args){
            // int nums=1;
            ArrayList<String> namesArr = new ArrayList<String>();
            int[] arr={12,8,8,5,5,4,3,2};
            System.out.println(arr.length%3);
            assert (arr.length%3 == 0);
            if(2==0){
                System.out.println("true");
            }
            int newSize = arr.length/3;
            int count=0;

        double[] newArr= new double[newSize];

        for(int i=0;i<arr.length-2;i++){
            int total = arr[i]+arr[i+1]+arr[i+2];
            double avg = total/(double)3;
            i+=2;
            if(count<newSize){
                newArr[count]=avg;
                count++;
            }
        }
        System.out.println( Arrays.toString(newArr)); 


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
 }