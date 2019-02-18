package LinkList;

/**
 * 
 * @author jingjiejiang Feb 18, 2019
 *
 */
public class LinkedListCycle {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public boolean hasCycle(ListNode head) {
        
		if (head == null || head.next == null) return false;
		
		ListNode fast = head.next.next;
		while (head != null && fast != null && fast.next != null) {
			if (fast == head) return true;
			
			head = head.next;
			fast = fast.next.next;
		}
		
		return false;
    }
}
