package HML2;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementsinWindowK {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,4,5,3,2,9};
        int k=4;
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <k-1 ; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for (int i = k-1,j=0; i < arr.length; ) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1); //acquire
            //work
            list.add(map.size());
            //release
            int freq=map.get(arr[j]);
            if(freq==1){
                map.remove(arr[j]);
            }else{
                map.put(arr[j],freq-1);
            }
            i++;
            j++;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
