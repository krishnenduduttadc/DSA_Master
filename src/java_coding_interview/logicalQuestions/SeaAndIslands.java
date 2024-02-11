package java_coding_interview.logicalQuestions;

public class SeaAndIslands {
    public static void main(String[] args) {

        int n = 5;
        int k = 10;
        char[][] a = new char[n][n];

        //greedily create number of islands that is given in "k"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = i + j;
                if (k > 0 && sum % 2 == 0) {
                    a[i][j] = 'L';
                    k--;
                } else {
                    a[i][j] = 'S';
                }
            }
        }

        //if we can not create number of islands that is given in "k",
        //then print NO
        if (k > 0) {
            System.out.println("NO");
        } else {

            //print the grid after island creation
            System.out.println("YES");
            for (char[] c : a) {
                System.out.print(new String(c));
                System.out.println();
            }
        }

    }
}
