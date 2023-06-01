package Maths;

public class GCD {
    public static void main(String[] args) {
        int a=8;
        int b=4;
        int r=gcd(a,b);
        System.out.println(r);
    }

    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
