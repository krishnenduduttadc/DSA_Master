package LinkedListHard;

public class ReverseNodesInKGroup {
    static class Node {
        int val;
        Node next;
        Node(int x) { val = x; }
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        printList(head);
        Node result = solution.reverseKGroup(head, 2);
        printList(result);
        //System.out.println(len(head));
    }

    private static int len(Node head) {
        int c=0;
        while(head!=null){
            head=head.next;
            c++;
        }
        return c;
    }

    private static void printList(Node head) {
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println("null");
    }

    public Node reverseKGroup(Node head, int k) {
        if(head==null || k==1){
            return head;
        }
        Node dummy=new Node(0);
        dummy.next=head;
        Node curr=dummy;
        Node next=dummy;
        Node pre=dummy;
        int count=0;
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
        while (count >= k) {
            curr=pre.next;
            next=curr.next;
            for (int i = 1; i <k ; i++) {
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = curr.next;
            }
            pre = curr;
            count -= k;
        }
        return dummy.next;
    }
}
