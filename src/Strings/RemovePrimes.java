package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimes {
    static boolean isprime(int val){
        for(int i=2;i*i<=val;i++){
            if(val%i==0){
                return false;
            }
        }
        return true;
    }

    public static void solution(ArrayList<Integer> al){
        // write your code here
        for(int i=al.size()-1;i>=0;i--){
            int val=al.get(i);
            if(isprime(val)==true){
                al.remove(i);
            }
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }

}
/*
4
3 12 13 15
 */
