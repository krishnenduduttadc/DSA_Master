package LinkedList2;

public class Reverse {
    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    static Node th = null;
    static Node tt = null;

    public static void addFirst(Node node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static Node reverse(Node head) {
        Node curr = head;
        while (curr != null) {
            Node forw = curr.next;
            curr.next = null;
            addFirst(curr);

            curr = forw;
        }

        return th;
    }

    static Node head;

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void main(String[] args) {

        Reverse llist = new Reverse();
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(6);

        Node head2 = head;
        while (head2 != null) {
            System.out.print(head2.val + " ");
            head2 = head2.next;
        }
        System.out.println("\n----------");

        Node head1 = reverse(head);
        while (head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }


}
