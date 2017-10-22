/**
 * 
 * 21. Merge Two Sorted Lists
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 22, 2017
 */
public class MergeTwoSortedLists {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	// round 2: the recursive solution
    // ref: https://discuss.leetcode.com/topic/45002/java-1-ms-4-lines-codes-using-recursion/2
    // *** learn the process of drawing draft, then get the recursive solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }   

}
