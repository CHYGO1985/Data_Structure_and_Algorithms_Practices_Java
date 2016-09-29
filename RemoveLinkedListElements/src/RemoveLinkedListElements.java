/*
 * Question
 Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class RemoveLinkedListElements {
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public static ListNode removeElements(ListNode head, int val) {
        // * idea: for special case 1->6->6->6->6->2, 6 or
        // for the case that head.val = val and continuesly (6->6->6->1, 6)
        // *** result: 2ms, one of 42.54%. fastest, 1 ms, 52.54%.
        // Improve: mix special case into normal handling, exchange space for time, build a new list
        // Improved solution: still used 2 extra nodes, and skip the node which has val.
        // **** result: 1ms.
        
        /*
        // Solution 1: 1ms
        while (head != null && head.val == val) {
            head = head.next;
        }
         
        if (null == head )
            return head;
            
        ListNode newList = head;
        ListNode shiftHead = newList;
        
        while (head.next != null) {
            
            head = head.next;
            
            if (head.val != val) {
                shiftHead.next = head;
                shiftHead = shiftHead.next;
            }
          
        }
        
        // head == null, means the value of last node == val
        shiftHead.next = head.next;
        
        return newList;
        */
        
        // special case: 
        // 1) head == null
        // 2) 6->6, 6
        // solution 2: 2ms
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (null == head)
            return head;
            
        ListNode shiftNode = head;
        
        // iterate through the whole list
        while (shiftNode != null && shiftNode.next != null) {
            
            ListNode emptyNode = shiftNode;
            boolean hasMatch = false;
            
            // for special case 1->6->6->6->6, shiftNode will be null
            while (emptyNode.next != null && emptyNode.next.val == val) {
            
                emptyNode = emptyNode.next;
                hasMatch = true;
            }
            
            // after there is a or more than one match
            if (hasMatch) {
                shiftNode.next = emptyNode.next;
            }
            // no match
            else {
                shiftNode = emptyNode.next;
            }
        }
        
        return head;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
