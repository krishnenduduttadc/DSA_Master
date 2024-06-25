package StringsL1;

public class StringWithDifferenceOfEveryTwoConsecutiveCharacters {
    public static String solution(String str){
        // write your code here
        StringBuilder sb=new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char curr=str.charAt(i);
            char prev=str.charAt(i-1);
            int gap=curr-prev;

            sb.append(gap);
            sb.append(curr);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "pepCODinG";
        System.out.println(solution(str));
    }
}

/*
pepCODinG
 */
