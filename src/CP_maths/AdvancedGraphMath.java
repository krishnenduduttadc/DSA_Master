package CP_maths;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
========================================================================
 AdvancedGraphMath.java
 ---------------------
 Collection of advanced graph-math tools for Competitive Programming.

 Contents:
  - Determinant modulo prime (Gaussian elimination)
  - Matrix-Tree theorem (Kirchhoff) to count spanning trees (unweighted / weighted)
  - Cayley's formula: number of labeled trees = n^(n-2)
  - Matrix exponentiation to count number of walks of length k
  - Utilities: build Laplacian, modular arithmetic helpers
  - Examples in main()

 Theory (short):
  - Matrix-Tree (Kirchhoff): For an undirected graph with Laplacian L,
      number of spanning trees = det( L' ) where L' is any (n-1)x(n-1) principal minor of L.
    For weighted graphs where edge (u,v) has weight w_uv, put w into Laplacian
    diagonal entries and -w into off-diagonals; determinant of minor gives sum
    over all spanning trees of product of edge weights in that tree.
  - Determinant modulo prime can be computed with Gaussian elimination, using modular inverses.
  - Cayley: complete graph on n labeled vertices has n^(n-2) spanning trees.
========================================================================
*/

public class AdvancedGraphMath {

    static final long MOD = 1000000007L; // use prime modulus for determinant etc.

    // -------------------------
    // Modular helpers
    // -------------------------
    static long modAdd(long a, long b) {
        a += b;
        if (a >= MOD) a -= MOD;
        return a;
    }

    static long modSubLong(long a, long b) {
        a -= b;
        if (a < 0) a += MOD;
        return a;
    }

    static long modMulLong(long a, long b) {
        return (a % MOD) * (b % MOD) % MOD;
    }

    static long modPow(long a, long e) {
        long res = 1 % MOD;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = modMulLong(res, a);
            a = modMulLong(a, a);
            e >>= 1;
        }
        return res;
    }

    static long modInverse(long a) {
        return modPow((a % MOD + MOD) % MOD, MOD - 2);
    }

    // -------------------------
    // Determinant modulo prime (Gaussian elimination)
    // -------------------------
    /*
      Compute det(A) modulo MOD where MOD is prime (so inverses exist for non-zero pivots).
      This function mutates a copy of matrix passed to avoid changing caller's matrix.
      Returns determinant in [0, MOD-1].
      Complexity: O(n^3)
    */
    static long determinantMod(long[][] mat, int n) {
        // Working on copy
        long[][] a = new long[n][n];
        for (int i = 0; i < n; i++) System.arraycopy(mat[i], 0, a[i], 0, n);

        long det = 1;
        for (int col = 0, row = 0; col < n && row < n; col++, row++) {
            // find pivot at or below row
            int sel = row;
            while (sel < n && a[sel][col] % MOD == 0) sel++;
            if (sel == n) { // pivot column has all zeros => determinant 0
                det = 0;
                break;
            }
            if (sel != row) {
                // swap rows sel and row -> changes sign of determinant
                long[] tmp = a[sel];
                a[sel] = a[row];
                a[row] = tmp;
                det = (MOD - det) % MOD; // multiply by -1
            }
            long pivot = (a[row][col] % MOD + MOD) % MOD;
            det = modMulLong(det, pivot);

            long invPivot = modInverse(pivot);

            // normalize row by pivot (optional) and eliminate below
            for (int r = row + 1; r < n; r++) {
                if (a[r][col] % MOD == 0) continue;
                long factor = modMulLong(a[r][col], invPivot);
                // row_r -= factor * row_row
                for (int c = col; c < n; c++) {
                    long val = (a[r][c] - modMulLong(factor, a[row][c])) % MOD;
                    if (val < 0) val += MOD;
                    a[r][c] = val;
                }
            }
        }
        return (det % MOD + MOD) % MOD;
    }

    // -------------------------
    // Build Laplacian matrix for undirected graph (weighted or unweighted)
    // nodes numbered 0..n-1
    // For weight 1 unweighted graph, pass edges with weight 1
    // Laplacian L:
    //   L[i][i] = sum of weights of edges incident to i
    //   L[i][j] = -weight(i,j) for i != j (sum of negative weights if multiple edges)
    // -------------------------
    static long[][] buildLaplacian(int n, List<int[]> edges) {
        // edges: list of {u, v} (unweighted, weight=1)
        long[][] L = new long[n][n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            L[u][u] = (L[u][u] + 1) % MOD;
            L[v][v] = (L[v][v] + 1) % MOD;
            L[u][v] = (L[u][v] - 1) % MOD;
            L[v][u] = (L[v][u] - 1) % MOD;
        }
        // normalize negatives into [0,MOD)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (L[i][j] < 0) L[i][j] += MOD;
            }
        return L;
    }

    // Weighted edges version: edges as {u, v, w} with w long (use mod)
    static long[][] buildLaplacianWeighted(int n, List<long[]> edges) {
        long[][] L = new long[n][n];
        for (long[] e : edges) {
            int u = (int) e[0], v = (int) e[1];
            long w = e[2] % MOD;
            L[u][u] = (L[u][u] + w) % MOD;
            L[v][v] = (L[v][v] + w) % MOD;
            L[u][v] = (L[u][v] - w) % MOD;
            L[v][u] = (L[v][u] - w) % MOD;
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (L[i][j] < 0) L[i][j] += MOD;
            }
        return L;
    }

    // -------------------------
    // Matrix-Tree theorem (Kirchhoff)
    // Count spanning trees for undirected graph (unweighted)
    // Use Laplacian and compute any (n-1)x(n-1) principal minor determinant.
    // Returns number mod MOD.
    // Complexity: O(n^3)
    // -------------------------
    static long countSpanningTrees(int n, List<int[]> edges) {
        long[][] L = buildLaplacian(n, edges);
        // build minor by removing last row & col (indices 0..n-2)
        int m = n - 1;
        if (m <= 0) return 1; // single node
        long[][] minor = new long[m][m];
        for (int i = 0; i < m; i++) for (int j = 0; j < m; j++) minor[i][j] = L[i][j];
        return determinantMod(minor, m);
    }

    // Weighted version: returns sum over spanning trees of product of edge weights (mod MOD)
    static long countSpanningTreesWeighted(int n, List<long[]> weightedEdges) {
        long[][] L = buildLaplacianWeighted(n, weightedEdges);
        int m = n - 1;
        if (m <= 0) return 1;
        long[][] minor = new long[m][m];
        for (int i = 0; i < m; i++) for (int j = 0; j < m; j++) minor[i][j] = L[i][j];
        return determinantMod(minor, m);
    }

    // -------------------------
    // Cayley's formula: number of labeled trees on n vertices = n^(n-2)
    // -------------------------
    static long cayleyCount(int n) {
        if (n <= 1) return 1;
        return modPow(n, n - 2);
    }

    // -------------------------
    // Count number of walks of length k between all pairs: adjacency matrix exponentiation
    // Returns matrix A^k (mod MOD)
    // Complexity: O(n^3 log k)
    // Useful for counting walks, paths of fixed length (not simple paths).
    // -------------------------
    static long[][] matMul(long[][] A, long[][] B) {
        int n = A.length;
        int m = B[0].length;
        int p = B.length;
        long[][] C = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int k = 0; k < p; k++)
                if (A[i][k] != 0) {
                    long aik = A[i][k];
                    for (int j = 0; j < m; j++) {
                        C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                    }
                }
        return C;
    }

    static long[][] matPow(long[][] A, long exp) {
        int n = A.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        long[][] base = new long[n][n];
        for (int i = 0; i < n; i++) System.arraycopy(A[i], 0, base[i], 0, n);

        while (exp > 0) {
            if ((exp & 1) == 1) res = matMul(res, base);
            base = matMul(base, base);
            exp >>= 1;
        }
        return res;
    }

    // -------------------------
    // Small utilities: check connectivity (spanning tree count 0 if disconnected)
    // -------------------------
    static boolean isConnected(int n, List<int[]> edges) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        boolean[] vis = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        vis[0] = true;
        int cnt = 1;
        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : g[u])
                if (!vis[v]) {
                    vis[v] = true;
                    dq.add(v);
                    cnt++;
                }
        }
        return cnt == n;
    }

    // -------------------------
    // Main: examples & quick tests
    // -------------------------
    public static void main(String[] args) {
        // Example 1: small triangle (3 nodes, 3 edges) => spanning trees = 3
        int n1 = 3;
        List<int[]> edges1 = new ArrayList<>();
        edges1.add(new int[]{0, 1});
        edges1.add(new int[]{1, 2});
        edges1.add(new int[]{2, 0});
        System.out.println("Triangle spanning trees (Kirchhoff) = " + countSpanningTrees(n1, edges1)); // 3

        // Example 2: path of 3 nodes => spanning trees = 1
        int n2 = 3;
        List<int[]> edges2 = new ArrayList<>();
        edges2.add(new int[]{0, 1});
        edges2.add(new int[]{1, 2});
        System.out.println("Path(3) spanning trees = " + countSpanningTrees(n2, edges2)); // 1

        // Example 3: Complete graph K_n spanning trees = n^(n-2) (Cayley)
        int n3 = 5;
        System.out.println("Complete graph K_" + n3 + " spanning trees (Cayley) = " + cayleyCount(n3));

        // Example 4: weighted spanning trees (triangle with weights)
        // edges represented as {u,v,w}
        List<long[]> weighted = new ArrayList<>();
        weighted.add(new long[]{0, 1, 2}); // weight 2 on edge 0-1
        weighted.add(new long[]{1, 2, 3}); // weight 3 on edge 1-2
        weighted.add(new long[]{2, 0, 5}); // weight 5 on edge 2-0
        System.out.println("Weighted triangle spanning trees (sum of product weights) = " +
                countSpanningTreesWeighted(3, weighted));
        // For triangle, sum of products of weights of spanning trees:
        // remove each edge and product of other two weights: (2*3)+(2*5)+(3*5)=6+10+15=31

        // Example 5: adjacency matrix walks length k
        int n4 = 3;
        long[][] A = new long[n4][n4];
        // path 0-1-2
        A[0][1] = 1;
        A[1][0] = 1;
        A[1][2] = 1;
        A[2][1] = 1;
        long k = 2;
        long[][] Ak = matPow(A, k);
        System.out.println("Number of walks length " + k + " from 0 to 2 = " + Ak[0][2]); // 1 walk: 0-1-2

        // Example 6: disconnected graph -> Kirchhoff determinant will be 0
        int nd = 4;
        List<int[]> edgesD = new ArrayList<>();
        edgesD.add(new int[]{0, 1});
        edgesD.add(new int[]{2, 3});
        System.out.println("Disconnected spanning trees (should be 0) = " + countSpanningTrees(nd, edgesD));
    }
}
