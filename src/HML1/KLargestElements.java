package HML1;

import java.io.IOException;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main (String[] args) throws IOException
    {
        int[] num = {44, -5, -2, 41, 12, 19, 21, -6};
        int k = 2;
        solve(8,num,k);
    }

    public static void solve(int n,int[] arr,int k){
        //Write your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            if(i<k){
                pq.add(arr[i]);
            }else{
                if(arr[i]>pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        int arrr[]=new int[pq.size()];
        int i=0;
        while(pq.size()!=0){
            arrr[i]=pq.remove();
            i++;
        }

        for(int j=arrr.length-1;j>=0;j--){
            System.out.print(arrr[j]+" ");
        }
    }
}


