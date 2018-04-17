package sudoku;

import com.google.common.base.Objects;

import java.util.Arrays;
import java.util.List;

public class SudokuBoard {
    private List<SudokuField> board = Arrays.asList(new SudokuField[81]);

    public SudokuBoard(final int[][] board) { //final -> const
        SudokuField tmp;

        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                tmp = new SudokuField();
                if (board[i][j] < 0 || board[i][j] > 9) {
                    tmp.setFieldValue(0);
                    this.board.set(i * 9 + j, tmp);
                } else {
                    tmp.setFieldValue(board[i][j]);
                    this.board.set(i * 9 + j, tmp);
                }
            }
        }

        if (!checkBoard()) {
            for (SudokuField field : this.board) {
                field.setFieldValue(0);
            }
        }
    }

    private boolean checkBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int num = board.get(row * 9 + col).getFieldValue();
                //System.out.println(row+"  "+col+"  :   "+num);
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
        return board.get(x * 9 + y).getFieldValue();
    }

    public boolean set(int x, int y, int value) {
        // if (value < 0 || value > 9) {
        //    return false;
        //}
        try {

            if (value != 0) {
                if (!checkNumber(value, x, y)) {
                    return false;
                }
            }

            board.get(x * 9 + y).setFieldValue(value);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public SudokuRow getRow(int row) {
        List<SudokuField> rows = Arrays.asList(new SudokuField[9]);

        for (int i = 0; i < 9; i++) {
            rows.set(i, board.get(row * 9 + i));
        }
        return new SudokuRow(rows);
    }

    public SudokuColumn getColumn(int column) {
        List<SudokuField> columns = Arrays.asList(new SudokuField[9]);
        for (int i = 0; i < 9; i++) {
            columns.set(i, board.get(i * 9 + column));
        }
        return new SudokuColumn(columns);
    }

    public SudokuBox getBox(int row, int column) {
        int tempR = row - row % 3;
        int tempC = column - column % 3;
        List<SudokuField> boxes = Arrays.asList(new SudokuField[9]);

        int i = 0;
        for (int r = tempR; r < tempR + 3; r++) {
            for (int c = tempC; c < tempC + 3; c++) {
                boxes.set(i, board.get(r * 9 + c));
                i++;
            }
        }
        return new SudokuBox(boxes);
    }

    private boolean checkNumber(int number, int row, int column) {
        if (number < 0 || number > 9) {
            return false;
        }
        board.get(row * 9 + column).setFieldValue(number);
        if (getBox(row, column).verify()
                && getRow(row).verify()
                && getColumn(column).verify()) {
            return true;
        }
        board.get(row * 9 + column).setFieldValue(0);
        return false;
    }

    @Override
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
                    stringBuilder.append(board.get(i * 9 + j).getFieldValue());
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append(board.get(i * 9 + j).getFieldValue());
                    stringBuilder.append("  ");
                }
            }
        }
        return stringBuilder.toString();
    }


    @Override
    public int hashCode() {

        return Objects.hashCode(
                this.board);

    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SudokuBoard other = (SudokuBoard) obj;
        return Objects.equal(this.board, other.board);
    }
}
