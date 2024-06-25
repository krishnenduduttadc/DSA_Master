/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionL1;

/**
 *
 * @author krish
 */
public class DeleteKthLL {

    static class Node {

        int data;
        Node next;
    };

    static Node deleteNode(Node start, int k) {
        if (k < 1) {
            return start;
        }
        if (start == null) {
            return null;
        }
        if(k==1){
            Node res=start.next;
            return res;
        }
        start.next=deleteNode(start.next, k-1);
        return start;
    }

    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head_ref;
        head_ref = new_node;
        return head_ref;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        Node head = null;

        // Create following linked list  
        //12.15.10.11.5.6.2.3 / 
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 11);
        head = push(head, 10);
        head = push(head, 15);
        head = push(head, 12);
        System.out.printf("\nLinked List: ");
        printList(head);

        int k = 3;
        head = deleteNode(head, k);

        System.out.printf("\nModified Linked List: ");
        printList(head);
    }
}
