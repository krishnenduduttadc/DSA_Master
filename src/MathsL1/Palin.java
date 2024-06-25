package MathsL1;

public class Palin {
    public static void main(String[] args) {
        int n=101;
        int temp = n;
        int rev = 0;

        while(temp!=0){
            int ld=temp%10;
            rev=rev*10+ld;
            temp=temp/10;
        }

        System.out.println(rev==n);
    }
}
