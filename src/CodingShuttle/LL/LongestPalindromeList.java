package CodingShuttle.LL;

public class LongestPalindromeList {
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

        System.out.println(longestPalindrome(head));
    }

    static int longestPalindrome(Node head) {
        if (head == null) return 0;
        if (head.next == null) return 1;

        Node cur = head;
        Node prev = null;
        int ans = 0;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;

            int commonIfCurIsExactCenter = countCommon(prev, next);
            int lengthFromExactCenter = 2 * commonIfCurIsExactCenter + 1;

            int commonIfCurIsNotExactCenter = countCommon(cur, next);
            int lengthFromNotExactCenter = 2 * commonIfCurIsNotExactCenter;

            int largerOfTheseTwoLengths = Math.max(lengthFromExactCenter, lengthFromNotExactCenter);
            ans = Math.max(ans, largerOfTheseTwoLengths);

            prev = cur;
            cur = next;
        }
        return ans;
    }

    static int countCommon(Node a, Node b) {
        int count = 0;
        while (a != null && b != null) {
            if (a.data == b.data) {
                count++;
                a = a.next;
                b = b.next;
            } else break;
        }
        return count;
    }
}


