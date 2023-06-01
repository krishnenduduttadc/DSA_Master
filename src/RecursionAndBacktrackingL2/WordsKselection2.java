package RecursionAndBacktrackingL2;

import java.util.HashSet;

public class WordsKselection2 {
    public static void main(String[] args) {
        String str = "abcabcd";
        int k = 3;
        HashSet<Character> unique=new HashSet<>();
        String ustr="";
        for(char ch:str.toCharArray()){
            if(unique.contains(ch)==false){
                unique.add(ch);
                ustr=ustr+ch;
            }else{

            }
        }
        gen(ustr,1,k,-1,"");
    }

    private static void gen(String ustr, int cs, int ts, int lc, String asf) {
        if(cs>ts){
            System.out.println(asf);
            return;
        }
        for(int i=lc+1;i<ustr.length();i++){
            char ch=ustr.charAt(i);
            gen(ustr,cs+1,ts,i,asf+ch);
        }
    }
}
