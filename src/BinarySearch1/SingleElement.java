package BinarySearch1;

public class SingleElement {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,2,0};



        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length - 2]){
            return nums[nums.length-1];
        }
        int left = 2;
        int right = nums.length - 3;

        while(left <  right){
            int middle = (left+right)/2;

            if(nums[middle-1]!= nums[middle] && nums[middle]!= nums[middle+1]){
                return nums[middle];
            }

            if(nums[middle] == nums[middle - 1]){
                middle --;
            }
            if(middle % 2 == 0){
                left = middle + 2;
            }else{
                right = middle - 1;
            }
        }

        return nums[left];

    }

}
