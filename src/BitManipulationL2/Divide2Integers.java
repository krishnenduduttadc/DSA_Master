package BitManipulationL2;


public class Divide2Integers {
    public int divide(int A, int B) {

        int sign = 1;
        if(A < 0){
            sign = sign * -1;
        }
        if(B < 0){
            sign = sign * -1;
        }

        long a = A;
        long b = B;
        a = Math.abs(a);
        b = Math.abs(b);

        long res = 0;

        long t = 0;
        for (int x = 31; x >= 0; x--){
            if ((t + (b << x)) <= a) {
                res += ((long)1 << x);
                t += b << x;
            }
        }

        System.out.println(res);
        if(sign < 0){
            res = -res;
        }


        if(res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)res;
        }
    }


    public static void main(String[] args) {
        Divide2Integers solution = new Divide2Integers();

        // Test cases
        int A1 = 10;
        int B1 = 3;
        int result1 = solution.divide(A1, B1);
        System.out.println("Result of " + A1 + " / " + B1 + " = " + result1); // Expected output: 3

    }
    }
