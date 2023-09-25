package HML2;

import java.util.HashMap;

public class SmallestSubarrayWithHighestFrequencyElement {
    public static void main(String[] args) {
        int arr[]={1,3,2,4,2,3,4,2,5,6,5,5,7};
        solution(arr);
    }

    static void solution(int[] arr){
        HashMap<Integer,Integer> fmap=new HashMap<>();
        HashMap<Integer,Integer> smap=new HashMap<>();
        int si=0;
        int ei=0;
        int len=ei-si+1;
        int hfreq=0;
        for (int i = 0; i <arr.length ; i++) {
            if(fmap.containsKey(arr[i])){
                fmap.put(arr[i],fmap.get(arr[i])+1);
            }else{
                fmap.put(arr[i],1);
                smap.put(arr[i],1);
            }

            if(fmap.get(arr[i])>hfreq){
                hfreq=fmap.get(arr[i]);
                si=smap.get(arr[i]);
                ei=i;
                len=ei-si+1;

            }else if(fmap.get(arr[i])==hfreq){
                int clen=i-smap.get(arr[i])+1;
                if(clen<len){
                    hfreq=fmap.get(arr[i]);
                    si=smap.get(arr[i]);
                    ei=i;
                    len=ei-si+1;
                }
            }
        }
        System.out.println(arr[si]);
        System.out.println(si);
        System.out.println(ei);

    }
}
