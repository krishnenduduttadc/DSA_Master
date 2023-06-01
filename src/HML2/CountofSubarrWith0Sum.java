package HML2;

import java.util.HashMap;

public class CountofSubarrWith0Sum {
    public static void main(String[] args) {
        int arr[] = {3, 7, -10, 5, 2, -1, -1};
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=-1;
        int sum=0;
        int count=0;

        map.put(0,1);
        while(i<arr.length-1){
            i++;
            sum+=arr[i];

            if(map.containsKey(sum)){
                count+=map.get(sum);
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,i);
            }
        }
        System.out.println(count);
    }
}
