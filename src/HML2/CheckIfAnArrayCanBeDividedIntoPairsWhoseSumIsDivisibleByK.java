package HML2;

import java.util.HashMap;

public class CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {
    public static void solution(int[] arr, int k){
        //write your code here

        HashMap<Integer,Integer> rfmap=new HashMap<>();

        for(int val:arr){
            int rem=val%k;
            int of=rfmap.getOrDefault(rem,0);
            rfmap.put(rem,of+1);
        }

        for(int val:arr){
            int rem=val%k;
            if(rem==0){
                int fq=rfmap.get(rem);
                if(fq%2==1){
                    System.out.println(false);
                    return;
                }
            }
            else if(2*rem==k){
                int fq=rfmap.get(rem);
                if(fq%2==1){
                    System.out.println(false);
                    return;
                }
            }else{
                int fq=rfmap.get(rem);
                int ofq=rfmap.getOrDefault(k-rem,0);
                if(fq!=ofq){
                    System.out.println(false);
                    return;
                }

            }
        }
        System.out.println(true);
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 3};
        int k = 6;
        solution(arr,k);
    }
}

/*
4

6
 */
