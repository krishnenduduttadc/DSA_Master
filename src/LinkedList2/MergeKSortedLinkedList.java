package LinkedList2;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for (Node l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }

        Node dummy = new Node(-1);
        Node prev = dummy;
        while (pq.size() != 0) {
            Node node = pq.remove();
            prev.next = node;
            prev = prev.next;
            node = node.next;

            if (node != null) {
                pq.add(node);
            }
        }
        return dummy.next;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node createList(int[] values) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        for (int val : values) {
            prev.next = new Node(val);
            prev = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Hardcoding the lists
        Node[] lists = new Node[3];

        // First list: 1 -> 4 -> 5
        lists[0] = createList(new int[]{1, 4, 5});

        // Second list: 1 -> 3 -> 4
        lists[1] = createList(new int[]{1, 3, 4});

        // Third list: 2 -> 6
        lists[2] = createList(new int[]{2, 6});

        // Merging k sorted linked lists
        Node head = mergeKLists(lists);

        // Printing the merged list
        printList(head);
    }
}
