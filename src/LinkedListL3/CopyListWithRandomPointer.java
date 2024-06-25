package LinkedListL3;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next;
        head.next.random = head;

        Node result = solution.copyRandomList(head);
        printList(result);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print("Node(" + head.val + ")");
            if (head.random != null) {
                System.out.print(" [Random(" + head.random.val + ")]");
            }
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
