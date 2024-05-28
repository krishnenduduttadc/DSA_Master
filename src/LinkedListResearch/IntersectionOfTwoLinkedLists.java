package LinkedListResearch;

public class IntersectionOfTwoLinkedLists {
    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        Node headA = new Node(4);
        headA.next = new Node(1);
        Node intersect = new Node(8);
        headA.next.next = intersect;
        intersect.next = new Node(4);
        intersect.next.next = new Node(5);

        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(1);
        headB.next.next.next = intersect;

        Node result = solution.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}
