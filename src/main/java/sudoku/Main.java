package sudoku;

public class Main {
    public static void main(final String[] args) {

        int[][] grid3 = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        int[][] grid4 = {{3, 0, 6, 5, 0, 8, 4, 0, 1},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudoku3 = new SudokuBoard(grid3);

        SudokuBoard sudoku4 = new SudokuBoard(grid3);

        SudokuBoard sudoku5 = new SudokuBoard(grid4);

        System.out.println(sudoku3.equals(sudoku5));
        //System.out.println(sudoku3.hashCode());
        //System.out.println(sudoku4.hashCode());


        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
//
        solver.solve(sudoku3);


//
//        System.out.println(sudoku3.toString());

        FileSudokuBoardDao fileSudokuBoardDaoRead=new FileSudokuBoardDao("D:\\STUDIA\\2rok\\IVsemestr\\Komponentowe\\sudoku\\plik.txt");
        SudokuBoard board=fileSudokuBoardDaoRead.read();
        System.out.println(board.toString());

        FileSudokuBoardDao fileSudokuBoardDaoWrite=new FileSudokuBoardDao("D:\\STUDIA\\2rok\\IVsemestr\\Komponentowe\\sudoku\\plikWyj.txt");
        fileSudokuBoardDaoWrite.write(sudoku3);

        //System.out.println(sudoku3.get(0,0));
    }
}
