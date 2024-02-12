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
public class Operations {
    
    static int search(int arr[],int x){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;  
    }
    
    static int insert(int arr[],int n,int x, int cap,int pos){
        if(n==cap)return n;
        int idx=pos-1;
        for(int i=n-1;i>=idx;i--){
            arr[i+1]=arr[i];
        }
        arr[idx]=x;
        return n+1;
        
    }
    static int delete(int arr[],int n,int x){
        int i;
        for(i=0;i<n;i++){
            if(arr[i]==x)
                break;
            
        }
        
        if(i==n)return n;
        for(int j=i;j<n-1;j++){
            arr[j]=arr[j+1];
        }
        return (n-1);
    }
    
    public static void main(String a[]) {
        System.out.println(search(new int[]{5,7,6,4,3},4));
        
        //System.out.println(insert(new int[]{5,7,6,4,3},5,20,6,3));
        System.out.println(delete(new int[]{5,7,6,4,3},5,7));
    }
}
