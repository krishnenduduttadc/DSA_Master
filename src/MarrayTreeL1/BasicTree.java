package MarrayTreeL1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BasicTree {

    static TreeNode<Integer> res;

    public static void printLevelWise(TreeNode<Integer> root) {

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            TreeNode<Integer> curr = q.poll();

            if (curr == null) {

                if (q.isEmpty()) {
                    break;
                }

                System.out.println();
                q.add(null);

            } else {

                System.out.print(curr.data + " ");

                for (int i = 0; i < curr.children.size(); i++) {
                    q.add(curr.children.get(i));
                }
            }
        }
    }

    public static int noofnodes(TreeNode<Integer> root) {

        int c = 1;

        for (int i = 0; i < root.children.size(); i++) {
            c += noofnodes(root.children.get(i));
        }

        return c;
    }

    public static int sumofnodes(TreeNode<Integer> root) {

        int sum = root.data;

        for (int i = 0; i < root.children.size(); i++) {
            sum += sumofnodes(root.children.get(i));
        }

        return sum;
    }

    public static int height(TreeNode<Integer> root) {

        int h = 0;

        for (int i = 0; i < root.children.size(); i++) {
            h = Math.max(h, height(root.children.get(i)));
        }

        return h + 1;
    }

    public static int largest(TreeNode<Integer> root) {

        int ans = root.data;

        for (int i = 0; i < root.children.size(); i++) {

            int mx = largest(root.children.get(i));

            if (mx > ans) {
                ans = mx;
            }
        }

        return ans;
    }

    public static Integer nextLarger(TreeNode<Integer> root, int x) {

        res = null;

        nextLargerElementUtil(root, x);

        return res == null ? null : res.data;
    }

    static void nextLargerElementUtil(TreeNode<Integer> root, int x) {
        if (root == null) {
            return;
        }
        if (root.data > x) {
            if (res == null || res.data > root.data) {
                res = root;
            }
        }
        for (int i = 0; i < root.children.size(); i++) {
            nextLargerElementUtil(root.children.get(i), x);
        }
    }

    public static void printatK(TreeNode<Integer> root, int k) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printatK(root.children.get(i), k - 1);
        }
    }

    public static int noleafnodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        int c = 0;
        for (int i = 0; i < root.children.size(); i++) {
            c += noleafnodes(root.children.get(i));
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
            sum += root.children.get(i).data;
        }
        return sum;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> ans = root;
        int max = sumParentAndChild(root);
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = maxSumNode(root.children.get(i));
            int childSum = sumParentAndChild(child);
            if (childSum > max) {
                max = childSum;
                ans = child;
            }
        }
        return ans;
    }

    public static void printPreOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
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
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(5);
        TreeNode<Integer> node4 = new TreeNode<>(6);
        TreeNode<Integer> node5 = new TreeNode<>(7);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node2.children.add(node4);
        node4.children.add(node5);

        printLevelWise(root);

        System.out.println("\n-----------------------------------");

        System.out.println("Nodes: " + noofnodes(root));
        System.out.println("Sum: " + sumofnodes(root));
        System.out.println("Largest: " + largest(root));
        System.out.println("Height: " + height(root));

        System.out.print("Level 1: ");
        printatK(root, 1);

        System.out.println("\nLeaf nodes: " + noleafnodes(root));

        System.out.print("Preorder: ");
        printPreOrder(root);

        System.out.print("\nPostorder: ");
        printPostOrder(root);

        System.out.println("\nContains 6: " + containsX(root, 6));

        System.out.println("Max sum node: " + maxSumNode(root).data);

        System.out.println("Next larger than 3 is: " + nextLarger(root, 3));
    }

    static class TreeNode<T> {
        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }
}