package java_coding_interview.logicalQuestions;

public class VisitingaFriend {
    public static void main(String[] args) {
        solve();
    }
    static void solve(){
        int n=3;
        int m=8;
        int[][] arr={{0,2},{2,4},{4,6}};
        int x=0;
        for (int i = 0; i <n ; i++) {
            if(arr[i][0]<=x){
                x=Math.max(x,arr[i][1]);
            }
        }

        if(x>=m){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
