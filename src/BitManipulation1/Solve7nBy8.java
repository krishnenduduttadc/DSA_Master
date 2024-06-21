package BitManipulation1;

public class Solve7nBy8 {
    public static void main(String[] args){

        int n = 14;
        //write your code here
        int v = (((n << 3) - n) >> 3);
        System.out.println(v);

    }
}
