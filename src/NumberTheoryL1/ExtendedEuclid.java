package NumberTheoryL1;

public class ExtendedEuclid {
    public static void main(String[] args) {
        int a=6;
        int b=3;
        Pair ans=euc(a,b);
        System.out.println(ans.x+" "+ans.y);
    }
    static class Pair{
        long x,y,gcd;
        public Pair(long x,long y,long gcd){
            this.x=x;
            this.y=y;
            this.gcd=gcd;
        }
    }
    static Pair euc(long a,long b){
        if(b==0){
            return new Pair(1,0,a);
        }
        Pair dash=euc(b,a%b);
        return new Pair(dash.y,dash.x-(a/b)*dash.y,dash.gcd);
    }
}
