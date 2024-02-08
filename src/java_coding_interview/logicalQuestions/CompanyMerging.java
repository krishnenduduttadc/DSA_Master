package java_coding_interview.logicalQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyMerging {
    public static void main(String[] args) {
        int n=3;
        int[][] input={{2,4,3},{2,2,1},{3,1,1,1}};
        List<List<Integer>> ml=new ArrayList<>(n);
        int max=0;
        for (int i = 0; i < n; i++) {
            int[] inp=input[i];
            int m=inp[0];
            List<Integer> tmp=new ArrayList<>(m);
            for (int j = 1; j <=m ; j++) {
                int s=inp[j];
                tmp.add(s);
                max=Math.max(max,s);
            }
            Collections.sort(tmp);;
            ml.add(tmp);
        }

        long ans=0;
        for(List<Integer> e:ml){
            int maxs=e.get(e.size()-1);
            ans+=(long)(max-maxs)*e.size();
        }
        System.out.println(ans);

    }
}
