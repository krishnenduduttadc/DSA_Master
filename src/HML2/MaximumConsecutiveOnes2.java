package HML2;

public class MaximumConsecutiveOnes2 {
    public static int solution(int[] arr, int k){
        // write your code here
        int ans=0;
        int j=-1;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count++;
            }

            while(count>k){
                j++;
                if(arr[j]==0){
                    count--;
                }
            }
            int len=i-j;
            if(len>ans){
                ans=len;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 1};
        int k = 1;
        System.out.println(solution(arr,k));
    }
}


