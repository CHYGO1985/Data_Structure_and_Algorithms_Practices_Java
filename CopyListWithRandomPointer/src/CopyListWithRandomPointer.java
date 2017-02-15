
public class CopyListWithRandomPointer {
	
	static class RandomListNode {
	    int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
		
		RandomListNode(int x, RandomListNode next) { 
			this.label = x;
			this.next = next;
			// this.random = random;
		}
	};
	
	public static RandomListNode copyRandomList(RandomListNode head) {
        
        // round 1: do not have any idea
        // ref: http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
        // idea: copy each node, and then the random pointer value, then delete the origianl one
        
        // round 2: implement idea of round 1
        // result: 2m, beat 71.65%, fastest in the db.
		// things learned: shift.random = nextAvail.random VS shift.random = nextAvail.random.next.
        // it requires the truely understanding of node.next
        // nextAvail.random is the original random node
        // nextAvail.random.next is the copy of the original random node
        // so use unextAvail.random.next
		
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
            	// shift.random = nextAvail.random;
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
		
		
		
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node3 = new RandomListNode(3, node4);
		RandomListNode node2 = new RandomListNode(2, node3);
		RandomListNode node1 = new RandomListNode(1, node2);
		/*
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		*/
		node1.random = node3;
		node2.random = node4;
		node3.random = node1;
		
		RandomListNode head = copyRandomList(node1);
	}
}
