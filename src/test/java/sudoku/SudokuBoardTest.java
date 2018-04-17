package sudoku;

import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuBoardTest {

    @Test
    public void check() {
    }

    @Test
    public void get() {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudoku = new SudokuBoard(grid);

        assertEquals(sudoku.get(0, 0), 3);
        assertEquals(sudoku.get(1, 1), 2);
    }

    @Test
    public void set() {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudoku = new SudokuBoard(grid);

        assertEquals(sudoku.get(0, 0), 3);
        assertEquals(sudoku.get(1, 1), 2);
        assertEquals(sudoku.set(0, 1, 1), true);
        assertEquals(sudoku.set(0, 1, 3), false);

        int[][] grid2 = {{30, -2, 0, 1, 0, 5, 0, 0, 8},
                {0, 5, 9, 8, 0, 0, 0, 6, 7},
                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                {5, 3, 2, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 8, 4, 6},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {2, 6, 0, 0, 0, 8, 7, 3, 0},
                {9, 0, 0, 5, 0, 7, 0, 0, 0}};

        SudokuBoard sudoku2 = new SudokuBoard(grid2);
        assertEquals(sudoku2.get(0, 0), 0);
        assertEquals(sudoku2.get(0, 1), 0);

        assertEquals(sudoku2.get(8, 8), 0);
        assertEquals(sudoku2.set(8, 8, 2), true);
        assertEquals(sudoku2.get(8, 8), 2);

        assertEquals(sudoku2.set(8, 9, 3), false);

        assertEquals(sudoku2.set(8, 8, 12), false);

        assertEquals(sudoku2.set(8, 8, -1), false);

        int[][] grid3 = {{1, 0, 0, 1, 0, 5, 0, 0, 8},
                {0, 5, 9, 8, 0, 0, 0, 6, 7},
                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                {5, 3, 2, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 8, 4, 6},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {2, 6, 0, 0, 0, 8, 7, 3, 0},
                {9, 0, 0, 5, 0, 7, 0, 0, 0}};

        SudokuBoard sudoku3 = new SudokuBoard(grid3);

        for (int i=0; i<9;i++){
            for(int j=0;j<9;j++){
                assertEquals(sudoku3.get(i, j), 0);
            }
        }
    }

    @Test
    public void toStringTest() {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudoku = new SudokuBoard(grid);


        int[][] grid2 = {{0, 0, 0, 1, 0, 5, 0, 0, 8},
                {0, 5, 9, 8, 0, 0, 0, 6, 7},
                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                {5, 3, 2, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 8, 4, 6},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {2, 6, 0, 0, 0, 8, 7, 3, 0},
                {9, 0, 0, 5, 0, 7, 0, 0, 0}};

        SudokuBoard sudoku2 = new SudokuBoard(grid2);

        assertEquals(sudoku.toString() != sudoku2.toString(), true);

    }

    @Test
    public void getRowTest() {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudoku = new SudokuBoard(grid);

        SudokuRow row = sudoku.getRow(0);

        assertEquals(true, row.verify());
    }

    @Test
    public void getColumnTest() {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudoku = new SudokuBoard(grid);

        SudokuColumn column = sudoku.getColumn(3);

        assertEquals(true, column.verify());
    }

    @Test
    public void equalsTest() {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudoku = new SudokuBoard(grid);

        SudokuBoard sudoku2 = new SudokuBoard(grid);

        assertEquals(sudoku.equals(sudoku2), true);

        int[][] grid2 = {{1, 0, 0, 1, 0, 5, 0, 0, 8},
                {0, 5, 9, 8, 0, 0, 0, 6, 7},
                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                {5, 3, 2, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 8, 4, 6},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {2, 6, 0, 0, 0, 8, 7, 3, 0},
                {9, 0, 0, 5, 0, 7, 0, 0, 0}};

        SudokuBoard sudoku3 = new SudokuBoard(grid2);

        assertEquals(sudoku.equals(sudoku3),false);
    }

    @Test
    public void getHashTest() {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudoku = new SudokuBoard(grid);

        SudokuBoard sudoku2 = new SudokuBoard(grid);

        assertEquals(sudoku.hashCode(),sudoku2.hashCode());

        int[][] grid2 = {{1, 0, 0, 1, 0, 5, 0, 0, 8},
                {0, 5, 9, 8, 0, 0, 0, 6, 7},
                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                {5, 3, 2, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 8, 4, 6},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {2, 6, 0, 0, 0, 8, 7, 3, 0},
                {9, 0, 0, 5, 0, 7, 0, 0, 0}};

        SudokuBoard sudoku3 = new SudokuBoard(grid2);

        assertNotEquals(sudoku.hashCode(),sudoku3.hashCode());
    }
}