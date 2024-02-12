/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 *
 * @author krish
 */
public class AlternativeNodesLL {

    static class Node {

        int data;
        Node next;
    };

    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head_ref;
        head_ref = new_node;
        return head_ref;
    }

    static void printAlternate(Node node, boolean isOdd) {
        if (node == null) {
            return;
        }
        if(isOdd==true){
            System.out.print(node.data+" ");              
        }
        printAlternate(node.next,!isOdd);       
    }

    public static void main(String args[]) {
        // Start with the empty list  
        Node head = null;

        // con below list  
        // 1.2.3.4.5.6.7.8.9.10  
        head = push(head, 10);
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        printAlternate(head, true);

    }
}
