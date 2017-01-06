import javax.swing.text.AbstractDocument.LeafElement;


public class AddTwoNumbers {
	
	public static class ListNode {
		int val;
		ListNode next;
	    ListNode(int x) { val = x; }
	}
	// idea: use the original l1 to store result
    // result: 48ms. beat 95.28%
    // things learned: the solution was very quick to figure out, but I wasted so much time (2 hours) on how to add
    // a node to linkedlist (as I always use l1 = l1.next(even if when l1.next == null)), so it failed to add it to
    // the list.
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (null == l1) {
            return l2;
        }
        
        int carry = 0;
        ListNode res = l1;
        ListNode pointer = l1;
        
        while (pointer != null && l2 != null) {
            
            int sum = carry + l1.val + l2.val;
            
            carry = sum / 10;
            sum = sum % 10;
            
            l1.val = sum;
            if (l1.next != null) {
                l1 = l1.next;
            }
            pointer = pointer.next;
            l2 = l2.next;
        }
        
        // for case: index < l1.size() && carry > 0 && index >= l2.size()
        while (pointer != null && carry > 0) {
            
            int curDigit = carry + l1.val;
            carry = curDigit / 10;
            curDigit = curDigit % 10;
            
            pointer.val = curDigit;
            if (l1.next != null) {
                l1 = l1.next;
            }
            pointer = pointer.next;
        }
        
        // optimise of previous
        // optimised : 57ms
        /*
        while (pointer != null) {

            int l2Val = (l2 == null ? 0 : l2.val);
            int sum = carry + l1.val + l2Val;
            
            carry = sum / 10;
            sum = sum % 10;
            
            l1.val = sum;
            if (l1.next != null) {
                l1 = l1.next;
            }
            pointer = pointer.next;
            l2 = ((l2 == null) ? l2 : l2.next);
        }
        */
        
        // for case: index >= l1.size() && index < l2.size()
        while (l2 != null) {
            
            int curDigit = carry + l2.val;
            carry = curDigit / 10;
            curDigit = curDigit % 10;
            
            l1.next = new ListNode(curDigit);
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // for case: index >= l1.size() && index >= l2.size() && carry > 0
        if (carry > 0) {
            
            l1.next = new ListNode(carry);
            l1 = l1.next;
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ListNode l1 = new ListNode(8);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		*/
		
		ListNode l1 = new ListNode(8);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		ListNode l2 = new ListNode(2);
		
		l1 = addTwoNumbers(l1, l2);
	}

}
