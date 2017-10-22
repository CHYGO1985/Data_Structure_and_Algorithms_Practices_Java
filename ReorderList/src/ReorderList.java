/**
 * 
 * 143. Reorder List
 * 
 * round 1: solved, 3hr
 * 
 * *** get the idea very quick, but spending time on debugging
 * 
 * idea; mistake: when find out a solution for list changing, go through whole list
 * till the end to make sure the method works
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 22, 2017
 */
public class ReorderList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public void reorderList(ListNode head) {
        
        if( head == null || head.next == null) return;
        
        // find mid
        ListNode slow = head;
        ListNode fast = head;
        // *** the condition here is not right
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse list from slow.next
        ListNode newHead = slow.next;
        ListNode curHead = slow.next;
        ListNode nextNode = null;
        
        while (curHead.next != null) {
            
            nextNode = curHead.next;
            curHead.next = curHead.next.next;
            nextNode.next = newHead;
            newHead = nextNode;
        }
        slow.next = newHead;
        
        // insertion
        fast = slow.next;
        ListNode mid = slow; 
        slow = head;
        
        // *** need to draw a list to get the quiting condition
        // 1 2 3 6 5 4
        while (slow != mid) {
            
            ListNode fastNext = fast.next;
            ListNode slowNext = slow.next;
            slow.next = fast;
            fast.next = slowNext;
            slow = slowNext;
            fast = fastNext;
        }
        
        // ***
        slow.next = fast;
    }
}
