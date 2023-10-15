package ArraysL2;

public class CarPooling {
    public static boolean carPooling(int trips[][], int cap) {
        // write your code here
        int l = -1;
        for(int trip[] : trips){
            l = Math.max(l, trip[1]);
        }

        int h[ ]= new int[l + 1];

        for(int trip[] : trips){
            h[trip[0]] += trip[2];
            h[trip[1]] -= trip[2];
        }

        for(int i = 1; i <= l; i++){
            h[i] = h[i] + h[i - 1];
            if(h[i] > cap){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int trips[][] = {
                {1,5,2},
                {4,8,1},
                {11,15,3}
        };
        int cap = 3;
        if (carPooling(trips, cap)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
