package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class Ropewalkers {
    public static void main(String[] args) {
        solve();
    }
    static void solve(){
        int arr[]={2,3,10};
        Arrays.sort(arr);
        int d=4;
        int result=0;
        result+=Math.max(0,d-(arr[1]-arr[0]));
        result+=Math.max(0,d-(arr[2]-arr[1]));
        System.out.println(result);
    }
}
