package Pattern;

public class P4 {
    public static void main(String[] args) {

        int n = 5;
        int sp = 0; int st = n;
        // write ur code here
        for (int i = 1; i <= n; i++){
            for(int j = 1; j <= sp; j++){
                System.out.print("	");
            }
            for(int j = 1; j <=st; j++){
                System.out.print("*	");
            }



            sp++;
            st--;
            System.out.println();
        }

    }
}
