package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;

import java.util.HashSet;

public class Grid implements IGrid {

    int[][] grid = new int[9][9];

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

        HashSet<Integer> checker1 = new HashSet<Integer>();
        HashSet<Integer> checker2 = new HashSet<Integer>();

        //Row and column checker
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                //Rows
                if ((grid[row][column] != 0) && (!checker1.add(grid[row][column]))) {
                    return false;
                }

                //Columns
                if ((grid[column][row] != 0) && (!checker2.add(grid[column][row]))) {
                    return false;
                }

            }
            checker1.clear();
            checker2.clear();
        }

        checker1.clear();

        //Square checker
        //first 2 for loops locate the top left item of each sub-square
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                //second 2 for loops traverse all 9 items on each sub-square
                for (int row = i; row < i + 3; row++) {
                    for (int column = j; column < j + 3; column++) {

                        if ((grid[row][column] != 0) && (!checker1.add(grid[row][column]))) {
                            return false;
                        }
                    }
                }
                checker1.clear();
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
