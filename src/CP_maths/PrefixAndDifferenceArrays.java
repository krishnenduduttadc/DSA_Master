package CP_maths;

/*
===============================================================
    PREFIX SUMS & DIFFERENCE ARRAYS
    ===============================================================

    ⚡ Why important in CP?
    - Efficiently handle queries like:
        * Range sum queries (sum of subarray [L..R])
        * Range updates (add value to all elements in [L..R])
        * 2D grid problems (submatrix sums, image processing, etc.)
    - Common in Codeforces/CodeChef problems where constraints are huge.

    ---------------------------------------------------------------
    1. 1D Prefix Sum
       prefix[i] = a[0] + a[1] + ... + a[i]
       Then:
         sum(L..R) = prefix[R] - prefix[L-1]   (O(1))

       Precompute prefix array in O(n)
       Each query in O(1)

    ---------------------------------------------------------------
    2. 2D Prefix Sum (for matrices)
       prefix[i][j] = sum of all elements in rectangle (0,0) to (i,j)
       Then:
         sum(x1..x2, y1..y2) =
             prefix[x2][y2]
           - prefix[x1-1][y2]
           - prefix[x2][y1-1]
           + prefix[x1-1][y1-1]

    ---------------------------------------------------------------
    3. Difference Array (1D)
       Used for RANGE UPDATES efficiently.
       Idea:
         - diff[i] = a[i] - a[i-1]
         - To add "val" to range [L..R]:
               diff[L] += val
               diff[R+1] -= val
         - Final array = prefix sum of diff[]

       Complexity:
         * Update in O(1)
         * Build final array in O(n)

    ---------------------------------------------------------------
    4. Difference Array (2D)
       For 2D grids, range updates are done by modifying 4 corners:
           diff[x1][y1]     += val
           diff[x2+1][y1]   -= val
           diff[x1][y2+1]   -= val
           diff[x2+1][y2+1] += val
       Then reconstruct grid using prefix sums.

===============================================================
*/

import java.util.Arrays;

class PrefixAndDifferenceArrays {

    // 1D Prefix Sum
    static int[] buildPrefix(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    static int rangeSum(int[] prefix, int L, int R) {
        if (L == 0) return prefix[R];
        return prefix[R] - prefix[L - 1];
    }

    // 1D Difference Array
    static int[] buildDiff(int[] arr) {
        int n = arr.length;
        int[] diff = new int[n];
        diff[0] = arr[0];
        for (int i = 1; i < n; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
        return diff;
    }

    static void rangeUpdate(int[] diff, int L, int R, int val) {
        diff[L] += val;
        if (R + 1 < diff.length) diff[R + 1] -= val;
    }

    static int[] reconstructFromDiff(int[] diff) {
        int n = diff.length;
        int[] arr = new int[n];
        arr[0] = diff[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + diff[i];
        }
        return arr;
    }

    // 2D Prefix Sum
    static int[][] buildPrefix2D(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] prefix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i][j] = mat[i][j];
                if (i > 0) prefix[i][j] += prefix[i - 1][j];
                if (j > 0) prefix[i][j] += prefix[i][j - 1];
                if (i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }
        return prefix;
    }

    static int rangeSum2D(int[][] prefix, int x1, int y1, int x2, int y2) {
        int res = prefix[x2][y2];
        if (x1 > 0) res -= prefix[x1 - 1][y2];
        if (y1 > 0) res -= prefix[x2][y1 - 1];
        if (x1 > 0 && y1 > 0) res += prefix[x1 - 1][y1 - 1];
        return res;
    }

    public static void main(String[] args) {
        // ===== 1D Prefix Sum Example =====
        int[] arr = {1, 2, 3, 4, 5};
        int[] prefix = buildPrefix(arr);
        System.out.println("Sum of [1..3] = " + rangeSum(prefix, 1, 3)); // Expected 2+3+4=9

        // ===== 1D Difference Array Example =====
        int[] diff = buildDiff(arr);
        rangeUpdate(diff, 1, 3, 10); // Add 10 to arr[1..3]
        int[] updatedArr = reconstructFromDiff(diff);
        System.out.println("Array after range update [1..3]+=10: " + Arrays.toString(updatedArr));

        // ===== 2D Prefix Sum Example =====
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] prefix2D = buildPrefix2D(mat);
        System.out.println("Sum of submatrix [(1,1) to (2,2)] = " +
                rangeSum2D(prefix2D, 1, 1, 2, 2)); // Expected 5+6+8+9 = 28
    }
}

/*
===============================================================
⚡ Key Takeaways:
- 1D prefix sums: O(n) preprocessing, O(1) query
- 1D difference array: O(1) range updates, O(n) reconstruction
- 2D prefix sums: O(n*m) preprocessing, O(1) submatrix queries
- 2D difference arrays allow fast submatrix range updates
===============================================================
*/

