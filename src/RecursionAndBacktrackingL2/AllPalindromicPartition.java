package RecursionAndBacktrackingL2;

public class AllPalindromicPartition {
    public static void main(String[] args) {
        String str="abba";
        sol(str,"");
    }

    private static void sol(String str, String asf) {
        if(str.length()==0){
            System.out.println(asf);
        }
        for (int i = 0; i < str.length(); i++) {
            String prefix=str.substring(0,i+1);
            String ros=str.substring(i+1);
            if(isPalin(prefix)){
                sol(ros,asf+"("+prefix+")");
            }
        }
    }

    private static boolean isPalin(String s) {
        int li=0;
        int ri=s.length()-1;
        while(li<ri){
            char left=s.charAt(li);
            char right=s.charAt(ri);
            if(left!=right){
                return false;
            }
            li++;
            ri--;
        }
        return true;
    }
}
