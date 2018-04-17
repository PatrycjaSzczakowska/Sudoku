package sudoku;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileSudokuBoardDao implements Dao<SudokuBoard> {
    private String fileName;

    public FileSudokuBoardDao(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoard read() {

        int[][] grid = new int[9][9];

        try {
            File file = new File(fileName);

            Scanner scanner = new Scanner(file);

            int i = 0;

            while (scanner.hasNextInt()) {
                grid[(int) i / 9][i % 9] = scanner.nextInt();
                i++;
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new SudokuBoard(grid);
    }

    @Override
    public void write(final SudokuBoard obj) {
        try {
            File file = new File(fileName);

            PrintWriter printWriter = new PrintWriter(file);

            int tmp;

            for (int i = 0; i < 81; i++) {
                printWriter.print(obj.get((int) i / 9, i % 9));
                if (i % 9 == 8) {
                    printWriter.write("\r\n");
                } else {
                    printWriter.write(" ");
                }
            }
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finalize() {
    }
}

