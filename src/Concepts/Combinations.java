package Concepts;

public class Combinations {
    public static void main(String[] args) {
        int nboxes = 4;
        int ritems = 2;
        comb(1,nboxes,0,ritems,"");
    }

    private static void comb(int cb, int tb, int ssf, int ts, String asf) {

        if(cb>tb){
            if(ssf==ts){
                System.out.println(asf);
            }
            return;
        }
        comb(cb+1,tb,ssf,ts,asf+"-");
        comb(cb+1,tb,ssf+1,ts,asf+"i");
    }
}
