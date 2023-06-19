package Concepts;

public class Permutations {
    public static void main(String[] args) {
        int nboxes = 4;
        int ritems = 2;
        permutations(1, nboxes, new int[ritems], 0, ritems, "");
    }
    private static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
        if(cb>tb){
            if(ssf==ts){
                System.out.println(asf);
            }
          return;
        }
        for (int i = 0; i < ts ; i++) {
            if(items[i]==0){
                items[i]=1;
                permutations(cb+1,tb,items,ssf+1,ts,asf+(i+1));
                items[i]=0;
            }
        }
        permutations(cb+1,tb,items,ssf,ts,asf+(0));
    }
}
