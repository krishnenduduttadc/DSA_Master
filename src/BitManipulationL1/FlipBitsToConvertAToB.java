package BitManipulationL1;

public class FlipBitsToConvertAToB {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        int c = a ^ b;

        int z = 0;
        while(c != 0){
            int rsb = (c & -c);
            c = c - rsb;
            z++;
        }

        System.out.println(z);
    }
}
