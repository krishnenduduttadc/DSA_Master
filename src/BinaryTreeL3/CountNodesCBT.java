package BinaryTreeL3;

public class CountNodesCBT {
    public static int countNodes(Node root) {
        if(root == null) return 0;

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        //If left and right are equal it means that the tree is complete and hence go for 2^h -1.
        if(left == right) return ((2<<(left)) -1);

            //else recursively calculate the number of nodes in left and right and add 1 for root.
        else return countNodes(root.left)+ countNodes(root.right)+1;
    }


    public static int getHeightLeft(Node root){
        int count=0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }


    public static int getHeightRight(Node root){
        int count=0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        int dia = countNodes(root);
        System.out.println(dia);
    }
}
