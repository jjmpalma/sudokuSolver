package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;

import java.util.HashSet;

public class Grid implements IGrid {

    private int[][] grid = new int[9][9];

    /**
     * Grid empty constructor
     */
    public Grid() {

    }

    @Override
    public int get(int x, int y) throws BadCellException {

        if ((x >= 0 && x <= 8) && (y >= 0 && y <= 9)) {
            return grid[y][x];

        } else {
            throw new BadCellException(x, y);
        }
    }

    @Override
    public void set(int x, int y, int val) throws BadCellException, BadDigitException {

        if ((x >= 0 && x <= 8) && (y >= 0 && y <= 8)) {
            if ((val >= 0 && val <= 9)) {
                grid[y][x] = val;

            } else {
                throw new BadDigitException(val);
            }
        } else {
            throw new BadCellException(x, y);
        }
    }

    @Override
    public boolean isValid() {

        if (rowColumnCheck() && squareCheck()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks there are no rows and columns with duplicated values
     *
     * @return true if no duplicated value found
     */
    private boolean rowColumnCheck() {

        HashSet<Integer> checkerRow = new HashSet<Integer>();
        HashSet<Integer> checkerColumn = new HashSet<Integer>();

        //Row and column checker
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                //Rows
                if ((grid[row][column] != 0) && (!checkerRow.add(grid[row][column]))) {
                    return false;
                }

                //Columns
                if ((grid[column][row] != 0) && (!checkerColumn.add(grid[column][row]))) {
                    return false;
                }

            }
            checkerRow.clear();
            checkerColumn.clear();
        }

        return true;
    }

    /**
     * Checks there are no 3x3 squares with duplicated values
     *
     * @return true if no duplicated value found
     */
    private boolean squareCheck() {

        HashSet<Integer> checker = new HashSet<Integer>();

        //first 2 for loops locate the top left item of each sub-square
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                //second 2 for loops traverse all 9 items on each sub-square
                for (int row = i; row < i + 3; row++) {
                    for (int column = j; column < j + 3; column++) {

                        if ((grid[row][column] != 0) && (!checker.add(grid[row][column]))) {
                            return false;
                        }
                    }
                }
                checker.clear();
            }
        }

        return true;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                b.append(get(x, y));
                b.append(" | ");
            }
            b.append('\n');
        }
        return b.toString();
    }
}
