package sudoku;

import java.util.*;

public class SudokuBoard {
    private SudokuField[][] board;

    public SudokuBoard(final int[][] board) { //final -> const
        this.board = new SudokuField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board[i][j] = new SudokuField();
            }
        }

        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                this.board[i][j].getFieldValue();
                this.board[i][j].setFieldValue(board[i][j]);
            }
        }
    }

    private boolean checkBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int num = board[row][col].getFieldValue();
                if (num != 0) {
                    if (!checkNumber(num, row, col)) { //causes lots of errors
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int get(int x, int y) {
        return board[x][y].getFieldValue();
    }

    public boolean set(int x, int y, int value) {
        if (value < 0 || value > 9) {
            return false;
        }
        try {

            if (value != 0) {
                if (!checkNumber(value, x, y)) {
                    return false;
                }
            }

            board[x][y].setFieldValue(value);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public SudokuRow getRow(int row) {
        SudokuField[] tmp = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            tmp[i] = new SudokuField();
            tmp[i].setFieldValue(board[row][i].getFieldValue());
        }
        return new SudokuRow(tmp);
    }

    public SudokuColumn getColumn(int column) {
        SudokuField[] tmp = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            tmp[i] = new SudokuField();
            tmp[i].setFieldValue(board[i][column].getFieldValue());
        }
        return new SudokuColumn(tmp);
    }

    public SudokuBox getBox(int row, int column) {
        int tempR = row - row % 3;
        int tempC = column - column % 3;
        SudokuField[] tmp = new SudokuField[9];

        for (int i = 0; i < 9; i++) {
            tmp[i] = new SudokuField();
        }

        int i = 0;
        for (int r = tempR; r < tempR + 3; r++) {
            for (int c = tempC; c < tempC + 3; c++) {
                tmp[i].setFieldValue(board[r][c].getFieldValue());
                i++;
            }
        }
        return new SudokuBox(tmp);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i == 3 || i == 6) && j == 0) {
                    stringBuilder.append("-----------------------------\n");
                }
                if ((j == 3 || j == 6)) {
                    stringBuilder.append("| ");
                }
                if (j == 8) {
                    stringBuilder.append(board[i][j].getFieldValue());
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append(board[i][j].getFieldValue());
                    stringBuilder.append("  ");
                }
            }
        }
        return stringBuilder.toString();
    }

    private boolean checkNumber(int number, int row, int column) {

        board[row][column].setFieldValue(number);
        if (getBox(row, column).verify()
                && getBox(row, column).verify()
                && getBox(row, column).verify()) {
            return true;
        }
        board[row][column].setFieldValue(0);
        return false;
    }

}
