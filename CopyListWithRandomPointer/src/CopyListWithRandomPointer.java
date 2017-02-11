
public class CopyListWithRandomPointer {
	
	class RandomListNode {
	    int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	public RandomListNode copyRandomList(RandomListNode head) {
        
        // round 1: do not have any idea
        // ref: http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
        // idea: copy each node, and then the random pointer value, then delete the origianl one
        
        // round 2: implement idea of round 1
        // result: 2m, beat 71.65%, fastest in the db.
        // edge cases:
        if (null == head) {
            return head;
        }
        
        RandomListNode shift = head;
        // first round copy the nodes and their "next" fields
        while (shift != null) {
            // copy each nodes
            RandomListNode temp = new RandomListNode(shift.label);
            // insert the copied node next to the original node
            temp.next = shift.next;
            shift.next = temp;
            shift = temp.next;
        }
        
        // second round: copy the "random" fields
        shift = head;
        // the original node of the copied node
        RandomListNode nextAvail = head;
        while (shift != null) {
            shift = shift.next;
            //*** here to copy the value of random, should not use shift.random = nextAvail.random;
            // the reason is that when copy head.next use shift.next = head.next, not just shift = head
            if (nextAvail.random != null) {
                shift.random = nextAvail.random.next;
            }
            else {
                shift.random = null;
            }
            shift = shift.next;
            nextAvail = shift;
        }
        
        // decouple the two list
        RandomListNode newHead = head.next;
        shift = head.next;
        while (head != null) {
            head.next = head.next.next;
            head = head.next;
            if (head != null) {
                shift.next = shift.next.next;
                shift = shift.next;
            }
        }
        
        return newHead;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
