
public class ReverseNodesInKGroup {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        // idea: reverse a linked list method + counting remaining k (it is required to use constant memory)
        // result: 9ms, beat 26.95%
        // things learned: always draw on paper to go through the process (write most representable test case, then go
        // through it) before finding any regulation
        
        // edge cases
        if (null == head || null == head.next || 0 == k || 1 == k) {
            return head;
        }
        
        // permHeas is the permanent head
        ListNode permHead = head;
        ListNode preNode = head;
        ListNode measure = head;
        ListNode postNode;
        ListNode tail = preNode;
        boolean isFirst = true;
        // the first loop as preNode is in the group, so count = k
        int count = k;
        
        // count whether there are k nodes left
        // *** node: measure != null must come first, otherwise, for [1, 2]  2: it will throw nullpointer
        while (measure != null && preNode.next != null) {
            
            while (measure != null && count != 0) {
                count --;
                measure = measure.next;
            }
            
            if (0 == count) {
                //as the firstNode is involve in reverse, so there is two involved in reverse the 1st time, so temp = k - 1
                int temp = k - 1;
                // doing reverse, from preNode until kth nodes;
                while (temp > 0) {
                    postNode = preNode.next;
                    preNode.next = preNode.next.next;
                    postNode.next = permHead;
                    permHead = postNode;
                    temp --;
                }
                count = k;
                // connect the last reverse list with the current reversed list
                // if it is the first group, keep the new head infor
                if (true == isFirst) {
                    head = permHead;
                    isFirst = false;
                }
                else {
                    tail.next = permHead;
                }
                
                tail = preNode;
                preNode = preNode.next;
                measure = preNode;
                permHead = preNode;
            }
            
            //*** measure = null (assin null to preNode.next will cause problem)
            // when 1,2,3,4,5 3: result is 3,2,1,4 (5 is missint)
            //preNode.next = measure;
        }
        
        return head;
    }
}
