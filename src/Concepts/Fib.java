package Concepts;

public class Fib {
    public static void main(String[] args) {
        int n=7;
        int p = fib(n, new int[n + 1]);
        System.out.println(p+"");
    }

    private static int fib(int n, int[] qb) {
        if(n==0||n==1){
            return n;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        int fib1=fib(n-1,qb);
        int fib2=fib(n-2,qb);
        int fibn=fib1+fib2;
        qb[n]=fibn;
        return fibn;
    }
}
