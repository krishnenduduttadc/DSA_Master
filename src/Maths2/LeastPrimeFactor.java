package Maths2;

import java.util.Arrays;

public class LeastPrimeFactor {
    public int[] leastPrimeFactor(int n)
    {
        int[] spf = new int[n+1];

        for(int i=1;i<=n;i++){
            spf[i] = i;
        }

        for(int i=2;i*i<=n;i++){
            if(spf[i] == i){
                for(int j=i*i;j<=n;j+=i){
                    spf[j] = Math.min(spf[j],i);
                }
            }
        }

        return spf;
    }

    public static void main(String[] args) {
        LeastPrimeFactor lpf = new LeastPrimeFactor();

        // Hard-coded input
        int n = 10;

        int[] result = lpf.leastPrimeFactor(n);

        // Print the result
        System.out.println("Least Prime Factors from 1 to " + n + ": " + Arrays.toString(result));
    }
}
