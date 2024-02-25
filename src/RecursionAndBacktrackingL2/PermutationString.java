package RecursionAndBacktrackingL2;

import java.util.HashMap;

public class PermutationString {
    public static void main(String[] args) {
        String str="abc";
        HashMap<Character,Integer> fmap=new HashMap<>();
        for(char ch:str.toCharArray()){
            if(fmap.containsKey(ch)){
                fmap.put(ch,fmap.get(ch)+1);
            }else{
                fmap.put(ch,1);
            }
        }
        generate(1,str.length(),fmap,"");
    }

    private static void generate(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
        if(cs>ts){
            System.out.println(asf);
            return;
        }

        for(char ch:fmap.keySet()){
            if(fmap.get(ch)>0){
                fmap.put(ch,fmap.get(ch)-1);
                generate(cs+1,ts,fmap,asf+ch);
                fmap.put(ch,fmap.get(ch)+1);
            }
        }
    }
}
