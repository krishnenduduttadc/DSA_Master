/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTL1;

/**
 *
 * @author krish
 */
class Node {
    int key;
    Node left, right;
    Node(int x)
    {
        key = x;
        left = right = null;
    }
}
