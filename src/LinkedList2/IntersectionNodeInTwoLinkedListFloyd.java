package LinkedList2;

public class IntersectionNodeInTwoLinkedListFloyd {
    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node startingNodeOfCycle(Node head){
        if(head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }

        if(slow != fast) return null;

        slow = head;
        fast = fast;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static Node IntersectionNodeInTwoLL(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        Node tail = headA;
        while(tail.next != null) tail = tail.next;

        tail.next = headB;

        Node ans = startingNodeOfCycle(headA);

        tail.next = null;
        return ans;
    }

    public static void main(String[] args) {
        // Creating first linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        // Creating second linked list: 6 -> 7
        Node head2 = new Node(6);
        head2.next = new Node(7);

        // Creating intersection at node with value 3 (0-based index 2 in head1)
        Node curr = head1;
        int idx = 2;  // Index at which the intersection should occur
        while (idx-- > 0) {
            curr = curr.next;
        }

        // Attaching the intersection node to the end of the second list
        Node prev = head2;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = curr;

        Node ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);  // Should print the value of the intersection node
    }
}
