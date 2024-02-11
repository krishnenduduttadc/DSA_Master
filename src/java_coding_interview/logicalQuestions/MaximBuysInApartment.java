package java_coding_interview.logicalQuestions;

public class MaximBuysInApartment {
    public static void main(String[] args) {
        long n=6;
        long k=3;
        long min=Math.min(1,k);
        if(k==n){
            min=0;
        }
        long max=Math.min(n-k,2*k);
        System.out.println(min+" "+max);

    }
}
