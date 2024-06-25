package BitManipulationL2;

public class CheckBit {
    static boolean checkKthBit(int n, int k)
    {
        if((n & (1<<k)) == 0){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        int n=8;
        int k=3;
        System.out.println(checkKthBit(n,k));
    }
}
