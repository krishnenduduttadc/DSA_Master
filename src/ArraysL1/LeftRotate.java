/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

/**
 *
 * @author krish
 */
public class LeftRotate {
     public static void main(String a[]) {
         leftrotate(new int[]{2, 2, 3, 2, 3, 6});
         System.out.print("\n");
         leftrotateByd(new int[]{2, 2, 3, 2, 3, 6},3);
     }

    private static void leftrotate(int[] arr) {
        int temp=arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
        
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i]+" ");
         }
    }
    
     private static void leftrotateByd(int[] arr,int d) {
         int n=arr.length;
        int[] temp=new int[d];
        
      
        
        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }
        
        for(int i=d;i<n;i++){
            arr[i-d]=arr[i];
        }
        
        for(int i=0;i<d;i++){
            arr[n-d+i]=temp[i];
        }
        
        for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i]+" ");
         }
    }
}
