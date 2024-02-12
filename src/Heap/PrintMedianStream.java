/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author krish
 */
public class PrintMedianStream {
    static void printMedian(int arr[]){
        PriorityQueue<Integer> g = new PriorityQueue<Integer>();
        PriorityQueue<Integer> s = new PriorityQueue<Integer>(Collections.reverseOrder());
        s.add(arr[0]);
        System.out.print(arr[0]+ " ");
        
        for(int i=1;i<arr.length;i++){
            int x=arr[i];
            if(s.size()>g.size()){
                if(s.peek()>x){
                    g.add(s.poll());
                    s.add(x);
                }else{
                    g.add(x);
                }
                System.out.print((double)(s.peek()+g.peek())/2+ " ");
            }
            else{
                if(x<=s.peek()){
                    s.add(x);
                }else{
                    g.add(x);
                    s.add(g.poll());
                }
                System.out.print(s.peek()+ " ");
            }
        }
    }
    public static void main(String[] args) {
        printMedian(new int[]{12,15,10,5,8,7,16});
    }
}
