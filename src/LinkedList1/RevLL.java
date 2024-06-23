/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList1;

/**
 *
 * @author krish
 */
public class RevLL {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            next = null;
            data = d;
        }
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node smallAns = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return smallAns;
    }

    static Node reverseI(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        display(one);
        System.out.println("\n********************************************");
        Node rev = reverseI(one);
        display(rev);
    }
}
