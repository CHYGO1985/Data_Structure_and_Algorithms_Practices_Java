/**
 * 
 * 116. Populating Next Right Pointers in Each Node
 * 
 * @CHYGO1985
 * @history Nov 13, 2020
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        
        if (root == null) return root;
        
        cross(root.left, root.right);
        connect(root.left);
        connect(root.right);

        return root;
    }

    private void cross(Node left, Node right) {

        if (left == null) return;

        left.next = right;
        cross(left.right, right.left);
    }
}