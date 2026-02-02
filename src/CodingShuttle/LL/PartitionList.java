package CodingShuttle.LL;


public class PartitionList {


    public static void main(String[] args) {
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(2);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        int partitionValue = 2;
        Node partitionedHead = partitionList(head, partitionValue);

        // Code to print the partitioned list can be added here
    }

    static Node partitionList(Node head, int b) {
        if (head == null || head.next == null) return head;

        Node sHead = new Node(-1);
        Node lHead = new Node(-1);

        Node sTail = sHead;
        Node lTail = lHead;
        Node cur = head;

        while (cur != null) {
            if (cur.data < b) {
                sTail.next = cur;
                sTail = cur;
            } else {
                lTail.next = cur;
                lTail = cur;
            }
            cur = cur.next;
        }

        sTail.next = lHead.next;
        lTail.next = null;

        return sHead.next;
    }


}


