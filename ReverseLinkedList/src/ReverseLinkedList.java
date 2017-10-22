/**
 * 
 * 206. Reverse Linked List
 * 
 * round 3: recursive method.
 * 
 * idea: the designing of recursive method.
 * The most important thing is to remember that recursive method runs with a
 * STACK.So when design recursive method, think about the reverse way, 
 * think about how to do with the last node, then go with previous node
 * 
 * e.g. for list 1 -> 2 -> 3 -> 4
 * 1) the last one of recursive will be 4, what we do with 4?
 * we let the 4 point to 3 
 * 1 -> 2 -> 3 -> (4 -> 3)
 * 
 * 2) 1 -> 2 -> 3 -> 4 ( -> 3)
 * let 3 -> 2 ...
 * 
 * until the end we get 4 -> 3 -> 2 -> 1 (-> 2)
 * 
 * 3) we can notice that 1 still point to 2, so every round
 * we let the current head.next point to null
 * 
 * 4) we need to return the new head 4 , so we need to return the new head 
 * for every round of calling recursive method.
 * 
 * then it goes the final solution
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 22, 2017
 */
public class ReverseLinkedList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	// non recursive method
	/*
	public ListNode reverseList(ListNode head) {
        
        if (null == head || null == head.next) {
            return head;
        }
        
        ListNode curNode = head;
        //ListNode frontier = head;
        ListNode nextNode = null;
        
        while (curNode.next != null) {
            
            nextNode = curNode.next;
            curNode.next = curNode.next.next;
            nextNode.next = head;
            head = nextNode;
        }
        
        return head;
        
    }
	*/
	
	// recursive method.
	public static ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
    
        ListNode headNext = head.next;
        ListNode newHead = reverseList(head.next);
        headNext.next = head;
        head.next = null;
        
        return newHead;
        
        // when head.next == null, head.next point = its parent node
        
        // I think about method like go to the end of the list and begin to change
        // 1-->2-->3 1) 1-->2<--3 2) 1<--2<--3
        // the following code came from: https://discuss.leetcode.com/topic/16506/my-java-recursive-solution/2
        // the method implement my idea of go the end the of list and then change the link between the two from end to start
        // The desing of the recursive method here is worth learning
        /*
        if(head==null || head.next==null)
          return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
        */
        
        
    }
}