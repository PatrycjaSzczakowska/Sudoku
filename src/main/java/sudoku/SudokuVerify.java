package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SudokuVerify {
    List<SudokuField> fields = Arrays.asList(new SudokuField[9]);

    public SudokuVerify(final List<SudokuField> fields) {
        for (int i = 0; i < fields.size(); i++) {
            this.fields.set(i, fields.get(i));
        }
    }


    public boolean verify() {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int c = 0; c < 9; c++) {
            if (numbers.contains(fields.get(c).getFieldValue())) {
                numbers.remove(numbers.indexOf(fields.get(c).getFieldValue()));
            } else if (fields.get(c).getFieldValue() == 0) {
                //securacy block
            } else {
                return false;
            }
        }
        return true;
    }
}
