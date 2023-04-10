public class SudokuGame 
{
    public int[][] grid;

    SudokuGame()
    {
        grid = new int[9][9]; //empty
    }

    SudokuGame(String start){  
        grid = new int[9][9];
        for(int x = 0; x <9; x++)
        {
            for(int y =0; y<9; y++)
            {
                grid[x][y] = 0;
            }
        }

        grid[0][0] = 5;//top left most 
        grid[0][1] = 3;
        grid[0][4] = 7;
        grid[1][0] = 6;
        grid[1][3] = 1;
        grid[1][4] = 9;
        grid[1][5] = 5;
        grid[2][1] = 9;
        grid[2][2] = 8;
        grid[2][7] = 6;
        grid[3][0] = 8;
        grid[3][4] = 6;
        grid[3][8] = 3;
        grid[4][0] = 4;
        grid[4][3] = 8;
        grid[4][5] = 3;
        grid[4][8] = 1;
        grid[5][0] = 7;
        grid[5][4] = 2;
        grid[5][8] = 6;
        grid[6][1] = 6;
        grid[6][6] = 2;
        grid[6][7] = 8;
        grid[7][3] = 4;
        grid[7][4] = 1;
        grid[7][5] = 9;
        grid[7][8] = 5;
        grid[8][4] = 8;
        grid[8][7] = 7;
        grid[8][8] = 9; //bottom right most

    }

    public void printMySudokuGame(){
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                System.out.println(" -----------------------");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(grid[i][j] == 0 ? " ": Integer.toString(grid[i][j]));

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    public boolean insertVal(int row, int col, int myVal){
        System.out.println("row " + row + "column " + col + " myVal " + myVal);
        if(checkRow(row, col, myVal) == false) 
            return false;

        if(checkCol(row, col, myVal) == false)
            return false;

        if(checkBox(row, col, myVal) == false) 
            return false;
                                                                                                                            
        grid[row][col] = myVal;
        
        return true;

    }

    public boolean removeVal(int row, int col) {
        grid[row][col] = 0;

        return true;
    }

    private boolean checkRow(int row, int col, int myVal) {
        for (int a = 0; a < 9; ++a)  // row
            if (myVal == grid[row][a]){
                System.out.println(myVal + " Already in Row: " + row);
                return false;
            }
        return true;

    }
    private boolean checkCol(int row, int col, int myVal) {
        for (int b = 0; b < 9; ++b)  // column
            if (myVal == grid[b][col]){
                System.out.println(myVal + " Already in Column: " + col);  
                return false;
            }
        return true;

    }

    private boolean checkBox(int row, int col, int myVal) {
        int boxRowOffset = (row / 3)*3;   //if the quotient is 0 then value is in first row of grids,if the quotient is 1 then value is second row of grids and if the quotient is 2 then value is third row of grids//
        int boxColOffset = (col / 3)*3;    //if the quotient is 0 then value is in first column of grids,if the quotient is 1 then value is second column of grids and if the quotient is 2 then value is third column of grids//
        for (int c = 0; c < 3; ++c) // box
            for (int d = 0; d < 3; ++d)
                if (myVal == grid[boxRowOffset+c][boxColOffset+d]){
                    System.out.println(myVal + " Already in Box " );
                     return false;
                }
        return true;

    }
}