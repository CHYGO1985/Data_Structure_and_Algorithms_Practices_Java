import java.util.Comparator;
import java.util.PriorityQueue;


public class MergekSortedLists {
	
	public class ListNode {
        int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
        
        // 1st round: did not solve the question
        // 2nd round: imeplement method 2
        
        // idea: method 1: brutal force (merge one by one), insertion start from front to rear, Time complexity O(n)
        // a, b, c (a+b+c = n), first: insert b to a, that is a*b + b, then c to a+b, that is (a+b)c+c, so is O(n^2)
        
        // method 2: dvide and conquer (same idea as merge sort) O(nlog(n))
        // ref: https://discuss.leetcode.com/topic/2780/a-java-solution-based-on-priority-queue/3
        // wksora's post
        /*
        for example, 8 ListNode, and the length of every ListNode is x1, x2, x3, x4, x5, x6, x7, x8, total is n. 
        on level 3: x1+x2, x3+x4, x5+x6, x7+x8 sum: n
        on level 2: x1+x2+x3+x4, x5+x6+x7+x8 sum: n
        on level 1: x1+x2+x3+x4+x5+x6+x7+x8 sum: n
        total 3n, nlog8
        */
    	// *** things learned : 1) divide and conquer for comparing like problem (for this question, merge sorted list, so 
        // go through all ele in list is not avoidable)
    	
        // method 3: sorted according the front and rear, then merge O(nlog(n)), compare from rear
        // ref: https://discuss.leetcode.com/topic/2780/a-java-solution-based-on-priority-queue
        if(null == lists || 0 == lists.length) {
            return null;
        }
        
         // *** constructor of priorityqueue
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        for (ListNode node: lists) {
            if (node != null)
                queue.offer(node);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        // *** here, do not use the condition queue != null, queue is empty(no elements) and queue is null
        // is two different concept
        while (false == queue.isEmpty()) {
            pointer.next = queue.poll();
            pointer = pointer.next;
            
            // *** if it is the head of a list, then add all to the queue, and automatically sort
            // *** so ever time, the max size of queue is the lists.size(), assume every lists has an element
            // similar to layer traverse
            if (pointer.next != null)
                queue.offer(pointer.next);
        }
        
        return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
