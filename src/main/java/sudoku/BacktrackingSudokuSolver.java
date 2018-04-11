package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Pair {
    int first;
    int second;
    boolean empty;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
        this.empty = true;
    }


    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean isFlag() {
        return empty;
    }

    public void setFlag(boolean flag) {
        this.empty = flag;
    }
}

public class BacktrackingSudokuSolver implements SudokuSolver {
    public boolean solve(final SudokuBoard board) {
        Pair temp = findEmpty(board);
        if (temp.isFlag()) {
            return true;
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers);
        for (Integer num : numbers) {
            if (board.set(temp.getFirst(), temp.getSecond(), num)) {

                if (solve(board)) {
                    return true;
                }

                board.set(temp.getFirst(), temp.getSecond(), 0);
            }
        }
        return false;
    }

    Pair findEmpty(final SudokuBoard board) {
        Pair temp = new Pair(0, 0);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.get(row, col) == 0) {
                    temp.setFirst(row);
                    temp.setSecond(col);
                    temp.setFlag(false);
                    return temp;
                }
            }
        }
        return temp;
    }
}
