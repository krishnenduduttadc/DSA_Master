package HML2;

import java.util.HashMap;
import java.util.Scanner;

public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        // write your code here
        String[] words=str.split(" ");
        HashMap<Character,String> map=new HashMap<>();
        HashMap<String,Boolean> used=new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(map.containsKey(ch)==false){
                if(used.containsKey(words[i])==true){
                    return false;
                }else{
                    used.put(words[i],true);
                    map.put(ch,words[i]);
                }
            }else{
                String mwith=map.get(ch);
                if(mwith.equals(words[i])==false){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        String words = scn.nextLine();
        System.out.println(wordPattern(pattern,words));
    }
}

/*
abab
pep coding pep coding
 */
