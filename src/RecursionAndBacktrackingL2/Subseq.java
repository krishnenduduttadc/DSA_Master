package RecursionAndBacktrackingL2;

public class Subseq {
    public static void main(String[] args) {
        String s = "abc";
        sol(s, "");
    }
    private static void sol(String q, String a) {
        if(q.length()==0){
            System.out.println(a+"-");
            return;
        }

        char ch=q.charAt(0);
        String rest=q.substring(1);
        sol(rest,a);
        sol(rest,a+ch);
    }
}
