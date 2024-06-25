package Strings;

public class ToggleChar {
    public static void main(String[] args) {
        String st="kriSh";

        char[] ch = st.toCharArray();
        toggle(ch);
        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        }

    }

    private static void toggle(char[]ch) {

        for(int i=0;i<ch.length;i++){
            if(ch[i] >= 65 && ch[i]<= 90){
                ch[i] = (char)(ch[i] + 32);
            }else{
                ch[i] = (char)(ch[i] - 32);
            }
        }


    }

}
