package BitManipulation1;

public class PrintValueOfRSBMusk {
    public static void main(String[] args) {
        int n =7;

        //write your code here
        int rsbm = n & -n;

        System.out.println(Integer.toBinaryString(rsbm));
    }
}
