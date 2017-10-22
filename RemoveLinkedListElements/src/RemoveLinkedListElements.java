/*
 * Question
 Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
/**
 * 
 * 203. Remove Linked List Elements
 * 
 * round 3, solved, 1 attempt, 2 pointers tech (same dir)
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 22, 2017
 */
public class RemoveLinkedListElements {
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public ListNode removeElements(ListNode head, int val) {
        // skip leading nodes that has val
        while (head != null && head.val == val) 
            head = head.next;
        
        // get a new head, if all nodes matches val, then newHead = null
        ListNode newHead = head;
        
        ListNode curAvail = newHead;
        ListNode shift = newHead;
        
        while (shift != null) {
            
            shift = shift.next;
            
            while(shift != null && shift.val == val)
                shift = shift.next;
                
            curAvail.next = shift;
            curAvail = shift;
        } 
        
        return newHead;
    }
}
