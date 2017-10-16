/**
 * 
 * 109. Convert Sorted List to Binary Search Tree
 * 
 * round 1: solved, 35m, find 3 place errors
 * idea: one use slow and fast to get mid each time for recursive
 * or just conver list to array, then use recursive method
 * 
 * *** 3 errors:
 * 1. slow and fast pointers, need to check whether fast.next == null
 * before using fast.next.next
 * 2. in transformToArray, the index need to - 1 before return
 * 3. whether the array is empty, the condition is end < 0, not end <= 0
 * as in transformToArray, index - 1 before return. so when there is 1 ele
 * then end = 0.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 18, 2017
 */
public class ConvertSortedListToBST {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	// round 1: solved, 35m, find 3 place errors
    public TreeNode sortedListToBST(ListNode head) {
        
        // slow and fast pointers to get the length, then convert list to array
        // then goes the recursive method
        int[] nums = new int[getListLength(head)];
        
        int end = transformToArray(nums, head);
        
        // *** only end < 0, then return null coz end = index - 1, so when there is only 1 ele
        // it can be 0
        if (end < 0) return null;
        
        return buildBST(0, end, nums);
    }
    
    private TreeNode buildBST(int start, int end, int[] nums) {
        
        if (start > end) return null;
        
        // creat root, val as nums[(start + end) / 2]
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        // go for root.left, range (start, mid - 1)
        root.left = buildBST(start, mid - 1, nums);
        
        // go for root.right, range (mid + 1, end)
        root.right = buildBST(mid + 1, end, nums);
        
        return root;
    }
    
    private int transformToArray(int[] nums, ListNode head) {
        
        int index = 0;
        while (head != null) {
            nums[index ++] = head.val;
            head = head.next;
        }
        
        // *** index is used as the actual end index of the array
        return index - 1;
    }
    
    private int getListLength(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;
        
        // *** condition fast.next != null
        while (fast != null && fast.next != null) {
            count ++;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return count * 2;
    }
}
