package CP_maths;

/*
===============================================================
    INCLUSION–EXCLUSION PRINCIPLE (IEP)
    ===============================================================

    ⚡ Motivation:
    Often we want to count how many objects satisfy certain conditions,
    but counting directly is hard.
    → IEP allows us to "subtract overcounts".

    ---------------------------------------------------------------
    1. Formula for Two Sets:
       |A ∪ B| = |A| + |B| - |A ∩ B|

    2. Formula for Three Sets:
       |A ∪ B ∪ C| = |A| + |B| + |C|
                     - |A∩B| - |A∩C| - |B∩C|
                     + |A∩B∩C|

    3. General Formula:
       For sets A1, A2, ..., An:
       |A1 ∪ A2 ∪ ... ∪ An|
       = Σ |Ai|
         - Σ |Ai∩Aj|
         + Σ |Ai∩Aj∩Ak|
         - ... + (-1)^(k+1) Σ |Ai1∩Ai2∩...∩Aik|

    ---------------------------------------------------------------
    4. Applications in CP:
       - Counting numbers divisible by at least one prime
       - Derangements (permutations with no fixed point)
       - Counting with restrictions ("at least one condition fails")
       - Probability problems

    ---------------------------------------------------------------
    5. Example Problem:
       Count numbers ≤ N that are divisible by 2, 3, or 5.

       Approach:
         |A2| = ⌊N/2⌋
         |A3| = ⌊N/3⌋
         |A5| = ⌊N/5⌋
         |A2∩A3| = ⌊N/6⌋
         |A2∩A5| = ⌊N/10⌋
         |A3∩A5| = ⌊N/15⌋
         |A2∩A3∩A5| = ⌊N/30⌋

       Final count = |A2|+|A3|+|A5|
                    -|A2∩A3|-|A2∩A5|-|A3∩A5|
                    +|A2∩A3∩A5|
===============================================================
*/

class InclusionExclusion {
    // Count numbers <= N divisible by at least one number in arr
    static long countDivisible(long N, int[] arr) {
        int n = arr.length;
        long ans = 0;

        // iterate over all subsets of arr
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    lcm = lcm(lcm, arr[i]);
                    if (lcm > N) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                long cnt = N / lcm;
                if (bits % 2 == 1) ans += cnt;
                else ans -= cnt;
            }
        }
        return ans;
    }

    // gcd
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // lcm
    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        long N = 100;
        System.out.println("Numbers ≤ " + N + " divisible by 2,3,or5 = " +
                countDivisible(N, arr));

        // Another check
        System.out.println("Numbers ≤ 1000 divisible by 2,3,5,7 = " +
                countDivisible(1000, new int[]{2, 3, 5, 7}));
    }
}

/*
===============================================================
⚡ Key Takeaways:
- Inclusion–Exclusion alternates + and - over intersections
- Works perfectly with subset-iteration in CP
- Used for divisibility, derangements, restrictions
===============================================================
*/

