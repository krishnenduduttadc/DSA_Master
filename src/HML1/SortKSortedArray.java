package HML1;

import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) throws Exception {
        int[] arr = {3, 2, 4, 1, 6, 5, 7, 9, 8};
        int k = 3;
        // write your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<=k;i++){
            pq.add(arr[i]);
        }

        for(int i=k+1;i<arr.length;i++){
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }

}


