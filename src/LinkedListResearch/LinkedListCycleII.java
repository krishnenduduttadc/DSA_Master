package LinkedListResearch;

public class LinkedListCycleII {
    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        LinkedListCycleII solution = new LinkedListCycleII();

        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);
        head.next.next.next.next = head.next; // Creates a cycle

        Node result = solution.detectCycle(head);
        if (result != null) {
            System.out.println("Cycle detected at node with value: " + result.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }

    public Node detectCycle(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                Node entry = head;
                while(entry!=slow){
                    entry=entry.next;
                    slow=slow.next;
                }
                return entry;
            }
        }return null;
    }
}
