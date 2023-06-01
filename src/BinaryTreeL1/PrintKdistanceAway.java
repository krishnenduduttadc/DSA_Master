package BinaryTreeL1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class PrintKdistanceAway {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void printKLevelsDown(Node node, int k, Node blocker){
        // write your code here

        if(node==null || k<0 || node==blocker){
            return;
        }
        if(k==0){
            System.out.println(node.data);
        }
        printKLevelsDown(node.left,k-1,blocker);
        printKLevelsDown(node.right,k-1,blocker);
    }


    static ArrayList<Node> ll=new ArrayList<>();
    public static boolean find(Node node, int data){

        if(node==null){
            return false;
        }

        if(node.data==data){
            ll.add(node);
            return true;
        }
        boolean l=find(node.left,data);
        if(l){
            ll.add(node);
            return true;
        }
        boolean r=find(node.right,data);
        if(r){
            ll.add(node);
            return true;
        }

        return false;
    }

    public static void printKNodesFar(Node node, int data, int k) {
        // write your code here
        ll=new ArrayList<>();
        find(node,data);
        for(int i=0;i<ll.size() && i<=k;i++){
            printKLevelsDown(ll.get(i),k-i,i==0?null:ll.get(i-1));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }
}

/*
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
37
2
 */
