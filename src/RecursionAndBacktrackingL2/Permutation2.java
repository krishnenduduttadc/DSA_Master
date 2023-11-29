package RecursionAndBacktrackingL2;

public class Permutation2 {
    public static void main(String[] args) throws Exception {

        int nboxes = 3;
        int ritems = 2;
        int cb=1;
        int ssf=0;
        permutations(cb, nboxes, new int[ritems], ssf, ritems, "");
    }
    public static void permutations(int cb, int nboxes, int[] items, int ssf, int ritems, String asf){
        if(cb>nboxes){
            if(ssf==ritems){
                System.out.println(asf);
            }
            return;
        }

        for (int i = 0; i < ritems; i++) {
            if(items[i]==0){
                items[i]=1;
                permutations(cb+1,nboxes,items,ssf+1,ritems,asf+(i+1));
                items[i]=0;
            }
        }

        permutations(cb+1,nboxes,items,ssf,ritems,asf+0);
    }
}


/*
5
3
 */
