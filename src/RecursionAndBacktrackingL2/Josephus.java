package RecursionAndBacktrackingL2;

public class Josephus {
    public static int solution(int n, int k){
        //write your code here
        if(n==1){
            return 0;
        }
        int x=solution(n-1,k);
        int y=(x+k)%n;
        return y;
    }
    public static void main(String[] args){
        int n = 4;
        int k = 2;
        System.out.println(solution(n,k));
    }
}

/*
4
2
 */
