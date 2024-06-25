package BitManipulationL3;

public class MulBy2k {
    //x<<k means multiply x by 2^k;
    public static void main(String[] args) {
        int x = 14;
        int k=3;
        int res = x << k;
        System.out.println(res);
    }
}
