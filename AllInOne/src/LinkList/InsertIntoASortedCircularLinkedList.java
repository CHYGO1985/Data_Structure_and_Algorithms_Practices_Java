/**
 * 
 * 708. Insert into a Sorted Circular Linked List
 * 
 * @CHYGO1985
 * @history Sep 24, 2020
 * 
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {

        if (head == null) {
            
            head = new Node(insertVal, null);
            head.next = head;
            return head;
        }

        //find the max node
        Node max = head;
        while (max.val <= max.next.val && max.next != head) max = max.next;
        //get the min node and point cur node to min node 
        Node min = max.next, cur = min;
        //if given val is < min or > max, then insert the new node after max.next 
        if (insertVal <= min.val || insertVal >= max.val) max.next = new Node(insertVal, min);
        //otherwise find the correct position to insert
        else {
            while (cur.next != null && cur.next.val < insertVal) cur = cur.next;
            cur.next = new Node(insertVal, cur.next);
        }
        
        return head;
    }
}