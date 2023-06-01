package HML2;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int arr[]={3,7,-10,5,2,-1,-1};
        int mlen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=-1;
        int sum=0;
        map.put(sum,i);
        while(i<arr.length-1){
            i++;
            sum=sum+arr[i];

            if(map.containsKey(sum)==false){
                map.put(sum,i);
            }else{
                int len=i-map.get(sum);
                if(len>mlen){
                    mlen=len;
                }
            }
        }
        System.out.println(mlen);
    }
}
