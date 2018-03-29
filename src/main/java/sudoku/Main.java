package sudoku;

public class Main {
    public static void main(final String[] args) {
        int[][] grid2=new int [9][9];

        SudokuBoard sudoku2=new SudokuBoard(grid2);

        BacktrackingSudokuSolver solver=new BacktrackingSudokuSolver();

        System.out.println(sudoku2.toString());

        solver.solve(sudoku2);

        System.out.println(sudoku2.toString());
    }
}
