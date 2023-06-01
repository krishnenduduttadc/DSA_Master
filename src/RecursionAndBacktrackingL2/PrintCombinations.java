package RecursionAndBacktrackingL2;

public class PrintCombinations {
    public static void main(String[] args) {
        int nboxes=4;
        int ritems=2;
        combination(1,nboxes,0,ritems,"");
    }

    private static void combination(int cb,int tb,int ssf,int ts,String asf) {
        if(cb>tb){
            if(ssf==ts){
                System.out.println(asf);
            }
            return;
        }

        combination(cb+1,tb,ssf+1,ts,asf+"i");
        combination(cb+1,tb,ssf,ts,asf+"-");
    }
}
