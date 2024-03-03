/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author krish
 */
public class FindMiddle {

    static class Node {

        int data;
        Node next;
    };
    static int n;
    static Node mid;

    static Node newLNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    static Node midpoint(Node head) {
        mid = null;
        n = 1;
        midpoint_util(head);
        return mid;
    }

    private static void midpoint_util(Node head) {
        if (head == null) {
            n = n / 2;
            return;
        }
        n = n + 1;
        midpoint_util(head.next);
        n = n - 1;
        if (n == 0) {
            mid = head;
        }
    }

    public static void main(String args[]) {
        Node head = newLNode(1);
        head.next = newLNode(2);
        head.next.next = newLNode(3);
        head.next.next.next = newLNode(4);
        head.next.next.next.next = newLNode(5);
        Node result = midpoint(head);
        System.out.print(result.data);
    }
}
