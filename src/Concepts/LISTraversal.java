package Concepts;

public class LISTraversal {
    public static void main(String[] args) {
        int arr []={10,22,9,33,21,50,41,60,80,1};
        int n=arr.length;
        int dp[]=new int[n];

        for (int i = 0; i < n; i++) {
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(arr[j]>max){
                        max=dp[j];
                        System.out.print(arr[j]+" ");
                    }

                }


            }
            dp[i]=max+1;
            //System.out.print(dp[i]+" ");
            System.out.println();

        }
    }
}
