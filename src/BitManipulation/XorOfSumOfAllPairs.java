package BitManipulation;

public class XorOfSumOfAllPairs {
    public static int solution(int[] arr){
        int ans = 0;

        for(int val : arr){
            ans = ans ^ (2 * val);
        }

        return ans;    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        System.out.println(solution(arr));
    }

}
