package BitManipulationL3;

public class MyShiftApplications {

    public static void main(String[] args) {
        int x = 22; //10110
        int k = 3;
        int res1 = x | (1 << k); // set kth bit of x to 1
        System.out.println(res1); //11110

        k = 2;
        int res2 = x & ~(1 << k); // set kth bit of x to 0
        System.out.println(res2); //10010

        k = 2;
        int res3 = x ^ (1 << k); // inverts k th bit
        System.out.println(res3); //10010



    }
}
