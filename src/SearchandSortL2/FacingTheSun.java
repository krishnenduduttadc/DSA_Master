package SearchandSortL2;

public class FacingTheSun {
    public static int countBuildings(int[] ht) {
        //write your code here
        int lmax = ht[0];
        int c = 1;

        for (int i = 1; i < ht.length; i++) {
            if (ht[i] > lmax) {
                c++;
                lmax = ht[i];
            }
        }

        return c;
    }

    public static void main(String[] args) {
        //input work

        int n = 6;
        int[] ht = {7, 4, 8, 2, 9, 6};


        System.out.println(countBuildings(ht));
    }
}
