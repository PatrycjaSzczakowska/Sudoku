package sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class FileSudokuBoardDaoTest {

    @Test
    public void writeAndRead() {
        int[][] grid={{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard board1=new SudokuBoard(grid);

        FileSudokuBoardDao dao=new FileSudokuBoardDao("D:\\STUDIA\\2rok\\IVsemestr\\Komponentowe\\sudoku\\plik.txt");

        dao.write(board1);

        SudokuBoard board=dao.read();

        Assert.assertEquals(board.toString(),board1.toString());
    }

    @Test
    public void wrongFile() {

        int [][]grid=new int[9][9];

        SudokuBoard board=new SudokuBoard(grid);

        FileSudokuBoardDao dao=new FileSudokuBoardDao("D:\\STUDIA\\2rok\\IVsemestr\\Komponentowe\\sudoku\\pk.t");

        SudokuBoard board2=dao.read();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        Assert.assertEquals(board.toString(),board2.toString());
        //Assert.assertEquals("ERROR WITH FILE", outContent.toString());
    }
}