package RecursionAndBacktrackingL2;

public class FriendsPairing2 {
    static int counter = 1;

    public static void solution(int i, int n, boolean[] used, String asf) {
        // write your code here

        if(i>n){
            System.out.println(counter+"."+asf);
            counter++;
            return;

        }


        if(used[i]==true){
            solution(i+1,n,used,asf);
        }else{
            used[i]=true;
            solution(i+1,n,used,asf+"("+i+") ");

            for(int j=i+1;j<=n;j++){
                if(used[j]==false){
                    used[j]=true;
                    solution(i+1,n,used,asf+"("+i+","+j+") ");
                    used[j]=false;
                }
            }
            used[i]=false;

        }
    }

    public static void main(String[] args) throws Exception {
        int n = 3;
        boolean[] used = new boolean[n + 1];
        solution(1, n, used, "");
    }
}

/*
3
 */
