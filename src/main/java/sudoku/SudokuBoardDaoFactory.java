package sudoku;

public class SudokuBoardDaoFactory {
    public Dao getFileDao(final String fileName) {
        return new FileSudokuBoardDao(fileName);
    }
}
