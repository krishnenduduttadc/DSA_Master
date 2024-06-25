package StackL1;

import java.util.Stack;

public class RemoveAdjacentDuplicate {
    public static void main(String[] args) {
        String s = "abbaca";

        System.out.println(Removeadjacentduplicate(s));
    }
    public static String Removeadjacentduplicate(String s){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }

            if(st.peek() == s.charAt(i)){
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        char[] arr = new char[st.size()];

        for(int i = arr.length - 1; i >= 0; i--){
            arr[i] = st.pop();
        }

        return String.valueOf(arr);
    }
}
