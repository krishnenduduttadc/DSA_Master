package Queue1;

import java.util.LinkedList;
import java.util.Queue;

public class Kthnumber {
    public static void main(String[] args) {
        // Hardcoded value for k
        int k = 5;
        System.out.println(kth(k));
    }

    public static String kth(int k){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");

        String ans = "";
        for(int i = 0; i < k; i++){
            String temp = q.remove();
            ans = temp;
            q.add(temp + "1");
            q.add(temp + "2");
        }

        return ans;
    }
}
