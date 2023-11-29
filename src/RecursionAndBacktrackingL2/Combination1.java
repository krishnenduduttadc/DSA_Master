package RecursionAndBacktrackingL2;

public class Combination1 {
    public static void main(String[] args) throws Exception {
        int nboxes = 3;
        int ritems = 2;
        combinations(1, nboxes, 0, ritems, "");
    }

    public static void combinations(int cb, int nboxes, int ssf, int ritems, String asf) {
        if (cb > nboxes) {
            if(ssf==ritems){
                System.out.println(asf);
            }
            return;
        }
        combinations(cb+1,nboxes,ssf+1,ritems,asf+"i");
        combinations(cb+1,nboxes,ssf,ritems,asf+"-");

    }
}

/*
5
3
 */
