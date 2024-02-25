package ArraysL1;

public class BrokenEconomy {
    public static void main(String[] args) throws Exception {
        // write your code here

        int n = 5;

        int[] a = {4,3,6,2,1};


        int d = 2;

        int l = 0;
        int h = a.length - 1;
        int ceil = 0;
        int floor = 0;

        while(l <= h){
            int m = (l + h) / 2;
            if(d < a[m]){
                h = m - 1;
                ceil = a[m];
            } else if(d > a[m]){
                l = m + 1;
                floor = a[m];
            } else {
                ceil = a[m];
                floor = a[m];
                break;
            }
        }

        System.out.println(ceil);
        System.out.println(floor);
    }
}
