import java.util.HashMap;
import java.util.Map;

/**
 * round 2: try method 3
 * 
 * round 1: method 2: 40m, 63ms; method 3: 3ms (unsolved)
 * method 1: brutal force: TLE
 * method 2: use hashmap to handle repeated range, 40m, 63ms, beat 22%
 * method 3: O(k + N), DP (cal series of sums in an array)use start and end + 1 pos as flag, then DP
 * ref: https://discuss.leetcode.com/topic/49691/java-o-k-n-time-complexity-solution/2
 * 
 * Just store every start index for each value and at end index plus one minus it
 * for example it will look like:
 * [1 , 3 , 2] , [2, 3, 3] (length = 5)
 * res[ 0, 2, ,0, 0 -2 ]
 * res[ 0 ,2, 3, 0, -5]
 * sum 0, 2, 5, 5, 0
 * res[0, 2, 5, 5, 0]
 * 
 * @author jingjiejiang
 * @history Jun 8, 2017
 * 
 */ 
public class RangeAddition {
	
	// method 2: use hashmap (avoid iterate through the same range)
	/*
	public int[] getModifiedArray(int length, int[][] updates) {
        
        // do I need to use long here?
        int[] res = new int[length];
        
        // String: range, Integer: value
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < updates.length; i ++) {
            String range = "" + updates[i][0] + "#" + updates[i][1];
            int val = map.getOrDefault(range, 0) + updates[i][2];
            map.put(range, val);
        }
        
        for (String key : map.keySet()) {
            String[] range = key.split("#");
            int begin = Integer.valueOf(range[0]);
            int end = Integer.valueOf(range[1]);
            int val = map.get(key);
            for (int i = begin; i <= end; i ++) {
                res[i] += val;
            }
        }
        
        return res;
    }
	*/
	
	// method 3: O(k + N)
	public int[] getModifiedArray(int length, int[][] updates) {
        
        // do I need to use long here?
        int[] res = new int[length];
        
        for (int[] update : updates) {
            int val = update[2];
            int begin = update[0];
            int end = update[1];
            
            res[begin] += val;
            
            if (end < length - 1) res[end + 1] -= val;
        }
        
        for (int i = 1; i < length; i ++) {
            res[i] += res[i - 1];
        }
        
        return res;
    }
}
