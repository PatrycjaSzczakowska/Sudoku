package sudoku;

import org.junit.Test;

import static org.junit.Assert.*;

public class BacktrackingSudokuSolverTest {

    @Test
    public void solve() {
        int[][] grid = {{0, 0, 0, 1, 0, 5, 0, 0, 8},
                {0, 5, 9, 8, 0, 0, 0, 6, 7},
                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                {5, 3, 2, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 8, 4, 6},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {2, 6, 0, 0, 0, 8, 7, 3, 0},
                {9, 0, 0, 5, 0, 7, 0, 0, 0}};
        SudokuBoard sudoku = new SudokuBoard(grid);

        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

        assertEquals(solver.solve(sudoku), true);

        int[][] grid2 = new int[9][9];
        SudokuBoard sudoku2 = new SudokuBoard(grid2);

        int[][] grid3 = new int[9][9];
        SudokuBoard sudoku3 = new SudokuBoard(grid3);

        assertEquals(solver.solve(sudoku2), true);

        assertEquals(solver.solve(sudoku3), true);

        assertEquals(sudoku2.toString() != sudoku3.toString(), true);

    }

    @Test
    public void findEmpty() {
        int[][] grid = {{0, 0, 0, 1, 0, 5, 0, 0, 8},
                {0, 5, 9, 8, 0, 0, 0, 6, 7},
                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                {5, 3, 2, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 8, 4, 6},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {2, 6, 0, 0, 0, 8, 7, 3, 0},
                {9, 0, 0, 5, 0, 7, 0, 0, 0}};
        SudokuBoard sudoku = new SudokuBoard(grid);

        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

        int[] tab = solver.findEmpty(sudoku);

        assertEquals(tab[0] != 10, true);

        solver.solve(sudoku);


        tab = solver.findEmpty(sudoku);
        assertEquals(tab[0] == 10, true);

    }
}