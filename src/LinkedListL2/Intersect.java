package LinkedListL2;

public class Intersect {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        Node p1 = head1, p2 = head2;
        int s1 = 0, s2 = 0;

        // Calculate the lengths of both linked lists
        while (p1 != null) {
            s1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            s2++;
            p2 = p2.next;
        }

        // Reset the pointers to the head of each linked list
        p1 = head1;
        p2 = head2;

        // Adjust the pointer of the longer list to the same starting point as the shorter list
        if (s1 > s2) {
            int diff = s1 - s2;
            while (diff > 0) {
                p1 = p1.next;
                diff--;
            }
        } else {
            int diff = s2 - s1;
            while (diff > 0) {
                p2 = p2.next;
                diff--;
            }
        }

        // Move both pointers until they meet at the intersection point
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // If there is no intersection, return -1
        if (p1 == null) return -1;

        // Return the data at the intersection point
        return p1.data;
    }

    // Function to create and test the linked lists
    public static void main(String[] args) {
        // Creating two linked lists with an intersection point
        Node common = new Node(8);
        common.next = new Node(10);

        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = common;

        Node head2 = new Node(4);
        head2.next = new Node(7);
        head2.next.next = common;

        Intersect intersect = new Intersect();
        int result = intersect.intersectPoint(head1, head2);

        System.out.println("The intersection point data is: " + result);
    }
}
