package java_coding_interview.logicalQuestions;

import java.util.*;

public class FiveEverywhere {
    public static void main(String[] args) {
        int n=5;
        Set<Integer> set=new HashSet<>();
        for (int i = 1; i <11110 ; i++) {
            int a=i*5+1;
            if(isPrimeNumber(a)){
                set.add(a);
            }
        }

        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }

        System.out.println(sb.toString());

    }


    public static boolean isPrimeNumber(int n) {
        // Corner cases
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // This will loop from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // If n is divisible by any number between 2 and sqrt(n), it is not prime
            if (n % i == 0) {
                return false;
            }
        }
        // If no divisors are found, n is prime
        return true;
    }
}
