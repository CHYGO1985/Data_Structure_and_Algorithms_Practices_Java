/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * 
 * 1721. Swapping Nodes in a Linked List
 * 
 * @author jingjiejiang
 * @history Mar 15, 2021
 * 
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
        assert k >= 1;
        
        int listLen = 0;
        ListNode frontNode = null;
        ListNode endNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {

            listLen ++;
            if (endNode != null) {
                endNode = endNode.next;
            }

            if (listLen == k) {
                frontNode = currentNode;
                endNode = head;
            }

            currentNode = currentNode.next;
        }

        int tmp = frontNode.val;
        frontNode.val = endNode.val;
        endNode.val = tmp;

        return head;
    } 
}