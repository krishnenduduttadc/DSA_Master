package StringsL1;

public class ToggleOpticaDocument {
    public static void main(String[] args) {
        String str = "pepCODinG";
        System.out.println(toggleCase(str));
    }

    static String toggleCase(String str){
        StringBuilder sb=new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char ch=sb.charAt(i);
            if(ch>='a' && ch<='z'){
                char uch=(char)('A'+ch-'a');
                sb.setCharAt(i,uch);
            }else if(ch>='A' && ch<='Z'){
                char lch=(char)('a'+ch-'A');
                sb.setCharAt(i,lch);
            }
        }
        return sb.toString();

    }
}

/*
pepCODinG
 */
