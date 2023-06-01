package HML2;

import java.util.HashMap;
import java.util.Scanner;

public class RabbitsInTheForest {
    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int ans=0;
        for(int key:map.keySet()){
            int gs=key+1;
            int reportees=map.get(key);
            int ng=(int)Math.ceil(reportees*1.0/gs*1.0);
            ans+=ng*gs;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
/*
5
1 0 1 0 0
 */
