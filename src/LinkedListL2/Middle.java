package LinkedListL2;

import java.util.Scanner;

public class Middle {
    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node midNode(Node head) {
        if(head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            prev.next = new Node(scn.nextInt());
            prev = prev.next;
        }

        Node head = midNode(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
