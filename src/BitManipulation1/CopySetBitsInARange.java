package BitManipulation1;

public class CopySetBitsInARange {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int left = 1;
        int right = 1;

        //write your code here
        int m = (1 << (right - left + 1))
                ;
        m--;
        m = (m <<(left - 1));

        m = (m & a);
        b = b | m;
        System.out.println(b);
    }
}
