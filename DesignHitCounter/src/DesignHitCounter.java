import java.util.LinkedList;
import java.util.List;


public class DesignHitCounter {
	// round 1: 50 minutes, 94ms beat 93.73%
    // method 1: list --> to keep the time line information (if hits come at the same time, they must cal at 
    // the last ele of the queue)
    
    // 1. *** Queue is an Interface in Java. Methods: 
    // 	Throws exception	Returns special value
    /*
            Insert	add(e)	offer(e)
            Remove	remove()	poll()
            Examine	element()	peek()
    */
    // 2. *** initialise linkedlist of arrays new LinkedList<int[]>();
    // do not do it like: new LinkedList<new int[2]>()
    
    // method 2:
    // this method is not good, if gethits is used to check historical data
    // ref: https://discuss.leetcode.com/topic/48758/super-easy-design-o-1-hit-o-s-gethits-no-fancy-data-structure-is-needed/2
    
    // current total hits count in the linkedhashmap
    int sum;
    // 1st Integer: timestamp, 2nd Integer: hits at the timestamp
    List<int[]> list;
    
    /** Initialize your data structure here. */
    public DesignHitCounter() {
        sum = 0;
        list = new LinkedList<int[]>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        
        // *** I did not consider empty case
        if (list.isEmpty() == false) {
            int[] preHits = list.get(list.size() - 1);
            if (preHits[0] == timestamp) {
                preHits[1] += 1;
                // *** this sum ++ is easy to ignore
                sum ++;
                return ;
            }
        }
    
        int[] newHits = new int[2];
        newHits[0] = timestamp;
        newHits[1] = 1;
        list.add(newHits);
    
        sum ++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
        int tempSum = sum; 
        for (int i = 0; i < list.size(); i ++) {
            int[] hits = list.get(i);
            if (timestamp - hits[0] < 300) {
                return tempSum;
            }
            else {
                tempSum -= hits[1];
            }
        }
        
        // it may be the case that tempSum = 0
        return tempSum;
    }
}
