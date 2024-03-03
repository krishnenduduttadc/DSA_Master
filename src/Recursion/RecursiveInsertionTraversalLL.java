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
public class RecursiveInsertionTraversalLL {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    };

    static void traverse(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        traverse(head.next);
    }

    static Node newNode(int data) {
        Node n = new Node(data);
        n.next = null;
        return n;
    }

    static Node insertEnd(Node head, int data) {
        if (head == null) {
            return newNode(data);
        }else{
            head.next=insertEnd(head.next,data);
            return head;
        }
    }

    public static void main(String args[]) {
        Node head = null;
        head = insertEnd(head, 6);
        head = insertEnd(head, 8);
        head = insertEnd(head, 10);
        head = insertEnd(head, 12);
        head = insertEnd(head, 14);
        traverse(head);
    }
}
