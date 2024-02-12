package ArraysL1;

public class Reverse {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int val: a){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int[] a){
        // write your code here
        int f=0;
        int r=a.length-1;
        while(f<r){
            int temp=a[r];
            a[r]=a[f];
            a[f]=temp;
            f++;
            r--;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 5;
        int[] a = {1, 2, 3, 4, 5};
        reverse(a);
        display(a);
    }
}

/*
5
1
2
3
4
5
 */
