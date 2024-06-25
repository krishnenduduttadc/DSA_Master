package BitManipulationL3;

public class MyBitCheck {
    public static void main(String[] args) {
        int x=22; //10110
        for (int k = 0; k <=4 ; k++) {
            bitChecker(x,k);
        }
    }

    static void bitChecker(int x,int k){
        if ((x & (1 << k)) != 0) {
            System.out.println(k+" th bit is 1");
        }else{
            System.out.println(k+" th bit is 0");
        }
    }
}
