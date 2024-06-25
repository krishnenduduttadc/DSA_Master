package BitManipulationL1;

public class XorOfSumOfAllPairs {
    public static int solution(int[] arr){
        int ans = 0;

        for(int val : arr){
            ans = ans ^ (2 * val);
        }

        return ans;    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(solution(arr));
    }

}
