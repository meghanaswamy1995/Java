// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.Map;
// import java.util.TreeMap;


// public class StringProcessing {
//     private Map<Character,Integer> individualLetters ;
//     private String uniqueLetter;
//     private String multiplicityCount;
//     private int[] multiplicityArr;
//     //private int[] charCount;
//    // private String str;
    
//     public StringProcessing(){
        
//         individualLetters = new TreeMap<Character,Integer>(); 
//         //multiplicityArr= new int[26];
//        // charCount = new int[26];
//        // str="";
//         uniqueLetter="";
//         multiplicityCount="";
        
//     }
//     public void processString(String rackString){
//         resetMap();
        
//         for(int i=0;i<rackString.length();i++){ 
//             // int asciiChar = (int) rackString.charAt(i);
//             // int index=0;
//             // if(asciiChar <97){
//             //     index = asciiChar-65;
//             //     //System.out.println("index: "+index);
//             // }
//             // else{
                
//             //     index = asciiChar-97;
//             //     //System.out.println("index: "+index);
//             // }
//             // if(charCount[index]==0){
//             //     uniqueLetter+=rackString.charAt(i);
//             // }
//             // //System.out.println("char at index: "+ charCount[index]);
//             //  charCount[index]++;

//             Integer val = individualLetters.get(rackString.charAt(i));
//             if(val == null){
//                individualLetters.put(rackString.charAt(i),1);
//             }
//             else{
//             individualLetters.put(rackString.charAt(i),val+1);  
//             }
//          } 
//         //  int count=0;
//         //  multiplicityArr = new int[uniqueLetter.length()];
//         //  for(int i=0;i<charCount.length;i++){
//         //      if(charCount[i]>0){
//         //      multiplicityCount+=charCount[i];
//         //      multiplicityArr[count]=charCount[i];
//         //         count++; 
//         //     }
//              //System.out.println("Character count arr : "+ multiplicityArr[i]);
//          //} 
//          //System.out.println("uniqqqqq:"+uniqueLetter);
//         calculateUniqueLettersCount();
    
//      }


//     private void calculateUniqueLettersCount(){ 
        
//         multiplicityArr = new int[individualLetters.size()];
//         int count=0;
//         uniqueLetter="";
//         multiplicityCount="";  
//         Iterator<Map.Entry<Character,Integer>> iter = individualLetters.entrySet().iterator();

//         while(iter.hasNext()){
//            if(count<=individualLetters.size()){
//            Map.Entry<Character,Integer> currVal =iter.next();
//            Character key =currVal.getKey();
//            uniqueLetter+=key;
//            int keysVal = currVal.getValue();
//                 multiplicityCount+=keysVal;
//               multiplicityArr[count]=keysVal;
//               count++; 
//            }
//         }
//         //System.out.println("uniquletter: "+uniqueLetter+" multiplcitycnt: "+multiplicityCount); 
//     }
//     private void resetMap(){
//         // Arrays.fill(charCount,0); 
//         // uniqueLetter="";
//         // multiplicityCount="";
//         individualLetters.clear();
//     }

//     public String getMultiplicityCount(){
//         return multiplicityCount;     
//     }
//     public String getUniqueLetters(){
//         return uniqueLetter;
//     }
//     public int[] getMultiplicityArr(){
//         return multiplicityArr;
//     }
    
// }
