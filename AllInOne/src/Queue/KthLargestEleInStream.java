package Queue;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 
 * @author jingjiejiang Feb 9, 2019
 *
 */
public class KthLargestEleInStream {
	
	private int k;
    private PriorityQueue<Integer> queue;
	
	public KthLargestEleInStream(int k, int[] nums) {
		this.k = k;
        queue = new PriorityQueue<Integer>(k);
        for (int num : nums) {
        	add(num);
        }
    }
    
    public int add(int val) {
    	if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }
  
        return queue.peek();
    }
}
