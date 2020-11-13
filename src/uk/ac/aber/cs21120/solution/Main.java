package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.tests.Examples;

public class Main {

    public static void main(String[] args) {

        long start, timeTaken;
        int gaps;

        Examples e = new Examples();

        for(int i = 1; i <= 402; i++){
            Solver solver = new Solver(e.getExample(i));

            gaps = e.getGapCount(i);

            start = System.currentTimeMillis();
            solver.solve();
            timeTaken = System.currentTimeMillis()-start;

            System.out.println("Puzzle n " + i + " | " + "Gaps " + gaps + " | " + "Time " + timeTaken);
        }

    }
}
