package StackL2;

public class TappingRainWater {
    public static int trap(int[] h) {
        int l = 0;
        int r = h.length - 1;

        int lmax = 0, rmax = 0;

        int ans = 0;

        while(l < r){
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);

            if(lmax < rmax){
                ans = ans + lmax - h[l];
                l++;
            } else {
                ans = ans + rmax - h[r];
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        int arr[] = {4,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(arr);
        System.out.println(result);
    }
}
