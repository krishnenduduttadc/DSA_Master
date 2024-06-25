package ArraysStringsL1;

import java.util.Arrays;

public class CheckPermutations {
    public static void main(String[] args) {
        String a="god";
        String b="dog";
        System.out.println(permutation(a,b));
    }

    static boolean permutation(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }
        if(sort(a).equals(sort(b))){
            return true;
        }else{
            return false;
        }
    }

    static String sort(String s){
        char[] arr=s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
