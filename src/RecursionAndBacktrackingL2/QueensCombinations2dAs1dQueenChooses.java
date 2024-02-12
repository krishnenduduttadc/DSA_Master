package RecursionAndBacktrackingL2;

public class QueensCombinations2dAs1dQueenChooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here

        if(qpsf==tq){
            for( int row=0 ; row<chess.length ; row++ ) {
                for(int col=0;col<chess.length;col++){
                    if(chess[row][col]==true){
                        System.out.print("q\t");
                    }else{
                        System.out.print("-\t");
                    }
                }System.out.println();
            }System.out.println();

        }
        for( int cell=lcno+1 ; cell<chess.length*chess.length ;  cell++) {
            int row=cell/chess.length;
            int col=cell%chess.length;
            chess[row][col]=true;
            queensCombinations(qpsf+1,tq,chess,cell);
            chess[row][col]=false;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 2;
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
/*
2
 */
