package java_coding_interview.logicalQuestions;

import java.util.PriorityQueue;

public class PolycarpTraining {
    public static void main(String[] args) {
        int n=5;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int[] arr={1,1,1,2,2};
        for(int e:arr){
            pq.add(e);
        }
        int day=1;
        while(!pq.isEmpty()){
            int questions_can_solve=pq.poll();
            if(day>questions_can_solve){
                continue;
            }
            day++;
        }
        System.out.println(day-1);
    }
}
