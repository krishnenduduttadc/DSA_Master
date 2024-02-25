package GenericTreeL1;

import java.util.ArrayList;
import java.util.Stack;

public class Diameter {
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


    static int dia=0;
    static int calculateDiaReturnHeight(Node node){
        int dch=-1;
        int sdch=-1;
        for(Node child:node.children){
            int ch=calculateDiaReturnHeight(child);
            if(ch>dch){
                sdch=dch;
                dch=ch;
            }else if(ch>sdch){
                sdch=ch;
            }

        }

        if(dch+sdch+2>dia){
            dia=dch+sdch+2;
        }

        dch+=1;
        return dch;
    }


    public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1};

        Node root = construct(arr);
        // write your code here

        calculateDiaReturnHeight(root);
        System.out.println(dia);
    }

}

/*
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
 */
