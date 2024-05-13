package BitManipulationResearch;

public class Powerof2 {
    public static void main(String[] args) {
        int x=9;
        for (int i = 1; i <= 32; i++) {
            powerOf2(i);
        }
    }

    static void powerOf2(int x){
        if((x & (x-1))==0){
            System.out.println(x+" is Power of two");
        }else{
            System.out.println(x+ " is not Power of two");
        }
    }
}
