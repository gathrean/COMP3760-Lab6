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
     * @param first
     * @param last
     */
    public void RunRecursive(int first, int last) {

    }

    /**
     * Calculates SW(m, n) by using dynamic programming.
     * Please note that the calculations of SW and the return value are of type long.
     * No console output.
     *
     * @param m
     * @param n
     * @return
     */
    public long SW_DynamicProg(int m, int n) {

    }

    /**
     * Runs SW_DynamicProg in a loop, using values of m & n that are equal to each other.
     * Also uses one of the Java timing methods to measure the running time of each call
     * to SW_DynamicProg.
     *
     * @param first
     * @param last
     */
    public void RunDynamicProg(int first, int last) {

    }
}
