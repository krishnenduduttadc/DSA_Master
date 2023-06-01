package ArraysL1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

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
