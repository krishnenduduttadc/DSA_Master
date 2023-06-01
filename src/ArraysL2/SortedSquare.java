package ArraysL2;

public class SortedSquare {
    static int[] sorted(int[] nums){
        int[] res=new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int idx=nums.length-1;

        while(i<=j){
            int val1=nums[i]*nums[i];
            int val2=nums[j]*nums[j];

            if(val1>val2){
                res[idx]=val1;
                i++;
            }else{
                res[idx]=val2;
                j--;
            }
            idx--;
        }
    return res;

    }

    public static void main(String[] args) {
        int arr[]={2,4,6,7};
        arr=sorted(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
