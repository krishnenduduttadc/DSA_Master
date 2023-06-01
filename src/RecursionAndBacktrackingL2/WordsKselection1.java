package RecursionAndBacktrackingL2;

import java.util.HashSet;

public class WordsKselection1 {
    public static void main(String[] args) {
        String str="abcabcdef";
        int k=3;
        HashSet<Character> unique=new HashSet<>();
        String ustr="";
        for(char ch:str.toCharArray()){
            if(unique.contains(ch)==false){
                unique.add(ch);
                ustr=ustr+ch;
            }else{

            }
        }
        gen(0,ustr,0,k,"");
    }

    private static void gen(int i, String ustr, int ssf, int ts, String asf) {
        if(i==ustr.length()){
            if(ssf==ts){
                System.out.println(asf);
            }
            return;
        }

        char ch=ustr.charAt(i);
        gen(i+1,ustr,ssf+1,ts,asf+ch);
        gen(i+1,ustr,ssf+0,ts,asf+"");


    }
}
