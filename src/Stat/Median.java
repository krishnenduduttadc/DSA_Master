package Stat;

import java.util.ArrayList;

public class Median {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            al.add(i);
        }
        System.out.println(al);
        System.out.println(median(al));
    }
    static int median(ArrayList<Integer> al){
        int n=al.size();
        if(al.size()%2==0){
            return (al.get(n / 2 - 1) + al.get(n / 2)) / 2;
        }else{
            return al.get((n + 1) / 2 - 1);
        }

    }
}
