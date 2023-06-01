package RecursionAndBacktrackingL2;

public class PrintPermutations {
    public static void main(String[] args) {
        int nboxes=3;
        int ritems=2;
        permute(new int[nboxes],1,ritems);
    }

    private static void permute(int[] boxes, int ci, int ti) {
        if(ci>ti){
            for (int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i]==0){
                boxes[i]=ci;
                permute(boxes,ci+1,ti);
                boxes[i]=0;
            }
        }
    }
}
