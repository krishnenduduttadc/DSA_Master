package LinkedListL3;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    static class Node {
        int val;
        Node next;
        Node(int x) { val = x; }
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();

        Node[] lists = new Node[3];
        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(5);

        lists[1] = new Node(1);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(4);

        lists[2] = new Node(2);
        lists[2].next = new Node(6);

        Node result = solution.mergeKLists(lists);
        printList(result);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<Node> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        Node dummy = new Node(0);
        Node tail = dummy;

        for (Node node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) queue.add(tail.next);
        }

        return dummy.next;
    }
}
