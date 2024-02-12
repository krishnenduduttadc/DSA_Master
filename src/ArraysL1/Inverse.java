package ArraysL1;

public class Inverse {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static int[] inverse(int[] a){
        // write your code here
        int b[]=new int[a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if(a[i]==j){
                    b[j]=i;
                }
            }
        }
        return b;
    }

    public static void main(String[] args) throws Exception {

        int n = 5;
        int[] a = {4, 0, 2, 3, 1};
        int[] inv = inverse(a);
        display(inv);
    }
}

/*
5
4
0
2
3
1
 */
