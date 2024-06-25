package LinkedListL2;


import java.util.HashMap;
import java.util.Map;

public class CloneaLinkedListwithRandomPointer {
    static class Node {
        int val;
        Node next, random;
        Node(int x) {
            val = x;
            next = random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        // First pass: create new nodes and map original nodes to new nodes
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: assign next and random pointers for new nodes
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        // Create a linked list with random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;

        // Call the function to clone the linked list
        CloneaLinkedListwithRandomPointer solution = new CloneaLinkedListwithRandomPointer();
        Node clonedHead = solution.copyRandomList(head);

        // Print the cloned linked list with random pointers
        System.out.println("Original List:");
        printListWithRandom(head);
        System.out.println("\nCloned List:");
        printListWithRandom(clonedHead);
    }

    // Helper method to print the linked list with random pointers
    private static void printListWithRandom(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + "(" + (curr.random != null ? curr.random.val : "null") + ") ");
            curr = curr.next;
        }
        System.out.println();
    }
}
