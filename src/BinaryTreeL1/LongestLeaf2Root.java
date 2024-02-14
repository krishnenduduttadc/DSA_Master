/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;

import java.util.ArrayList;

/**
 *
 * @author krish
 */
public class LongestLeaf2Root {
    public static ArrayList<Integer> longestRootToLeafPath(Node root){
         if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(root.data);
            return ans;
        }
        ArrayList<Integer> left = longestRootToLeafPath(root.left);
        ArrayList<Integer> right = longestRootToLeafPath(root.right);
        if(left == null){
            right.add(root.data);
            return right;
        }

        if(right == null){
            left.add(root.data);
            return left;
        }
        if(left.size() > right.size()){
           left.add(root.data) ;
           return left;
        }else{
            right.add(root.data);
            return right;
        }
	}
    
     public static void main(String args[]) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.left.left.left = new Node(4);
        root.right = new Node(9);
        root.right.right = new Node(2);
        root.right.right.left = new Node(6);
        ArrayList<Integer> a=longestRootToLeafPath(root);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i)+"-");
        }
     }
}
