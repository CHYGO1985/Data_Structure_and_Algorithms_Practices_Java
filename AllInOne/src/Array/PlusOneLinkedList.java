package src.Array;
import java.util.Stack;

/*
 * 66. Plus One
 */
public class PlusOneLinkedList {

  public int[] plusOne(int[] digits) {
        
        assert digits.length >= 1 && digits.length <= 100;

        for (int idx = digits.length - 1; idx >= 0; idx --) {
            if (digits[idx] != 9) {
                digits[idx] += 1;
                break;
            } else {
                digits[idx] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            Arrays.fill(res, 0);
            res[0] = 1;
            return res;
        }

        return digits;
    }
	
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	 }
	 
	 public ListNode plusOne(ListNode head) {
        // round 1: 15 minutes
        // idea: method 1: use stack, rs: 1ms
        
        // round 2
        // method 2: two pointers tech, recursive method
        
        if (null == head) 
            return head;
            
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dummy = head;
        while (dummy != null) {
            stack.push(dummy);
            dummy = dummy.next;
        }
        
        int carry = 1;
        ListNode temp;
        /*
        while ((carry >= 1)) {
            
            if (stack.empty() == false) {
                temp = stack.pop();
            }
            else {
                temp = new ListNode(carry);
                temp.next = head;
                return temp;
            }
            int cur = temp.val + 1;
            carry = cur / 10;
            temp.val = cur % 10;
        }
        */
        
        // refactoring
        while ((carry >= 1) && (stack.empty() == false)) {
            
            temp = stack.pop();
            int cur = temp.val + 1;
            carry = cur / 10;
            temp.val = cur % 10;
        }
        
        if (carry >= 1)
        {
            temp = new ListNode(carry);
            temp.next = head;
            return temp;
        }
        
        return head;
    }
}
