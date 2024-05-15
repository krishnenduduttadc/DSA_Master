package NumberTheoryResearch;

public class Gcd {
    public static void main(String[] args) {
        int a=24;
        int b=36;
        System.out.println(gcd(a,b));
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
