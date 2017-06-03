import java.util.HashMap;
import java.util.Map;

/**
 * round 1: solved, Hashmap, 30 minites
 * 1. add all ele to a hash map <Integer(num), Integer(visiting count)>
 * 2. iterate through map, get num A at a time, check whether there is a key A + 1, if there is count + 1, change the value
 * to negative num to avoid check again
 * 
 * @author jingjiejiang
 * @history Jun 4, 2017
 */
public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] nums) {
        
        int max = 1;
        
        if (null == nums || 0 == nums.length) return 0;
        if (1 == nums.length) return max;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, 1);
        
        for (Integer key : map.keySet()) {
            int count = 1;
            // negative means the item has visited already
            if (map.get(key) >= 1) {
                int tmpKey = key;
                while (map.containsKey(tmpKey + 1) && map.get(tmpKey + 1) >= 1) {
                    tmpKey ++;
                    // in case that [100,4,200,1,3,2,2,2], visit 3 fst, then <3, 2>, then visit 2 <2, 1 + 3>
                    count += map.get(tmpKey);
                    map.put(tmpKey, 0);
                }
                // in case that [100,4,200,1,3,2,2,2] , visit 3 fst, then <3, 2>, then visit 2 <2, 1 + 3>
                map.put(key, count);
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
