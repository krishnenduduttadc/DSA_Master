package BinaryTreeL2;

public class MaxPathSum {
    static Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    public static class pairSum {
        int NTN_MaxSum = -(int) 1e9;
        int RTN_MaxSum = 0;
    }

    public static pairSum maxPathSum_(Node root) {
        if (root == null) return new pairSum();

        pairSum lp = maxPathSum_(root.left);
        pairSum rp = maxPathSum_(root.right);

        pairSum myAns = new pairSum();

        int RTN_maxSum = Math.max(lp.RTN_MaxSum, rp.RTN_MaxSum) + root.val;

        int NTN_MaxSum = getMaxSum(lp.NTN_MaxSum, rp.NTN_MaxSum, lp.RTN_MaxSum + root.val + rp.RTN_MaxSum, root.val, RTN_maxSum);

        myAns.RTN_MaxSum = Math.max(RTN_maxSum, root.val);
        myAns.NTN_MaxSum = NTN_MaxSum;

        return myAns;
    }

    static int NTN_MaxAns = -(int) 1e9;

    public static int maxPathSum_02(Node root) {
        if (root == null) return 0;

        int RTN_LmaxSum = maxPathSum_02(root.left);
        int RTN_RmaxSum = maxPathSum_02(root.right);

        int RTN_maxSum = Math.max(RTN_LmaxSum, RTN_RmaxSum) + root.val;

        NTN_MaxAns = getMaxSum(NTN_MaxAns, RTN_LmaxSum + root.val + RTN_RmaxSum, root.val, RTN_maxSum);

        return Math.max(RTN_maxSum, root.val);
    }


    public static int maxPathSum(Node root) {
        if (root == null) return 0;
        maxPathSum_02(root);

        return NTN_MaxAns;
    }

    public static int getMaxSum(int... arr) {
        int maxSF = arr[0];
        for (int ele : arr)
            maxSF = Math.max(maxSF, ele);
        return maxSF;
    }

    public static void main(String[] args) {
        MaxPathSum tree = new MaxPathSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int ans = maxPathSum(root);

        System.out.print(ans);


    }
}
