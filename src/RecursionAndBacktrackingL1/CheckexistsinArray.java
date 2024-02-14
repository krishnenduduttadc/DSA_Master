/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 *
 * @author krish
 */
public class CheckexistsinArray {

    public static void main(String[] args) {
        int arr[]={1, 11, 3, 11, 11,11};
        System.out.println(""+array11(arr,0));
    }

    public static int array11(int[] nums, int index) {
        //int small=0;
        if (index >= nums.length) {
            return 0;
        }
        if(nums.length==0){
            return 0;
        }
        int small = array11(nums, index+1);
        if (nums[index] == 11) {
            return 1+small;
        }else{
            return small;
        }

        
       
    }

}
