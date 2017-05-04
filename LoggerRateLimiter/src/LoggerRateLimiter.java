import java.util.HashMap;
import java.util.Map;


public class LoggerRateLimiter {
	
	// round 1: 15 minutes, solved
    // *** did not test the case that the message may come at time 0 (I thought about it when setting default value
    // but I did not check)
    // result: 165ms, beat 79.97%

    private Map<String, Integer> map; 
    
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if (null == message)
            return false;
        
        int preTime = map.getOrDefault(message, -1);
        if (preTime == -1) {
            map.put(message, timestamp);
            return true;
        }
        else if (timestamp - preTime < 10) {
            return false;
        }
        // timestamp - preTime >= 10
        else {
            map.put(message, timestamp);
            return true;
        }
        
        /*
        // *** a more delicate implementation: 
        // https://discuss.leetcode.com/topic/48359/short-c-java-python-bit-different/2
        if (timestamp < ok.getOrDefault(message, 0))
            return false;
        ok.put(message, timestamp + 10);
        return true;
        */
    }

}
