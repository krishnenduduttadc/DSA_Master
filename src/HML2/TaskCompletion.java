package HML2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class TaskCompletion {
    public static void completeTask(int n, int m, int[] arr) {
        // write your code here
        HashSet<Integer> completed=new HashSet<>();
        for(int val:arr){
            completed.add(val);
        }

        boolean flag=true;
        ArrayList<Integer> one = new ArrayList<Integer>();
        ArrayList<Integer> two = new ArrayList<Integer>();

        for (int i = 1; i <=n; i++) {
            if(completed.contains(i)==false){
                if(flag){
                    one.add(i);
                }else{
                    two.add(i);
                }
                flag=!flag;
            }
        }

        for (int var : one) {
            System.out.print(var+" ");
        }
        System.out.println();
        for (int var : two) {
            System.out.print(var+" ");
        }
        System.out.println();


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = scn.nextInt();
        }
        completeTask(n, m, num);
    }

}

/*
15 6
2 5 6 7 9 4
 */
