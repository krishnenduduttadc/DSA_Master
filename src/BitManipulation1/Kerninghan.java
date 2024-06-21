package BitManipulation1;

public class Kerninghan {
    public static void main(String[] args){
        int n = 5;

        //write your code here
        int c = 0;
        while(n != 0){
            int rs = n & -n;
            n = n - rs;
            c++;
        }

        System.out.println(c);
    }
}
