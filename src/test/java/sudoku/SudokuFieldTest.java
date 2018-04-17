package sudoku;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuFieldTest {

    @Test
    public void setAndGetFieldValueTest() {
        SudokuField field=new SudokuField();
        field.setFieldValue(5);
        Assert.assertEquals(5,field.getFieldValue());
    }


    @Test
    public void hashCodeTest() {
        SudokuField field=new SudokuField();
        field.setFieldValue(5);

        SudokuField field2=new SudokuField();
        field2.setFieldValue(5);

        Assert.assertEquals(field.hashCode(),field2.hashCode());

        SudokuField field3=new SudokuField();
        field2.setFieldValue(7);

        Assert.assertNotEquals(field3.hashCode(),field2.hashCode());
    }

    @Test
    public void equalsTest() {
        SudokuField field=new SudokuField();
        field.setFieldValue(5);

        SudokuField field2=new SudokuField();
        field2.setFieldValue(5);

        Assert.assertEquals(true,field.equals(field2));

        SudokuField field3=new SudokuField();
        field2.setFieldValue(7);

        Assert.assertEquals(false,field.equals(field2));
    }
}