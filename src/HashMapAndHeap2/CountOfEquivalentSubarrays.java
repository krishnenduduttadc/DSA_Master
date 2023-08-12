package HashMapAndHeap2;

import java.util.HashMap;
import java.util.HashSet;

public class CountOfEquivalentSubarrays {
    public static void main(String[] args) {
        int[] arr={2,5,3,5,2,4,1,3,1,4};
        HashSet<Integer> hs=new HashSet<>();
        for (int i = 0; i <arr.length ; i++) {
            hs.add(arr[i]);
        }

        int k=hs.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=-1;
        int j=-1;
        int ans=0;
        boolean f1=false;
        boolean f2=false;
        while(true) {
            while (i < arr.length - 1) {
                f1 = true;
                i++;
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                if (map.size() == k) {
                    ans += arr.length - i;
                    break;
                }
            }


            while (j < i) {
                f2 = true;
                j++;
                if (map.get(arr[j]) == 1) {
                    map.remove(arr[j]);
                } else {
                    map.put(arr[j], map.get(arr[j]) - 1);
                }

                if (map.size() == k) {
                    ans += arr.length - i;
                } else {
                    break;
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }
        System.out.println(ans);

    }
}
