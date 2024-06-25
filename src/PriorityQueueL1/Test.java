/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueueL1;

/**
 *
 * @author krish
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Priority_Queue p=new Priority_Queue();
        int arr[]={5,1,9,2,0};
        for (int i = 0; i < arr.length; i++) {
            p.insert(arr[i]);
        }
        
        while(!p.isEmpty()){
            System.out.print(p.removeMin()+" ");
        }
    }
}
