package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.interfaces.ISolver;

public class Solver implements ISolver {

    private IGrid g = new Grid();

    public Solver(IGrid g) {
        this.g = g;
    }

    @Override
    public boolean solve() {

        //For each grid cell
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                //If the cell is empty
                if (g.get(column, row) == 0) {

                    //Insert digits from 1-9
                    for (int i = 1; i < 10; i++) {
                        g.set(column, row, i);

                        //If digit inserted valid
                        if (g.isValid()) {

                            //Recursive backtracking
                            if (solve()) {
                                return true;
                            }
                        }
                    }
                    //If digit not valid, set cell to empty
                    g.set(column, row, 0);
                    return false;
                }
            }
        }

        return true;
    }
}
