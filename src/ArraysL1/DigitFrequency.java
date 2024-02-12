package ArraysL1;

public class DigitFrequency {
    public static void main(String[] args) {
        int n = 994543234;
        int d = 4;
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int d) {
        // write code here
        int cnt=0;
        while(n>0){
            if(n%10==d){
                cnt++;
            }
            n=n/10;
        }
        return cnt;

    }
}

/*
994543234
 4
 */