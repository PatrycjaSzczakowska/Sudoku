package sudoku;

public class SudokuRow extends SudokuVerify{
    public SudokuRow(SudokuField[] fields) {
        super(fields);
    }

    public void show(){
        for (int i = 0; i < 9; i++) {
            System.out.println(fields[i].getFieldValue());
        }

    }
}
