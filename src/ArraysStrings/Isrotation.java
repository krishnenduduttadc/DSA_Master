package ArraysStrings;

public class Isrotation {
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle","erbottlewat"));
    }

    static boolean isRotation(String s1,String s2){
        int len=s1.length();
        if(len==s2.length() && len>0){
            String s1s1=s1+s1;
            return isSubstring(s1s1,s2);
        }
        return false;
    }

    static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
