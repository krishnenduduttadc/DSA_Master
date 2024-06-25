package PatternL1;

public class P6 {
    public static void main(String[] args) {


        int n = 5;

        int sp = 1; int str = n / 2 + 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= str; j++){
                System.out.print("*	");
            }
            for(int j = 1; j <= sp; j++){
                System.out.print("	");
            }

            {
                for(int j = 1; j <= str; j++){
                    System.out.print("*	");
                }

                if(i <= n /2 ){
                    str--;
                    sp += 2;

                } else {
                    str++ ;
                    sp-= 2;

                }

                System.out.println();
            }

            // write ur code here

        }
    }
}
