package BitManipulation2;


public class SumOfXOR {
    public long sumXOR (int arr[], int n) {
        //Complete the function
        long ans=0;
        for(int i=31;i>=0;i--){

            long ZeroCnt=0;
            long OneCnt=0;
            for(long j:arr){
                if((j&(1<<i))!=0){
                    OneCnt+=1;
                }
                else{
                    ZeroCnt+=1;
                }
            }

            ans+=(((long)(1<<i))*(OneCnt*ZeroCnt));
        }

        return ans;
    }


    public static void main(String[] args) {
        SumOfXOR solution = new SumOfXOR();

        // Test case 1
        int[] arr1 = {1, 3, 5};
        int n1 = arr1.length;
        long result1 = solution.sumXOR(arr1, n1);
        System.out.println("Sum of XOR for arr1: " + result1); // Expected output: 12
    }
    }
