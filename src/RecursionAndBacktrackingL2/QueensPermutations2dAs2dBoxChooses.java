package RecursionAndBacktrackingL2;

public class QueensPermutations2dAs2dBoxChooses {
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        // write your code here

        if(row==tq){
            if(qpsf==tq){
                System.out.println(asf);
                System.out.println();

            }
            return;
        }

        int nr=0;
        int nc=0;
        String sep=" ";
        if(col==tq-1){
            nr=row+1;
            nc=0;
            sep="\n";
        }else{
            nr=row;
            nc=col+1;
            sep="\t";
        }

        for(int i=0;i<queens.length;i++){
            if(queens[i]==false){
                queens[i]=true;
                queensPermutations(qpsf+1,tq,nr,nc,asf+"q"+(i+1)+sep,queens);
                queens[i]=false;

            }
        }

        queensPermutations(qpsf+0,tq,nr,nc,asf+"-"+sep,queens);
    }

    public static void main(String[] args) throws Exception {
        int n = 2;
        boolean[] queens = new boolean[n];
        queensPermutations(0, n, 0, 0, "", queens);
    }
}

/*
2
 */
