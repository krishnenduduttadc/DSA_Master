package PatternL1;

public class P12 {
    public static void main(String[] args) {

        int n = 5;

        int a = 0; int b = 1;

        // write ur code here
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                int c = a + b;
                System.out.print(a + "	");
                a = b;
                b = c;
            }

            System.out.println();
        }

    }
}
