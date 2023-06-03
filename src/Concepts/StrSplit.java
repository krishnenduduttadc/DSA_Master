package Concepts;

public class StrSplit {
    public static void main(String[] args) {
        String str = "arpita";
        for (int i = 0; i < str.length(); i++) {
            String pre=str.substring(0,i+1);
            String post=str.substring(i+1);
            System.out.println(pre+" "+post);
        }
    }
}
