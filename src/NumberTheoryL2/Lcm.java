package NumberTheoryL2;

public class Lcm {

    public static void main(String[] args) {
        int a=24;
        int b=36;
        // lcm(a,b)=ab/gcd(a,b);
        int lcm=a*b/gcd(a,b);
        System.out.println(lcm);
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
