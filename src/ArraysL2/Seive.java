package ArraysL2;

import java.util.Arrays;

public class Seive {
    static void seive(int n){
        boolean[] isprime=new boolean[n+1];
        Arrays.fill(isprime,true);
        for (int i = 2; i*i <= isprime.length ; i++) {
            if(isprime[i]==true){
                for(int j=i+i;j< isprime.length;j+=i){
                    isprime[j]=false;
                }
            }
        }

        for (int i = 2; i < isprime.length ; i++) {
            if(isprime[i]==true){
                System.out.println(i+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        seive(50);
    }
}
