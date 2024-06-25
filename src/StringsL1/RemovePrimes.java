package StringsL1;

import java.util.ArrayList;

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
        ArrayList<Integer> al = new ArrayList<>();
        al.add(3);
        al.add(12);
        al.add(13);
        al.add(15);

        solution(al);
        System.out.println(al);
    }

}
/*
4
3 12 13 15
 */
