package BinarySearchL1;

public class MedianOf2SortedArray {

        public double findMedianSortedArrays(int[] a, int[] b) {
            int n1 = a.length;
            int n2 = b.length;
            if (n1 > n2)
                return findMedianSortedArrays(b, a);

            int lo = 0, hi = n1;
            int t = n1+n2;
            while(lo<=hi){
                int m1 = (lo+hi)/2;
                int m2 = (t+1)/2 - m1;
                int am = (m1 == a.length) ? Integer.MAX_VALUE : a[m1];
                int am1 = (m1==0) ? Integer.MIN_VALUE : a[m1-1];
                int bm = (m2 == b.length) ? Integer.MAX_VALUE : b[m2];
                int bm1 = (m2 == 0) ? Integer.MIN_VALUE : b[m2-1];

                if(am1 <= bm && bm1 <= am){
                    if(t%2 != 0){
                        return Math.max(am1 , bm1);
                    } else {
                        double lmax = Math.max(am1 , bm1);
                        double rmax = Math.min(am , bm);
                        return (lmax+rmax)/2;
                    }
                } else if(am1 > bm){
                    hi = m1 - 1;
                } else if(bm1 > am){
                    lo = m1 + 1;
                }

            }
            return 0.0;
        }
    public static void main(String[] args) {
        MedianOf2SortedArray solution = new MedianOf2SortedArray();

        // Example test cases
        int[] a1 = {1, 3};
        int[] b1 = {2};
        System.out.println("Median of arrays a1 and b1: " + solution.findMedianSortedArrays(a1, b1)); // Output: 2.0

        int[] a2 = {1, 2};
        int[] b2 = {3, 4};
        System.out.println("Median of arrays a2 and b2: " + solution.findMedianSortedArrays(a2, b2)); // Output: 2.5
    }


    }
