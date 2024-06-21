package BitManipulation1;

public class SwapAllOddAndEvenBits {
    public static void main(String[] args){

        int n = 15;
        //write your code here

        int om = 0x55555555;
        int em = 0xAAAAAAAA;

        int odds = (n & om);
        int evens = (n & em);

        odds <<= 1;
        evens >>= 1;

        n = odds | evens;
        System.out.println(n);
    }
}
