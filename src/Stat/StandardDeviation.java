package Stat;

import java.util.ArrayList;

public class StandardDeviation {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            al.add(i);
        }

        double m=mean(al);
        System.out.println(m);
        double mysd=Math.sqrt(variance(al,m));
        System.out.println(mysd);
    }
    static double mean(ArrayList<Integer> al){
        int n=al.size();
        int sum=0;
        for (int i = 0; i < al.size(); i++) {
            sum+=al.get(i);
        }
        double res=sum/n;
        return res;
    }
    static double variance(ArrayList<Integer> al, double m){
        double res=0;
        for (int i = 0; i < al.size(); i++) {
            res+=Math.pow(al.get(i)-m,2);
        }
        return res/al.size();
    }
}
