package StatisticsL1;

import java.util.HashMap;

public class Mode {
    public static void main(String[] args) {
        int arr[]={5,4,4,3,3,2,1};
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                hm.put(arr[i],1);
            }
        }
        System.out.println(hm);
    }
}
