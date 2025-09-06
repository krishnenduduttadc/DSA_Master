package LeetCodePatterns.BinaryTreeDirectRecursion;

public class Cousin {

    private TreeNode firstParent, secondParent;
    private int firstLevel, secondLevel;

    public static void main(String[] args) {
        Cousin checker = new Cousin();

        /*
                1
               / \
              2   3
               \
                4
        */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(4);

        System.out.println("Are 4 and 3 cousins? " + checker.isCousins(root1, 4, 3)); // false

        /*
                1
               / \
              2   3
             /     \
            4       5
        */
        Cousin checker2 = new Cousin();
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        System.out.println("Are 4 and 5 cousins? " + checker2.isCousins(root2, 4, 5)); // true
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        preOrder(root, 0, null, x, y);
        return (firstLevel == secondLevel && firstParent != secondParent);
    }

    private void preOrder(TreeNode node, int level, TreeNode parent, int x, int y) {
        if (node != null) {
            if (node.val == x) {
                firstParent = parent;
                firstLevel = level;
            }
            if (node.val == y) {
                secondParent = parent;
                secondLevel = level;
            }

            if (node.left != null) {
                preOrder(node.left, level + 1, node, x, y);
            }
            if (node.right != null) {
                preOrder(node.right, level + 1, node, x, y);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
