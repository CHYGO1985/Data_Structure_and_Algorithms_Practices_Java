import java.util.LinkedList;
import java.util.List;

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

    // method 1: recursive method
    // public Node connect(Node root) {
        
    //     if (root == null) return root;
        
    //     cross(root.left, root.right);
    //     connect(root.left);
    //     connect(root.right);

    //     return root;
    // }

    // private void cross(Node left, Node right) {

    //     if (left == null) return;

    //     left.next = right;
    //     cross(left.right, right.left);
    // }

    // method 2: level traverse with list
    public Node connect(Node root) {
        
        if (root == null) return root;
        
        buildPointers(root, new LinkedList<>(), 0);

        return root;
    }

    private void buildPointers(Node root, List<List<Node>> nodesList, int level) {
    
        if (root == null) return ;

        if (nodesList.size() <= level) {
            nodesList.add(new LinkedList<>());
        }

        List curList = nodesList.get(level);
        if (curList.size() == 0) {
            curList.add(root);
        } else {
            Node topNode = (Node)curList.get(curList.size() - 1);
            topNode.next = root;
            curList.add(root);
        }

        buildPointers(root.left, nodesList, level + 1);
        buildPointers(root.right, nodesList, level + 1);
    }
}