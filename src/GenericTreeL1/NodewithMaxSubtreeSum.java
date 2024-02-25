package GenericTreeL1;

import java.util.ArrayList;
import java.util.Stack;

public class NodewithMaxSubtreeSum {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    static int msn=0;
    static int ms=Integer.MIN_VALUE;

    static int retSumAndCalculateMSST(Node node){
        int sum=0;
        for(Node child:node.children){
            int csum=retSumAndCalculateMSST(child);
            sum+=csum;
        }

        sum+=node.data;
        if(sum>ms){
            msn=node.data;
            ms=sum;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {20, 10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1};

        Node root = construct(arr);
        // write your code here
        retSumAndCalculateMSST(root);
        System.out.println(msn+"@"+ms);
    }
}

/*
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
 */
