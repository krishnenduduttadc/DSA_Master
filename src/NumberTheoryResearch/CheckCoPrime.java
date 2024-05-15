package NumberTheoryResearch;

public class CheckCoPrime {
    public static void main(String[] args) {
        int a=7;
        int b=12;
        //System.out.println(gcd(a,b));
        if(gcd(a,b)==1){
            System.out.println("a,b are coprime");
        }else{
            System.out.println("a,b are not coprime");
        }
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
