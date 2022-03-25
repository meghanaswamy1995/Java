import java.util.Arrays;

public class mineFieldTester {
     public static void main(String[] args){
         boolean[][] mymines = 
        {{false}};
        MineField mff = new MineField(mymines);

//          boolean[][] mm = {{false, false, true, false}, 
//          {true, false, true, false}, 
//          {false, true, true,false},
//          {false, true, false, true}};

//         MineField mff = new MineField(mymines);
//         for (int i = 0; i < mff.mines.length; i++) {
//             System.out.println();
//                for(int j=0;j<mff.mines[0].length;j++){
//                   System.out.print(mff.mines[i][j]);
//                }
//             } 
//             System.out.println("\n");
//         for (int i = 0; i < mymines.length; i++) {
//                 System.out.println();
//                    for(int j=0;j<mymines[0].length;j++){
//                       System.out.print(mymines[i][j]);
//                    }
//                 } 
        
//         if(Arrays.deepEquals(mff.mines,mymines)){ 
//             System.out.println("\nmine array is equal");   
//         }
//         else{
//             System.out.println("\narray not equal");
//         }
// System.out.println("=======");

//         if(Arrays.deepEquals(mm,mymines)){ 
//             System.out.println("\nmm array is equal");
//         }
//         else{
//             System.out.println("\nmm - array not equal"); 
//         }
//         //MineField mf = new MineField(9,9,10);
//         //System.out.println("Mff adjMines "+mff.numAdjacentMines(2, 3));
        
//         //mf.populateMineField(2, 3);
//         //System.out.println("\nadjMines "+mf.numAdjacentMines(2, 3));
//        // System.out.println("row cols"+mf.numRows()+mf.numCols());
//         // System.out.println("MFF row cols"+mff.numRows()+mff.numCols()); 
//         // System.out.println(mff.hasMine(3, 0));
//         // System.out.println(mff.inRange(4,4)); 
//         //mff.populateMineField(row, col);

     }
    
 }
