import org.w3c.dom.Node;

/**
 * 
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * 
 * @author jingjiejiang
 * @history Feb 7, 2021
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
    
        if (root == null) return root;

        builder(root);
        last.right = first;
        first.left = last;

        return first;
    }

    private void builder(Node root) {

        if (root == null) return;

        builder(root.left);

        if (last != null) {
            last.right = root;
            root.left = last;
        } else {
            // keep the smallest node as head
            first = root;
        } 

        last = root;

        builder(root.right);
    }
}