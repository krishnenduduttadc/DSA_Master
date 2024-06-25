package BitManipulationL2;

public class UnsetithBit {
    public static void main(String[] args) {
        int n = 7;
        int k = 2;

        if(checkbit(n,k) == true){
            int ans = n^(1<<k);
            System.out.println(ans);
        }else{
            System.out.println(n);
        }
    }
    static boolean checkbit(int n, int k){
        if((n & (1<<k)) == 0){
            return false;
        }else{
            return true;
        }
    }

}
