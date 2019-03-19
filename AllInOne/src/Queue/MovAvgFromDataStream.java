package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author jingjiejiang Mar 19, 2019
 *
 */
public class MovAvgFromDataStream {
	
	private Queue<Integer> queue;
    private int size;
    private int sum;
    
    /** Initialize your data structure here. */
    public MovAvgFromDataStream(int size) {
        
    	this.size = size;
    	queue = new LinkedList<>();
    	sum = 0;
    }
    
    public double next(int val) {
        
    	if (queue.size() < size) {
    		queue.offer(val);
    		sum += val;
    	} else {
    		int old = queue.poll();
    		queue.offer(val);
    		sum = sum - old + val;
    	}
    	
    	return sum / queue.size();
    }
}
