package BitManipulation2;

public class SetithBit {
    static int setKthBit(int N,int K){

        return N | (1<<K);
    }

    public static void main(String[] args) {
        int n=8;
        int res=setKthBit(n,2);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(res));
    }
}
