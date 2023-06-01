package BinaryTreeL1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SizeSumMaxHeight {
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

    public static int size(Node node) {
        // write your code here

        if(node==null){
            return 0;
        }
        else {
            return 1+size(node.left)+size(node.right);
        }
    }


    public static int sum(Node node) {
        // write your code here
        //int sum1=0;
        if(node ==null){
            return 0;
        }else{
            int lsum=sum(node.left);
            int rsum=sum(node.right);
            return node.data+lsum+rsum;
        }
    }

    public static int max(Node node) {
        // write your code here

        if(node==null){
            return Integer.MIN_VALUE;
        }
        else {
            int lmax=max(node.left);
            int rmax=max(node.right);
            return Math.max(node.data,Math.max(lmax,rmax));
        }
    }

    public static int height(Node node) {
        // write your code here
        if(node==null){
            return -1;
        }else{
            int lh=height(node.left);
            int rh=height(node.right);
            return 1+Math.max(lh,rh);
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

        Node root = construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }

}

/*
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 */
