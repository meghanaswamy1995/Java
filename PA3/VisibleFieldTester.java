import java.util.Arrays;

public class VisibleFieldTester {
    
    public static void main(String[] args){
     boolean[][] smallMineField = 
      {{false, false, false, false,false,true}, 
       {true, false, false, false,false,true}, 
       {false, false, false, false,false,false},
       {false, false, false, false,false,true},
       {false, false, false, true,false,false},
       {false, false, false, true,false,false} 
    };
       MineField mineField = new MineField(smallMineField);
       int[][] visibleField = new int[smallMineField.length][smallMineField[0].length];
       for(int i=0;i<visibleField.length;i++){
           Arrays.fill(visibleField[i],-1);
       }
       int initialRow=2;
       int initialCol =2;
       int count=0;
       boolean[][] checkVisited = new boolean[mineField.numRows()][mineField.numCols()];
       for(int i=0;i<checkVisited.length;i++){
        Arrays.fill(checkVisited[i],false);
        }

       try{
       boolean uncoverCheck=uncover(2,2,mineField,visibleField,initialRow, initialCol, checkVisited);
       System.out.println(uncoverCheck);
       }
       catch(Exception e){
           System.out.println("out of bound");
         }


       for(int i=0;i< visibleField.length;i++){
           System.out.println();
           for(int j=0; j< visibleField[0].length;j++){
            System.out.print( " "+visibleField[i][j]); 
           }
       }
       

    }

   // public static boolean uncover(int row, int col, MineField mineField, int[][] visibleField, boolean[][] field, int iniRow, int iniCol, boolean[][] checkVisited) throws IndexOutOfBoundsException{ 
        public static boolean uncover(int row, int col, MineField mineField, int[][] visibleField, int iniRow, int iniCol, boolean[][] checkVisited) throws IndexOutOfBoundsException{ 
        
        assert mineField.inRange(row, col);
        
        final int MINE_GUESS=-2;
        final int EXPLODED_MINE=11;
        int adjMines=0;
        //System.out.println("current "+ row+col);
        //if(row<0 || col<0|| row>=mineField.numRows()|| col>= mineField.numCols()||(row==iniRow && col == iniCol && count!=0) || checkVisited[row][col]==true ||visibleField[row][col]==MINE_GUESS){
        if(row<0 || col<0|| row>=mineField.numRows()|| col>= mineField.numCols() || checkVisited[row][col]==true ||visibleField[row][col]==MINE_GUESS){
        
            System.out.println("val out of bound "+ row+col);
            return true;
        }
       // else if (visibleField[row][col]!=MINE_GUESS || row<0 || col<0|| row>=mineField.numRows()|| col>= mineField.numCols()  ){
        else{
            //count=1;
            checkVisited[row][col]=true;
            if(mineField.hasMine(row,col)){
                visibleField[row][col]=EXPLODED_MINE;
                return false;
            }
           adjMines=mineField.numAdjacentMines(row, col);
           if(adjMines==0){
              //squaresOpenToWin--;
              System.out.println("recurssive search");
                //visibleField[row][col]=100;
                visibleField[row][col]=adjMines; 
            uncover(row-1,col-1,mineField,visibleField,iniRow,iniCol,checkVisited);
            uncover(row-1,col,mineField,visibleField,iniRow,iniCol,checkVisited); 
            uncover(row-1,col+1,mineField,visibleField,iniRow,iniCol,checkVisited);
            uncover(row,col-1,mineField,visibleField,iniRow,iniCol,checkVisited);
            uncover(row,col+1,mineField,visibleField,iniRow,iniCol,checkVisited); 
            uncover(row+1,col-1,mineField,visibleField,iniRow,iniCol,checkVisited);  
            uncover(row+1,col,mineField,visibleField,iniRow,iniCol,checkVisited); 
            uncover(row+1,col+1,mineField,visibleField,iniRow,iniCol,checkVisited); 

              //visibleField[row][col]=adjMines; 

           }
           else{
              //squaresOpenToWin--;
              visibleField[row][col]=adjMines;
           }
           return true;
        }
        //return true;
     }
    
}
