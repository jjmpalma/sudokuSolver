package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.tests.Examples;

public class Main {

    public static void main(String[] args) {

        for(int i = 0; i < 402; i++){
            Solver solver = new Solver(Examples.getExample(i));

            long start = System.currentTimeMillis();
            solver.solve();
            long timeTaken = System.currentTimeMillis()-start;

            System.out.println("Puzzle n " + i + " | " + "Gaps " + Examples.getGapCount(i) + " | " + "Time " + timeTaken);
        }

    }
}
