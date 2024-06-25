package MathsL2;

public class PowerofNumbermod_m {
    public static void main(String[] args) {

        int a = 10;
        int n = 5;

        long ans = 1;
        int m = 1000000007;

        for(int i=1;i<=n;i++){
            ans = ((ans%m) * (a%m)) % m;
        }

        System.out.println(ans);
    }

}
