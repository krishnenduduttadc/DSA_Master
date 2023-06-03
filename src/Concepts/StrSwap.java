package Concepts;

public class StrSwap {
    public static void main(String[] args) {
        String str = "1234567";
        System.out.println("" + str);
        String res = swap(str, 1, 4); //1534267
        System.out.println("" + res);
    }
    static String swap(String str, int i, int j) {
        char s=str.charAt(i);
        char e=str.charAt(j);

        String pre=str.substring(0,i);
        String mid=str.substring(i+1,j);
        String post=str.substring(j+1);

        return pre+e+mid+s+post;
    }
}
