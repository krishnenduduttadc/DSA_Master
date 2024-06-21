package BitManipulation1;

public class Josphus {
    public static int p(int n){
        //write your code here
        int i = 1;

        while(i * 2 <= n){
            i = i * 2;
        }

        return i;
    }

    public static int s(int n){
        int h = p(n);
        int l = n - h;
        return 2 * l + 1;
    }
    public static void main(String[] args){
        int n = 5;
        System.out.println(s(n));
    }
}
