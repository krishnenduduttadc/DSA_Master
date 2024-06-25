package StatisticsL1;

import java.util.ArrayList;

public class Mean {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            al.add(i);
        }
        //System.out.println(al);
        System.out.println(mean(al));
    }
    static int mean(ArrayList<Integer> al){
        int n=al.size();
        int sum=0;
        for (int i = 0; i < al.size(); i++) {
            sum+=al.get(i);
        }
        int res=sum/n;
        return res;
    }
}
