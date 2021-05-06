/**
 * 
 * 19. Remove Nth Node From End of List
 * 
 * @author jingjiejiang
 * @history May 4, 2021
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        assert head != null && n >= 1;

        ListNode dummy = new ListNode(0, head);

        ListNode ahead = dummy, behind = dummy;

        for (int cnt = 1; cnt <= n; cnt ++) {
            ahead = ahead.next;
        }

        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        behind.next = behind.next.next;

        return dummy.next;
    }
}