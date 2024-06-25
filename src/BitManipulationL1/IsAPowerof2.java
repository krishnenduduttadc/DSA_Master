package BitManipulationL1;

public class IsAPowerof2 {
    public static void main(String[] args) {
        int n = 4;
        //write your code here

        int val = (n & (n - 1));

        if(val == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
