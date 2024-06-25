package BinaryTreeL3;

import java.util.HashMap;
import java.util.Map;

public class BinTreePreandIn {

    static Node buildTree(int[] preorder, int[] inorder) {
        Map< Integer, Integer > inMap = new HashMap< Integer, Integer >();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        Node root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    static Node buildTree(int[] preorder, int preStart, int preEnd, int[]
            inorder, int inStart, int inEnd, Map < Integer, Integer > inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preorder[preStart]);
        int inRoot = inMap.get(root.key);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
    public static void main(String args[]) {

        int preorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};
        Node root = buildTree(preorder, inorder);
    }
}
