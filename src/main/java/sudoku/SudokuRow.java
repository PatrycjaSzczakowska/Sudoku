package sudoku;

import java.util.List;

public class SudokuRow extends SudokuVerify {
    public SudokuRow(final List<SudokuField> fields) {
        super(fields);
    }

//    public void show() {
//        for (int i = 0; i < 9; i++) {
//            System.out.println(fields[i].getFieldValue());
//        }
//    }
}
