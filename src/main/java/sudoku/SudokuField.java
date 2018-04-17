package sudoku;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

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

    @Override
    public int hashCode() {

        return Objects.hashCode(
                this.value);

    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SudokuField other = (SudokuField) obj;
        return Objects.equal(this.value, other.value);
    }

    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .add("field value", value)
                .toString();
    }
}
