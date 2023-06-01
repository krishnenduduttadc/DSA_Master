package Euclid;

public class GCD {
    public static void main(String[] args) {
        int a=20;
        int b=12;
        int p=gcd(a,b);
        System.out.println(p);
    }

    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
