/**
 * 
 * 61. Rotate List
 * 
 * @CHYGO1985
 * @history Oct 8, 2020
 * 
 */
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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode tail = head;
        ListNode newHead = dummy;
            
        int len = 1;
        
        while (tail.next != null){
            tail = tail.next;
            len ++;
        }
        
        for (int cnt = len - (k % len); cnt > 0; cnt --) {
            newHead = newHead.next;
        }
            
        
        tail.next = dummy.next;
        dummy.next = newHead.next;
        newHead.next = null;
        
        return dummy.next;
      
    }
}