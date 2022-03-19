public class mineFieldTester {
    public static void main(String[] args){
        System.out.println("mine field tester");
        boolean[][] mines = 
        {{false, false, true, false}, 
         {true, false, true, false}, 
         {false, true, true, false}};
         //{false, true, false, true}};

        MineField mff = new MineField(mines);
        MineField mf = new MineField(9,9,10);
        System.out.println("Mff adjMines "+mff.numAdjacentMines(2, 3));
        
        mf.populateMineField(2, 3);
        System.out.println("\nadjMines "+mf.numAdjacentMines(2, 3));
        System.out.println("row cols"+mf.numRows()+mf.numCols());
        System.out.println("MFF row cols"+mff.numRows()+mff.numCols()); 
        System.out.println(mff.hasMine(3, 0));
        System.out.println(mff.inRange(4,4)); 

    }
    
}
