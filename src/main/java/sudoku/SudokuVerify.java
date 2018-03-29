package sudoku;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class SudokuVerify {
    SudokuField[] fields;

    public SudokuVerify(SudokuField[] fields) {
        this.fields = fields;
    }


    public boolean verify() {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int c = 0; c < 9; c++) {
            if (numbers.contains(fields[c].getFieldValue())) {
                numbers.remove(numbers.indexOf(fields[c].getFieldValue()));
            } else if (fields[c].getFieldValue() == 0) {

            } else {

                return false;

            }
        }
        return true;
    }
}
