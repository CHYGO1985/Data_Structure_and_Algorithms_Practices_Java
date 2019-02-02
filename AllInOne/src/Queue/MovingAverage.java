package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author jingjiejiang Fen 2, 2019
 *
 */
public class MovingAverage {

	private int sum;
	private int size;
	Queue<Integer> nums;
	
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new LinkedList<>();
        sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        
    	if (nums.size() >= size) {
    		sum -= nums.peek();
        	nums.poll();
    	}
    	
    	nums.offer(val);
        sum += val;
    	
    	return (double) sum / nums.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */