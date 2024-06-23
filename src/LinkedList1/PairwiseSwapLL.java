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
public class PairwiseSwapLL {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    Node pairWiseSwap(Node node) 
    { 
        if (node == null || node.next == null) { 
            return node; 
        }
        Node remaing = node.next.next; 
        Node newhead = node.next; 
        node.next.next = node; 
        node.next = pairWiseSwap(remaing); 
        return newhead; 
    }

    public static void main(String[] args) {

        /* The constructed linked list is: 
         1->2->3->4->5->6->7 */
        PairwiseSwapLL list = new PairwiseSwapLL();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);

        System.out.println("Linked list before calling pairwiseSwap() ");
        list.printList(head);
        head = list.pairWiseSwap(head);
        System.out.println("");
        System.out.println("Linked list after calling pairwiseSwap() ");
        list.printList(head);
        System.out.println("");
    }
}
