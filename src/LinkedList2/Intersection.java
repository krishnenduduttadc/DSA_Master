package LinkedList2;




public class Intersection {
    static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
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
        // Create two linked lists
        Node intersectNode = new Node(8);
        intersectNode.next = new Node(4);
        intersectNode.next.next = new Node(5);

        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = intersectNode;

        Node headB = new Node(5);
        headB.next = new Node(0);
        headB.next.next = new Node(1);
        headB.next.next.next = intersectNode;

        // Call the function to get the intersection node
        Intersection solution = new Intersection();
        Node intersectionNode = solution.getIntersectionNode(headA, headB);

        // Print the result
        if (intersectionNode != null) {
            System.out.println("Intersection node value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
