/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import java.util.PriorityQueue;

/**
 *
 * @author krish
 */
public class KsortedArr {
    static void sortk(int arr[],int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<=k;i++){
            pq.add(arr[i]);
        }
        int index=0;
        for(int i=k+1;i<arr.length;i++){
            arr[index++]=pq.poll();
            pq.add(arr[i]);
        }
        while(pq.isEmpty()==false){
            arr[index++]=pq.poll();
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        sortk(new int[]{7,8,9,19,18},3);
    }
}
