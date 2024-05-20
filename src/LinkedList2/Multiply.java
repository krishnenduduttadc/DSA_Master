package LinkedList2;

public class Multiply {

    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public static void addTwoLinkedList(Node head, Node ansItr) {
        Node c1 = head;
        Node c2 = ansItr;

        int carry = 0;
        while (c1 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2.next != null ? c2.next.val : 0);
            int digit = sum % 10;
            carry = sum / 10;

            if (c2.next != null) c2.next.val = digit;
            else c2.next = new Node(digit);

            if (c1 != null) c1 = c1.next;
            c2 = c2.next;
        }
    }

    public static Node multiplyLLWithDigit(Node head, int dig) {
        Node dummy = new Node(-1);
        Node ac = dummy;
        Node curr = head;
        int carry = 0;
        while (curr != null || carry != 0) {
            int sum = carry + (curr != null ? curr.val * dig : 0);

            int digit = sum % 10;
            carry = sum / 10;

            ac.next = new Node(digit);

            if (curr != null) curr = curr.next;
            ac = ac.next;
        }

        return dummy.next;
    }

    public static Node multiplyTwoLL(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        Node l2_Itr = l2;
        Node dummy = new Node(-1);
        Node ansItr = dummy;

        while (l2_Itr != null) {
            Node prod = multiplyLLWithDigit(l1, l2_Itr.val);
            l2_Itr = l2_Itr.next;

            addTwoLinkedList(prod, ansItr);
            ansItr = ansItr.next;
        }

        return reverse(dummy.next);
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
        // First list: 3 -> 4 -> 2 (represents the number 243)
        Node head1 = createList(new int[]{3, 4, 2});

        // Second list: 4 -> 6 -> 5 (represents the number 564)
        Node head2 = createList(new int[]{4, 6, 5});

        // Multiplying the two linked lists
        Node ans = multiplyTwoLL(head1, head2);

        // Printing the result
        printList(ans);
    }
}
