
public class LinkedListRandomNode {

	  // *** two methods: http://www.cnblogs.com/grandyang/p/5759926.html (1. count length , 2. reservoir sampling)
    // for counting length, can use fast and slow pointers...
    // 2. reservoir sampling (I don't know this algorithm before)
    // *** result: 133 - 159, beat 63% - 26%
    private ListNode head;
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
    // notice how to represent 1/2, 1/3, 1/4...by using random() method
        if (head == null)
            return 0;
            
        int i = 2;
        ListNode picked = head;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            // *** if write like (int)Math.random()*i, will always get 0;
            // coz (int) caste Math.random() first, so it will get 0 always.
            // write like (int)(Math.random()*i)
            int rate = (int)(Math.random()*i);
            if (0 == rate) {
                picked = cur;
            }
            i++;
        }
        
        return picked.val;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
