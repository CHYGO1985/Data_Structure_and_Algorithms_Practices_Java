/**
 * 
 * Build list from an array of data.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 22, 2017
 */
public class ListBuilding {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode buildList(int[] nums) {
		
		if (0 == nums.length) 
			return null;
		
		ListNode head = new ListNode(nums[0]);
		ListNode oriHead = head;
		for (int i : nums) {
			ListNode temp = new ListNode(i);
			head.next = temp;
			head = head.next;
		}
		
		return oriHead;
	}
	
	public static void main(String[] args) {
		ListNode head = buildList(new int[]{1,2,3,4});
	}

}
