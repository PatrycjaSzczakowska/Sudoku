package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BacktrackingSudokuSolver implements SudokuSolver {
    public boolean solve(final SudokuBoard board) {
        int[] temp;
        temp = findEmpty(board);
        if (temp[0] == 10) {
            return true;
        }

        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers);
        for (Integer num : numbers) {
            if (board.set(temp[0], temp[1], num)) {

                if (solve(board)) {
                    return true;
                }

                board.set(temp[0], temp[1], 0);
            }
        }
        return false;
    }

    int[] findEmpty(final SudokuBoard board) {
        int[] temp = new int[2];
        temp[0] = 10;
        temp[1] = 10;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.get(row, col) == 0) {
                    temp[0] = row;
                    temp[1] = col;
                    return temp;
                }
            }
        }
        return temp;
    }
}
