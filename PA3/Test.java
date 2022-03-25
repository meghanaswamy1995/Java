// import java.util.Arrays;
// import java.util.Random;

// // Name:Meghana Putta Swamy
// // USC NetID: mswamy
// // CS 455 PA3
// // Spring 2022


// /** 
//    MineField
//       class with locations of mines for a game.
//       This class is mutable, because we sometimes need to change it once it's created.
//       mutators: populateMineField, resetEmpty
//       includes convenience method to tell the number of mines adjacent to a location.
//  */
// public class MineField {
   
//    // <put instance variables here>
//    private boolean[][] mines;
//    private Random randomGen=new Random();
//    private int numOfMines=0;
//    private boolean isRandomMineField;
   
   
   
//    /**
//       Create a minefield with same dimensions as the given array, and populate it with the mines in the array
//       such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
//       this minefield will corresponds to the number of 'true' values in mineData.
//       @param mineData  the data for the mines; must have at least one row and one col,
//                        and must be rectangular (i.e., every row is the same length)
//     */
//    public MineField(boolean[][] mineData) {
//       assert mineData.length == mineData[0].length;

//       mines=new boolean[mineData.length][mineData[0].length];
//          if(mineData !=null){
//             for (int i = 0; i < mineData.length; i++) {
//                for(int j=0;j<mineData[0].length;j++){
//                   if(mineData[i][j]==true){
//                      numOfMines++;
//                   }
//                   mines[i][j] = mineData[i][j]; 
//                }
//             }
//          }
//       System.out.println(numOfMines);
//       isRandomMineField=false; 
//    }
   
   
//    /**
//       Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
//       populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
//       numMines() will not correspond to the number of mines currently in the MineField.
//       @param numRows  number of rows this minefield will have, must be positive
//       @param numCols  number of columns this minefield will have, must be positive
//       @param numMines   number of mines this minefield will have,  once we populate it.
//       PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
//     */
//    public MineField(int numRows, int numCols, int numMines) {
//       assert numRows > 0 && numCols > 0;
//       int limit = numRows * numCols; 
//       assert numMines < limit / 3.0;

//       //if(numRows == numCols){
//          mines= new boolean[numRows][numCols];
//          numOfMines = numMines; 
//       // }
//       // else{
//       //    return;
//       // }
//       isRandomMineField=true;
//    }
   

//    /**
//       Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
//       ensuring that no mine is placed at (row, col).
//       @param row the row of the location to avoid placing a mine
//       @param col the column of the location to avoid placing a mine
//       PRE: inRange(row, col) and numMines() < (1/3 * numRows() * numCols())
//     */
//    public void populateMineField(int row, int col) {
//       assert inRange(row, col);
//       int limit = numRows() * numCols(); 
//       assert numMines() < limit / 3.0;

//       if(isRandomMineField ){
//          resetEmpty();
//          for(int idx=0;idx<numOfMines;idx++){
//             int rw= randomGen.nextInt(numRows());
//             int cl = randomGen.nextInt(numCols());
//             while(rw==row && cl==col){
//                rw= randomGen.nextInt(numRows());
//                cl = randomGen.nextInt(numCols());
//             } 
//             if(rw!=row && cl!=col){
//                if(mines[rw][cl]!=true){ 
//                   mines[rw][cl]=true; 
//                }
//             }
//          }
//       }
//       else{
//          return;
//       }
//    }
   
   
//    /**
//       Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
//       Thus, after this call, the actual number of mines in the minefield does not match numMines().  
//       Note: This is the state a minefield created with the three-arg constructor is in 
//          at the beginning of a game.
//     */
//    public void resetEmpty() {
//       for(int j=0;j<mines.length;j++){
//          Arrays.fill(mines[j],false);
//       }
      
//    }

   
//   /**
//      Returns the number of mines adjacent to the specified mine location (not counting a possible 
//      mine at (row, col) itself).
//      Diagonals are also considered adjacent, so the return value will be in the range [0,8]
//      @param row  row of the location to check
//      @param col  column of the location to check
//      @return  the number of mines adjacent to the square at (row, col)
//      PRE: inRange(row, col)
//    */
//    public int numAdjacentMines(int row, int col) {
//       int adjMineCount=0;
//       if(inRange(row, col)){
      
//       int[][] eightAdjSqrs = {{-1,-1}, {-1,0}, {-1,1},
//       {0,-1}, {0,1},
//       {1,-1}, {1,0}, {1,1}}; 
//       if(row==0||row==mines.length-1||col==0||col==mines[0].length-1){
//          adjMineCount= checkBounds(row, col, mines); 
//       }
//      else{
//           for(int i=0;i<eightAdjSqrs.length;i++){
//               if(mines[row+eightAdjSqrs[i][0]][col+eightAdjSqrs[i][1]] == true){
//                   adjMineCount++;
//               }
//           }
//       }
//    }
//       return adjMineCount; 
//    }
   
   
//    /**
//       Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
//       start from 0.
//       @param row  row of the location to consider
//       @param col  column of the location to consider
//       @return whether (row, col) is a valid field location
//    */
//    public boolean inRange(int row, int col) {
//       if(row<0 || col<0|| row>=numRows() || col>=numCols()){
//          return false;
//       }
//          return true; 
//    }
   
   
//    /**
//       Returns the number of rows in the field.
//       @return number of rows in the field
//    */  
//    public int numRows() {
//       return mines.length;     
//    }
   
   
//    /**
//       Returns the number of columns in the field.
//       @return number of columns in the field
//    */    
//    public int numCols() {
//       return mines[0].length;
//    }
   
   
//    /**
//       Returns whether there is a mine in this square
//       @param row  row of the location to check
//       @param col  column of the location to check
//       @return whether there is a mine in this square
//       PRE: inRange(row, col)   
//    */    
//    public boolean hasMine(int row, int col) {
//       if(inRange(row, col)){
//       boolean isMine= mines[row][col];
//       if(isMine==true){
//          return true;
//       }
//    }
//       return false;
//    }
   
   
//    /**
//       Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
//       some of the time this value does not match the actual number of mines currently on the field.  See doc for that
//       constructor, resetEmpty, and populateMineField for more details.
//     * @return
//     */
//    public int numMines() {
//       return numOfMines; 
//    }

   
//    // <put private methods here>
//    private static int checkBounds(int row, int col, boolean[][] mines){
//         int adjMineCount=0;
//         int[][] zeroRowZeroCol={
//             {1,0},{0,1},{1,1}
//         };
//         int[][] zeroRowNthCol={
//             {1,0},{0,-1},{1,-1}
//         };
//         int[][] nthRowZeroCol={
//             {-1,0},{0,1},{-1,1}
//         };
//         int[][] nthRowNthCol={
//             {-1,0},{0,-1},{-1,-1}
//         };
//         int[][] zeroRowMiddleCol={
//             {1,0},{0,-1},{0,1},{1,-1},{1,1}
//         };
//         int[][] nthRowMiddleCol={
//             {-1,0},{0,-1},{-1,-1},{-1,1},{0,1}
//         };
//         int[][] zeroCol ={
//             {-1,0},{1,0},{1,1},{0,1},{-1,1}
//         };
//         int[][] nthCol ={
//             {-1,0},{1,0},{1,-1},{0,-1},{-1,-1}
//         };
//         if(row==0){
//             adjMineCount=rowBoundCheck(row,col,zeroRowZeroCol,zeroRowNthCol,zeroRowMiddleCol,mines);
//          }
//          else if(row==mines.length-1){
//              adjMineCount=rowBoundCheck(row, col, nthRowZeroCol, nthRowNthCol, nthRowMiddleCol, mines);

//          }
//          if(col==0 && row!=0 && row!=mines.length-1){
//             adjMineCount=colBoundCheck(row,col,zeroCol,mines);
//          }
//          else if(col==mines[0].length-1 && row!=0 && row!=mines.length-1){
//             adjMineCount=colBoundCheck(row,col,nthCol,mines);
//          }
//          return adjMineCount;

//     }

//     private static int rowBoundCheck(int row, int col, int[][] zeroCol, int[][] nthCol, int[][] middleCol,boolean[][] mines){
//       int adjMineCount=0;
//       if(col==0){
//           for(int i=0;i<zeroCol.length;i++){
//               if(mines[row+zeroCol[i][0]][col+zeroCol[i][1]] == true){
//                   adjMineCount++;
//               }
//           }
//       }
//       else if(col==mines[0].length-1){
//           for(int i=0;i<nthCol.length;i++){
//               if(mines[row+nthCol[i][0]][col+nthCol[i][1]] == true){ 
//                   adjMineCount++;
//               }
//           }  
//       }
//       else{
//           for(int i=0;i<middleCol.length;i++){
//               if(mines[row+middleCol[i][0]][col+middleCol[i][1]] == true){ 
//                   adjMineCount++;
//               }
//           } 
//       }
//       return adjMineCount; 
//   }

//   private static int colBoundCheck(int row, int col, int[][] colArr, boolean[][] mines){
//       int adjMineCount=0;
//       for(int i=0;i<colArr.length;i++){
//           if(mines[row+colArr[i][0]][col+colArr[i][1]] == true){
//               adjMineCount++;
//           }
//       }
//       return adjMineCount;
//   } 

         
// } 
