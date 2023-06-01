package Striver_tree;

public class BSTfromPre {
    public static Node bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE, new int[]{0});
    }

    public static Node bstFromPreorder(int[] A, int bound, int[] i) {
        if (i[0] == A.length || A[i[0]] > bound) return null;
        Node root = new Node(A[i[0]++]);
        root.left = bstFromPreorder(A, root.key, i);
        root.right = bstFromPreorder(A, bound, i);
        return root;
    }

    public static void main(String[] args) {
        int a[]={3,2,4};
        System.out.println(bstFromPreorder(a).key);
    }
}
