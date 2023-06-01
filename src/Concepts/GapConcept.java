package Concepts;

public class GapConcept {
    public static void main(String[] args) {
        int[][] arr = { {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
        };

        int n=arr.length;

        for(int g=0;g<n;g++){
            for(int i=0,j=g; j<n;i++,j++){
                if(g==0){
                    arr[i][j]=1;
                }
//                if(g==1){
//                    arr[i][j]=2;
//                }
//                if(g==2){
//                    arr[i][j]=3;
//                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
