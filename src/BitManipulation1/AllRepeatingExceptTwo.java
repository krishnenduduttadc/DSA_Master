package BitManipulation1;

public class AllRepeatingExceptTwo {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,6,6,9,1};
        solution(arr);
    }

    public static void solution(int[] arr){
        //write your code here
        int xxory = 0;

        for(int val: arr) {
            xxory = xxory ^ val;
        }

        int rsbm = xxory & -xxory;

        int x = 0;
        int y = 0;


        for(int val: arr){
            if((val & rsbm) == 0){
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }

        if(x < y){
            System.out.println(x);
            System.out.println(y);
        } else {
            System.out.println(y);
            System.out.println(x);
        }
    }
}
