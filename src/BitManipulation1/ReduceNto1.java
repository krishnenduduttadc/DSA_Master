package BitManipulation1;

public class ReduceNto1 {
    public static int solution(long n) {
        //write your code here
        int res = 0;

        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
            } else if(n == 3){
                res = 2;
                break;
            } else if((n & 3) == 1){
                n = n - 1;
            } else if((n & 3) == 3){
                n = n + 1;
            }

            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(solution(n));
    }
}
