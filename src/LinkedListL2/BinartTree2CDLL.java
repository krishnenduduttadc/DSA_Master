package LinkedListL2;

public class BinartTree2CDLL {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function to concatenate two circular doubly linked lists
    Node concatenate(Node H1, Node H2) {
        if (H1 == null) return H2;
        if (H2 == null) return H1;

        Node T1 = H1.left;
        Node T2 = H2.left;

        T1.right = H2;
        H2.left = T1;

        T2.right = H1;
        H1.left = T2;

        return H1;
    }

    // Function to convert binary tree into circular doubly linked list
    Node bTreeToClist(Node root) {
        if (root == null) return null;

        Node l = bTreeToClist(root.left);
        Node r = bTreeToClist(root.right);

        root.left = root.right = root;

        Node result = concatenate(concatenate(l, root), r);

        return result;
    }

    // Function to print the circular doubly linked list
    void printCList(Node head) {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.right;
        } while (temp != head);
        System.out.println();
    }

    // Main method to test the bTreeToClist function
    public static void main(String[] args) {
        BinartTree2CDLL solution = new BinartTree2CDLL();

        // Creating a sample binary tree:
        //     1
        //    / \
        //   2   3
        //  / \   \
        // 4   5   6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Node head = solution.bTreeToClist(root);

        System.out.println("Circular Doubly Linked List:");
        solution.printCList(head);
    }
}
