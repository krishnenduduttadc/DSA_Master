package HML1;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
    public static void main (String[] args) throws IOException
    {
        Scanner scn= new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solve(n,num,k);
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array,n length of array and k.
    // It should print required output.
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

/*
8
44 -5 -2 41 12 19 21 -6
2
 */
