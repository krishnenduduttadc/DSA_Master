package BitManipulation1;

public class AllRepeatingExceptOne {
    public static void main(String[] args) {
        int[] arr = {2,3,4,2,3,4,7};

        //write your code here
        int uni = 0;
        for(int val : arr){
            uni = uni ^ val;
        }

        System.out.println(uni);
    }
}
