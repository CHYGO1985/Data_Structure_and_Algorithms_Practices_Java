package LinkList;
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
 * 2. Feb 22, 2019
 */
public class RemoveLinkedListElements {
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public ListNode removeElements(ListNode head, int val) {
        
        if (head == null) return null;
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        ListNode newHead = head;
        
        while (head != null) {
            
            while (head.next != null && head.next.val == val) {
                head.next = head.next.next;
                
            }
            
            head = head.next;
        }
        
        return newHead;
    }
}
