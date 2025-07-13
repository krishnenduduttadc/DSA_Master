package QueueL1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinary {


    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N) {
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while (N-- > 0) {
            String rem = q.remove();
            ans.add(rem);
            q.add(rem + "0");
            q.add(rem + "1");
        }
        return ans;
    }


    public static void main(String[] args) {
        int N = 5;
        ArrayList<String> binaryNumbers = generate(N);
        for (String num : binaryNumbers) {
            System.out.println(num);
        }
    }
}
