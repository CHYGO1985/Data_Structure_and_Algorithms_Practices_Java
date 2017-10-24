
public class SwapNodesInPairs {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairs(ListNode head) {
        // round 2: the use of dummy head makes the solution more elegent
        
        // * idea: 1) understanding question：
        
        // 2) Simialr situation: reverse a linked list.
        // a. the first two are the same operations as reverse a linked list.
        // b. remember such question is to draw each single steps and mark the important nodes for each step
        // c. consider special case: head = null, head.next == null, head.next.next == null return heard
      
        // * Result: 0 ms, the quickest solution as 90.7% of others.
        // *** problem ***: I need to run the code for 3 times to fix some bugs.
        // 1) I didn't consider the head problem, i firstly just return head, however, obviously, the head was changed
        // after the first swap, then i return firstNode.next, however, dummyhead is a variable keep changing, so I 
        // used a new variable newHead to returned the head of the swapped list.
        // *** Idea ***: problem like this, 1) draw each single steps, find the nodes that should be used in a loop, see
        // whether the number of the nodes can be reduced; 2) think about special case, empty head, linkedlist that only 
        // has one node etc.3) think about the condition for loop, see whether they can contain the special cases; 
        // 4) think about how to return the head of the new list.
        
        // *** add a dummy head (firstHead) makes the algorithm more elegent, otherwise, need to check whether 
        // to asign a new head
        // everytime.
        ListNode firstNode = new ListNode(0);
        ListNode newHead = firstNode;
        firstNode.next =  head;
        
        while (firstNode.next != null && firstNode.next.next != null) {
            
            ListNode secNode = firstNode.next;
            firstNode.next = firstNode.next.next;
            secNode.next = secNode.next.next;
            firstNode.next.next = secNode;
            firstNode = secNode;
        }
        
        return newHead.next;
    }

}
