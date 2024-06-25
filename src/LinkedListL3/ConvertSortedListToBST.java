package LinkedListL3;

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(Node head) {
        if (head == null) return null;
        return convertToBST(head, null);
    }

    private TreeNode convertToBST(Node head, Node tail) {
        if (head == tail) return null;
        Node slow = head;
        Node fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = convertToBST(head, slow);
        root.right = convertToBST(slow.next, tail);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedListToBST solution = new ConvertSortedListToBST();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        TreeNode result = solution.sortedListToBST(head);
        printTree(result);
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }
}
