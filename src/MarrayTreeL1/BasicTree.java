/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarrayTreeL1;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author krish
 */
public class BasicTree {

    public static void printLevelWise(TreeNode<Integer> root) {

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode<Integer> curr = q.poll();;
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
                System.out.println("");
                q.add(null);
            } else {
                System.out.print(" " + curr.data);
                //System.out.print(curr.data + ":L:" + curr.left.data + ",R:" + curr.right.data);
                for (int i = 0; i < curr.children.size(); i++) {
                    q.add(curr.children.get(i));
                }

            }
        }
    }

    public static int noofnodes(TreeNode<Integer> root) {
        int c = 1;
        for (int i = 0; i < root.children.size(); i++) {
            c = c + noofnodes(root.children.get(i));
        }
        return c;
    }

    public static int sumofnodes(TreeNode<Integer> root) {
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum = sum + sumofnodes(root.children.get(i));
        }
        return sum;
    }

    public static int height(TreeNode<Integer> root) {
        int h = 0;
        for (int i = 0; i < root.children.size(); i++) {
            h = Math.max(h, height(root.children.get(i)));
        }
        return 1 + h;
    }

    public static int largest(TreeNode<Integer> root) {
        int ans = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int largest = largest(root.children.get(i));
            if (largest > ans) {
                ans = largest;
            }
        }
        return ans;
    }

    static TreeNode<Integer> res;

    public static int nextLarger(TreeNode<Integer> root, int x) {
        res = null;
        // calling helper function
        nextLargerElementUtil(root, x);
        return res.data;
    }

    static void nextLargerElementUtil(TreeNode<Integer> root, int x) {
        if (root == null) {
            return;
        }
        if (root.data > x) {
            if ((res == null || (res).data > root.data)) {
                res = root;
            }
        }
        int numChildren = root.children.size();
        for (int i = 0; i < numChildren; i++) {
            nextLargerElementUtil(root.children.get(i), x);
        }

        return;
    }

    public static void printatK(TreeNode<Integer> root, int k) {
        if (k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(" " + root.data);
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printatK(root.children.get(i), k - 1);
        }
    }

    public static int noleafnodes(TreeNode<Integer> root) {
        int c = 0;
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        for (int i = 0; i < root.children.size(); i++) {
            c = c + noleafnodes(root.children.get(i));
        }

        return c;
    }

    public static boolean containsX(TreeNode<Integer> root, int x) {

        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        for (int i = 0; i < root.children.size(); i++) {
            if (containsX(root.children.get(i), x)) {
                return true;
            }
        }
        return false;
    }

    public static int sumParentAndChild(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum = sum + root.children.get(i).data;
        }
        return sum;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        int max = 0;
        int sumRoot = sumParentAndChild(root);
        TreeNode<Integer> maxNode = null;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> maxNode1 = maxSumNode(root.children.get(i));
            int sum = sumParentAndChild(maxNode1);
            if (max < sum) {
                max = sum;
                maxNode = maxNode1;
            }
        }
        if (sumRoot > max) {
            return root;
        }
        return maxNode;
    }

    public static void printPreOrder(TreeNode<Integer> root) {
        System.out.print(" " + root.data);
        for (int i = 0; i < root.children.size(); i++) {
            printPreOrder(root.children.get(i));
        }
    }

    public static void printPostOrder(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.print(" " + root.data);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(4);
        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
        TreeNode<Integer> node3 = new TreeNode<Integer>(5);
        TreeNode<Integer> node4 = new TreeNode<Integer>(6);
        TreeNode<Integer> node5 = new TreeNode<Integer>(7);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node2.children.add(node4);
        node4.children.add(node5);
        printLevelWise(root);

        System.out.println("\n-----------------------------------");
        System.out.println(noofnodes(root));
        System.out.println(sumofnodes(root));
        System.out.println(largest(root));
        System.out.println(height(root));
        printatK(root, 1);
        System.out.println("\nNo of leaf nodes" + noleafnodes(root));
        printPreOrder(root);
        System.out.println();
        printPostOrder(root);
        System.out.println("\nContains 6: " + containsX(root, 6));
        System.out.println("\nroot and child sum: " + maxSumNode(root));

        System.out.println("Next larger than 3 is " + nextLarger(root, 3));
    }
}
