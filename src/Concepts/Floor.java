package Concepts;

public class Floor {
    public static void main(String[] args) {
        int n = 12;

        int i = 1;
        int ans = 1;

        while(i*i<=n){
            ans = i;
            i++;
        }

        System.out.println(ans);

    }
}
