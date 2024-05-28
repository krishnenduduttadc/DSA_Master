package LinkedListHard;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenMultilevelDoublyLinkedList {
   static  class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
    }


        public Node flatten(Node head) {
            if (head == null) return head;

            Node dummy = new Node(0);
            dummy.next = head;
            Node curr = dummy, prev = dummy;

            Deque<Node> stack = new ArrayDeque<>();
            stack.push(head);

            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                prev.next = temp;
                temp.prev = prev;
                if (temp.next != null) stack.push(temp.next);
                if (temp.child != null) {
                    stack.push(temp.child);
                    temp.child = null;
                }
                prev = temp;
            }

            dummy.next.prev = null;
            return dummy.next;
        }

        public static void main(String[] args) {
            FlattenMultilevelDoublyLinkedList solution = new FlattenMultilevelDoublyLinkedList();

            Node head = new Node(1);
            head.next = new Node(2);
            head.next.prev = head;
            head.next.next = new Node(3);
            head.next.next.prev = head.next;
            head.next.next.child = new Node(7);
            head.next.next.child.next = new Node(8);
            head.next.next.child.next.prev = head.next.next.child;
            head.next.next.child.next.child = new Node(11);
            head.next.next.child.next.child.next = new Node(12);

            Node result = solution.flatten(head);
            printList(result);
        }

        private static void printList(Node head) {
            while (head != null) {
                System.out.print(head.val + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
}
