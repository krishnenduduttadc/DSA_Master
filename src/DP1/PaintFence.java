package DP1;

public class PaintFence {
    public static void main(String[] args) throws Exception {

        int n = 5;
        int k = 3;

        long same = k * 1;
        long diff = k * (k - 1);
        long total = same + diff;
        for(int i = 3; i <=n;i++){
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }

        System.out.println(total);

    }
}
