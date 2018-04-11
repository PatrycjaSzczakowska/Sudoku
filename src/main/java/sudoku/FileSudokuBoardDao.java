package sudoku;

import java.io.*;
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

        } catch (IOException e) {
            System.out.println("ERROR WITH FILE");
        }

        SudokuBoard temp = new SudokuBoard(grid);

        return temp;
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

        } catch (IOException e) {
            System.out.println("ERROR WITH FILE");
        }
    }

    @Override
    public void finalize() {

    }
}

