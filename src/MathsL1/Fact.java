package MathsL1;

public class Fact {
    public static void main(String[] args) {
        int n=10;
        int res=1;
        for (int i = 2; i <= n; i++) {
            res=res*i;
        }
        System.out.println(res);
    }
}
