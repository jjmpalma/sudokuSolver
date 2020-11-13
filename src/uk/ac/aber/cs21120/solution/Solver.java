package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.interfaces.ISolver;

public class Solver implements ISolver {

    IGrid g;

    public Solver(IGrid g) {
        this.g = g;
    }

    @Override
    public boolean solve() {

        //For each item on the sudoku grid
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                //If the cell is empty
                if (g.get(row, column) == 0) {

                    //Insert digits from 0-9 and check if new layout is valid
                    for (int i = 1; i < 10; i++) {
                        g.set(row, column, i);
                        if (g.isValid()) {
                            if (solve()) {
                                return true;
                            }
                        }
                    }
                    //If not a valid digit found, set cell to empty
                    g.set(row, column, 0);
                    return false;
                }
            }
        }

        return true;
    }
}
