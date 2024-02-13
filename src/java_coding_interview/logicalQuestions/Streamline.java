package java_coding_interview.logicalQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Streamline {
    public static void main(String[] args) {
        int n=2;
        int m=5;
        int[] arr={10,12,1,2,14};
        Arrays.sort(arr);
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for (int i = 1; i < m; i++) {
            q.add(arr[i]-arr[i-1]);
        }
        long answer=0;
        int end=Math.max(m-n,0);
        for (int i = 0; i < end; i++) {
            answer+=q.poll();
        }
        System.out.println(answer);
    }
}
