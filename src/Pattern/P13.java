package Pattern;

public class P13 {
    public static void main(String[] args){

        int n = 5;

        for(int i = 0; i < n; i++){
            int v = 1;
            for(int j = 0; j <= i; j++){
                System.out.print(v+ "	");
                int z = v * (i - j) / (j + 1);
                v = z;
            }

            System.out.println();
        }



        //write your code here

    }
}
