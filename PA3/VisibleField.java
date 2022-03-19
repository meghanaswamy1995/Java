import java.util.Arrays;

// Name:
// USC NetID:
// CS 455 PA3
// Spring 2022


/**
  VisibleField class
  This is the data that's being displayed at any one point in the game (i.e., visible field, because it's what the
  user can see about the minefield). Client can call getStatus(row, col) for any square.
  It actually has data about the whole current state of the game, including  
  the underlying mine field (getMineField()).  Other accessors related to game status: numMinesLeft(), isGameOver().
  It also has mutators related to actions the player could do (resetGameDisplay(), cycleGuess(), uncover()),
  and changes the game state accordingly.
  
  It, along with the MineField (accessible in mineField instance variable), forms
  the Model for the game application, whereas GameBoardPanel is the View and Controller, in the MVC design pattern.
  It contains the MineField that it's partially displaying.  That MineField can be accessed (or modified) from 
  outside this class via the getMineField accessor.  
 */
public class VisibleField {
   // ----------------------------------------------------------   
   // The following public constants (plus numbers mentioned in comments below) are the possible states of one
   // location (a "square") in the visible field (all are values that can be returned by public method 
   // getStatus(row, col)).
   
   // The following are the covered states (all negative values):
   public static final int COVERED = -1;   // initial value of all squares
   public static final int MINE_GUESS = -2;
   public static final int QUESTION = -3;

   // The following are the uncovered states (all non-negative values):
   
   // values in the range [0,8] corresponds to number of mines adjacent to this square
   
   public static final int MINE = 9;      // this loc is a mine that hasn't been guessed already (end of losing game)
   public static final int INCORRECT_GUESS = 10;  // is displayed a specific way at the end of losing game
   public static final int EXPLODED_MINE = 11;   // the one you uncovered by mistake (that caused you to lose)
   // ----------------------------------------------------------   
  
   // <put instance variables here>
   
   private MineField mineField;
   private int[][] visibleField;
   private int mineGuessLeft;
   private int squaresOpenToWin;
   private boolean[][] checkVisited;
   
   
   /**
      Create a visible field that has the given underlying mineField.
      The initial state will have all the mines covered up, no mines guessed, and the game
      not over.
      @param mineField  the minefield to use for for this VisibleField
    */
   public VisibleField(MineField mineField) {
      this.mineField=mineField;
      mineGuessLeft=mineField.numMines(); 
      visibleField = new int[mineField.numRows()][mineField.numCols()]; 
      checkVisited = new boolean[mineField.numRows()][mineField.numCols()]; 
      for(int i=0;i<visibleField.length;i++){
            Arrays.fill(visibleField[i],COVERED); 
      }
      squaresOpenToWin=(mineField.numRows()*mineField.numCols())-mineField.numMines();
      for(int j=0;j<checkVisited.length;j++){
         Arrays.fill(checkVisited[j],false); 
      }
   }
   
   
   /**
      Reset the object to its initial state (see constructor comments), using the same underlying
      MineField. 
   */     
   public void resetGameDisplay() {
      for(int i=0;i<visibleField.length;i++){
            Arrays.fill(visibleField[i],COVERED); 
      }
      mineGuessLeft=mineField.numMines();
      squaresOpenToWin=(mineField.numRows()*mineField.numCols())-mineField.numMines();
      for(int j=0;j<checkVisited.length;j++){
         Arrays.fill(checkVisited[j],false); 
      }
  
   }
  
   
   /**
      Returns a reference to the mineField that this VisibleField "covers"
      @return the minefield
    */
   public MineField getMineField() {
      return mineField; 
   }
   
   
   /**
      Returns the visible status of the square indicated.
      @param row  row of the square
      @param col  col of the square
      @return the status of the square at location (row, col).  See the public constants at the beginning of the class
      for the possible values that may be returned, and their meanings.
      PRE: getMineField().inRange(row, col)
    */
   public int getStatus(int row, int col) {
      assert getMineField().inRange(row,col);
      if(visibleField[row][col]==COVERED){
         return COVERED;
      }
      else if(visibleField[row][col]==MINE_GUESS){
         return MINE_GUESS;
      }
      else if(visibleField[row][col]==QUESTION){
         return QUESTION;
      }
      else if(visibleField[row][col]==MINE_GUESS){
         return MINE_GUESS;
      }
      else if(visibleField[row][col]==MINE){
         return MINE;
      }
      else if(visibleField[row][col]==INCORRECT_GUESS){
         return INCORRECT_GUESS;
      }
      else if(visibleField[row][col]==EXPLODED_MINE){
         return EXPLODED_MINE;
      }
      else{
      return visibleField[row][col];    
      }   
   }

   
   /**
      Returns the the number of mines left to guess.  This has nothing to do with whether the mines guessed are correct
      or not.  Just gives the user an indication of how many more mines the user might want to guess.  This value can
      be negative, if they have guessed more than the number of mines in the minefield.     
      @return the number of mines left to guess.
    */
   public int numMinesLeft() {
      return mineGuessLeft;  

   }
 
   
   /**
      Cycles through covered states for a square, updating number of guesses as necessary.  Call on a COVERED square
      changes its status to MINE_GUESS; call on a MINE_GUESS square changes it to QUESTION;  call on a QUESTION square
      changes it to COVERED again; call on an uncovered square has no effect.  
      @param row  row of the square
      @param col  col of the square
      PRE: getMineField().inRange(row, col)
    */

   //  public static final int COVERED = -1; 
   //  public static final int MINE_GUESS = -2;
   //  public static final int QUESTION = -3;
   //  public static final int MINE = 9;    
   //  public static final int INCORRECT_GUESS = 10; 
   //  public static final int EXPLODED_MINE = 11;


   public void cycleGuess(int row, int col) {
      assert mineField.inRange(row, col);
      if(visibleField[row][col]==COVERED){
         visibleField[row][col]=MINE_GUESS;
         mineGuessLeft--;
      }
      else if(visibleField[row][col]==MINE_GUESS){
         visibleField[row][col]=QUESTION;
         mineGuessLeft++;
      }
      else if(visibleField[row][col]==QUESTION){
         visibleField[row][col]=COVERED;
      }
      else{
         return;
      } 
   }

   
   /**
      Uncovers this square and returns false iff you uncover a mine here.
      If the square wasn't a mine or adjacent to a mine it also uncovers all the squares in 
      the neighboring area that are also not next to any mines, possibly uncovering a large region.
      Any mine-adjacent squares you reach will also be uncovered, and form 
      (possibly along with parts of the edge of the whole field) the boundary of this region.
      Does not uncover, or keep searching through, squares that have the status MINE_GUESS. 
      Note: this action may cause the game to end: either in a win (opened all the non-mine squares)
      or a loss (opened a mine).
      @param row  of the square
      @param col  of the square
      @return false   iff you uncover a mine at (row, col)
      PRE: getMineField().inRange(row, col)
    */
   public boolean uncover(int row, int col) {
      assert mineField.inRange(row, col);
      int initialRow=row;
      int initialCol=col;
      return uncoverRecurssive(row,col,initialRow,initialCol);
      
   }
   
   /**
      Returns whether the game is over.
      (Note: This is not a mutator.)
      @return whether game over
    */
   public boolean isGameOver() {
      String winStat="";
      for(int i=0;i<visibleField.length;i++){
         for(int j=0; j<visibleField[0].length;j++){
            if (visibleField[i][j]== EXPLODED_MINE){
               winStat="lost";
               updateVisibleField(winStat);
               return true;
            }
            if(squaresOpenToWin==0){
               winStat="won";
               updateVisibleField(winStat); 
               return true;
            }
         }
      }
      return false;   
   }
 
  
   /**
      Returns whether this square has been uncovered.  (i.e., is in any one of the uncovered states, 
      vs. any one of the covered states).
      @param row of the square
      @param col of the square
      @return whether the square is uncovered
      PRE: getMineField().inRange(row, col)
    */
   public boolean isUncovered(int row, int col) {
      assert mineField.inRange(row, col);
      if(visibleField[row][col]==COVERED || visibleField[row][col]==MINE_GUESS || visibleField[row][col]==QUESTION){
         return false;
      }
      return true; 
   }
   
 
   /**
      Uncovers this square and returns false iff you uncover a mine here.
      If the square wasn't a mine or adjacent to a mine it also uncovers all the squares in 
      the neighboring area that are also not next to any mines, possibly uncovering a large region.
      Any mine-adjacent squares you reach will also be uncovered, and form 
      (possibly along with parts of the edge of the whole field) the boundary of this region.
      Does not uncover, or keep searching through, squares that have the status MINE_GUESS. 
      Note: this action may cause the game to end: either in a win (opened all the non-mine squares)
      or a loss (opened a mine).
      @param row of the square
      @param col of the square
      @param initialRow the row value whihc triggered the recurssion
      @param initialCol the column vale that triggered the recurssion
      @return whether the square is uncovered
      
    */
   private boolean uncoverRecurssive(int row, int col, int initialRow, int initialCol){
      int adjMines=0;
      if(row<0 || col<0|| row>=mineField.numRows()|| col>= mineField.numCols() || checkVisited[row][col]==true ||visibleField[row][col]==MINE_GUESS){
         return true;
     }
     else{
      checkVisited[row][col]=true;
      if(mineField.hasMine(row,col)){
          visibleField[row][col]=EXPLODED_MINE;
          return false;
      }
      adjMines=mineField.numAdjacentMines(row, col);
      if(adjMines==0){
         squaresOpenToWin--;
         visibleField[row][col]=adjMines; 
         uncoverRecurssive(row-1,col-1,initialRow,initialCol); 
         uncoverRecurssive(row-1,col,initialRow,initialCol);
         uncoverRecurssive(row-1,col+1,initialRow,initialCol);
         uncoverRecurssive(row,col-1,initialRow,initialCol);
         uncoverRecurssive(row,col+1,initialRow,initialCol);
         uncoverRecurssive(row+1,col-1,initialRow,initialCol);
         uncoverRecurssive(row+1,col,initialRow,initialCol);
         uncoverRecurssive(row+1,col+1,initialRow,initialCol);

      }
      else{
         squaresOpenToWin--;
         visibleField[row][col]=adjMines;
      } 
      return true;
      }
     
   } 

    /**
      This method is called when Game is over. Irrespective of win or loss, this method updates the visibleField after the game conditions.
      It sets INCORRECT_GUESS and COVERED Mine
      @param winStat Takes a string value for our reference to check whether game was lost or won.
    */
   private void updateVisibleField(String winStat){
      for(int row=0;row<mineField.numRows();row++){
         for(int col=0;col<mineField.numCols();col++){
            if(mineField.hasMine(row, col) && visibleField[row][col] !=MINE_GUESS && visibleField[row][col] != EXPLODED_MINE){ 
               if(winStat.equals("lost")){
               visibleField[row][col]=MINE;
               }
               else{
                  visibleField[row][col]=MINE_GUESS; 
               }
            }
            if(mineField.hasMine(row, col)==false && visibleField[row][col] ==MINE_GUESS ){ 
               visibleField[row][col]=INCORRECT_GUESS;
            }
         }
      }
   }
   
}
