package sudoku;

public class SudokuBoardDaoFactory {
    public Dao getFileDao(final String fileName) {
        Dao dao = new FileSudokuBoardDao(fileName);
        return dao;
    }
}
