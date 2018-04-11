package sudoku;

public class SudokuField {
    private int value;

    public SudokuField() {
        this.value = 0;
    }

    public int getFieldValue() {
        return value;
    }

    public boolean setFieldValue(int newValue) {
        //if (value < 0 || value > 9) {
        //    return false;
        //} else {
        value = newValue;
        //}
        return true;
    }
}
