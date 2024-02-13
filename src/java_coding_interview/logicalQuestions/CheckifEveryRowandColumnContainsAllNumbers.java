package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class CheckifEveryRowandColumnContainsAllNumbers {
    public static void main(String[] args) {
        int[] asteroids={4,9,23,4};
        int mass=5;
        System.out.println(solve(mass, asteroids));
    }

    static boolean solve(int mass, int[] asteroids){
        Arrays.sort(asteroids);
        for(int a:asteroids){
            if(a>mass){
                return false;
            }
            if(mass<100_000){
                mass+=a;
            }
        }
        return true;
    }
}
