package Maths1;

public class RotateNumber {
    public static void main(String[] args) {
        // write your code here

        int n = 56789;
        int k = 2;

        int temp = n;
        int d = 0;
        while(temp > 0){
            temp = temp / 10;
            d = d + 1;
        }

        k = k % d;
        if(k < 0){
            k = k + d;
        }


        int od = n % ((int)Math.pow(10, k));
        int a = od * ((int)Math.pow(10, d - k));
        int g = n / (int)Math.pow(10, k);
        System.out.println(a + g);
    }
}
