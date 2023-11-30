/**
 * LAB 6
 * <p>
 * Student Name: Gathrean Dela Cruz.
 * Student ID: A01167248.
 * <p>
 * Program Description: <p>
 * - Given any two such locations on a grid of city streets,
 * how many different paths are there to walk from the first
 * location to the second location? <p>
 * - Assume that all walks proceed down to the right.
 */
public class Lab6 {

    /**
     * Calculates and returns SW_Recursive(m, n) by using the recursive definition given above.
     * Please note that the calculations of SW and the return value are of type long.
     * No console output.
     *
     * @param m - how many blocks down
     * @param n - how many blocks to the right
     * @return - A recursive call to SW_Recursive, which returns the number of paths
     */
    public long SW_Recursive(int m, int n) {
        // Base Case
        // If m is 0, it means walking n blocks straight to the right
        // If n is 0, it means walking m blocks straight down
        if (m == 0 || n == 0) {
            return 1;
        }

        // Recursive Case
        return SW_Recursive(m - 1, n) + SW_Recursive(m, n - 1);
    }

    /**
     * Runs SW_Recursive in a loop, using values of m & n that are equal to each other.
     * Also uses one of the Java timing methods to measure the running time of each call
     * to SW_Recursive.
     *
     * @param first - starting number
     * @param last  - stopping number
     */
    public void RunRecursive(int first, int last) {
        int currentValue = first; // Initialize with the 'first' value

        while (currentValue <= last) {
            // Track the start and end time of each call to SW_Recursive
            long startTime = System.currentTimeMillis();
            long endTime;

            // Calculate the result recursively
            long result = SW_Recursive(currentValue, currentValue);

            endTime = System.nanoTime(); // Update the end time after the calculation

            double elapsedTimeMillis = (endTime - startTime) / 1_000_000.0;

            // Print out the result and the time it took to calculate it
            System.out.println("SW_Recursive(" + currentValue + "," + currentValue + ") = " + result
                    + ", time it took: " + String.format("%.4f", elapsedTimeMillis) + " ms");

            currentValue++; // Increment the value for the next iteration
        }
    }

    /**
     * Calculates SW(m, n) by using dynamic programming.
     * Please note that the calculations of SW and the return value are of type long.
     * No console output.
     *
     * @param m - how many blocks down
     * @param n - how many blocks to the right
     * @return - The value of SW(m, n)
     */
    public long SW_DynamicProg(int m, int n) {
        // Create a 2D array to save the values of SW
        long[][] savedValues = new long[m + 1][n + 1];

        // Fill the 2D array with the values of SW
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If i or j is 0, it means walking straight down or straight to the right
                if (i == 0 || j == 0) {
                    savedValues[i][j] = 1;
                } else { // Otherwise, calculate the value of SW
                    savedValues[i][j] = savedValues[i - 1][j] + savedValues[i][j - 1];
                }
            }
        }

        // Done
        return savedValues[m][n];
    }

    /**
     * Runs SW_DynamicProg in a loop, using values of m & n that are equal to each other.
     * Also uses one of the Java timing methods to measure the running time of each call
     * to SW_DynamicProg.
     *
     * @param first - starting number
     * @param last  - stopping number
     */
    public void RunDynamicProg(int first, int last) {
        int currentValue = first; // Initialize with the 'first' value

        while (currentValue <= last) {
            // Track the start and end time of each call to SW_DynamicProg
            long startTime = System.currentTimeMillis();
            long endTime;

            // Calculate the result using dynamic programming
            long result = SW_DynamicProg(currentValue, currentValue);

            endTime = System.nanoTime(); // Update the end time after the calculation

            double elapsedTimeMillis = (endTime - startTime) / 1_000_000.0;

            // Print out the result and the time it took to calculate it
            System.out.println("SW_DynamicProg(" + currentValue + "," + currentValue + ") = " + result
                    + ", time it took: " + String.format("%.4f", elapsedTimeMillis) + " ms");

            currentValue++; // Increment the value for the next iteration
        }

    }

    /**
     * Main method
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        int first = 3;
        int last = 7;
        Lab6 lab6 = new Lab6();

        // Run the recursive method
        System.out.println("Recursive Method:");
        lab6.RunRecursive(first, last);

        // Run the dynamic programming method
        System.out.println("\nDynamic Programming Method:");
        lab6.RunDynamicProg(first, last);
    }
}
