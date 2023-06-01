package Maths;

public class TrailingZeroes {
    public static void main(String[] args) {
        int n=5;
        int res=0;
        for(int i=5;i<=n;i=i*5){
            res=res+n/i;
        }
        System.out.println(res);
    }
}
