package benchmarks;

import java.util.Random;

/**
 * Credit:
 * https://github.com/isstac/canopy/blob/master/src/examples/sampling/batch/InsertionSort.java
 * 
 * @author Jacob Burnim <jburnim@cs.berkeley.edu>
 */
public class InsertionSort {

    public static void sort(int[] a) {
        final int N = a.length;
        for (int i = 1; i < N; i++) { // N branches
            int j = i - 1;
            int x = a[i];
            // First branch (j >= 0): 2 + 3 + ... + N = N(N+1)/2 - 1 branches
            // Second branch (a[j] > x): 1 + 2 + ... + N-1 = (N-1)N/2 branches
            while ((j >= 0) && (a[j] > x)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = x;
        }
    }

    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        Random rand = new Random();
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = rand.nextInt(i + 1);// Concolic.input.Integer();
        }

        // We only measure the complexity of the sort itself. That
        // is, we count branches only from this point forward in the
        // execution.
        // Concolic.ResetBranchCounting();

        sort(a);
    }
}