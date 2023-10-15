package StackL2;

public class MaxSumInConfiguration {
    public static int maximise(int[]arr) {
        //write your code here
        int n = arr.length;
        int sum = 0;
        int S0 = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            S0 += arr[i]*i;
        }

        int max = S0;
        int Si = S0;

        for(int i = 0; i < n - 1; i++){
            int Slip1 = Si + sum - n * arr[n - i -1];

            if(Slip1 > max){
                max = Slip1;
            }

            Si = Slip1;
        }

        return max;
    }

    public static void main(String[]args) {

        int[]arr = {8,3,1,2};
        int ans = maximise(arr);
        System.out.println(ans);
    }
}
