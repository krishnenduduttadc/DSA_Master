package BitManipulationL2;

public class CountingBits {
    static int setBits(int N) {
        int ans = 0;

        for(int i=0;i<32;i++){
            if(checkbit(N,i) == true){
                ans++;
            }
        }

        return ans;
    }

    static boolean checkbit(int n, int k){
        if((n & (1<<k)) == 0){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(setBits(7));
    }

}
