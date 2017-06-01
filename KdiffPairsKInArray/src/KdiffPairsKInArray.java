import java.util.HashSet;
import java.util.Set;

/**
 * round 2: try only one map solution
 * round 1: HashTable. Two sets(finding match with pos infor), 1 hour, 45ms, beat 20%
 * refactoring 10 minutes, less than 10 lines, 43ms, beat 22%
 * test case: [1, 3, 1, 5, 4,1,1] 0 -> 1
 * [-1,0,0,1,0,0,-1] 1 --> 2
 * *** two pointers: https://discuss.leetcode.com/topic/81745/two-pointer-approach/2
 * *** only one map to solve the problem : 
 * ref: https://discuss.leetcode.com/topic/81714/java-o-n-solution-one-hashmap-easy-to-understand
 * 
 * @author jingjiejiang
 * @history Jun 2, 2017
 */
public class KdiffPairsKInArray {

	// method 1: used hashmap + set
	/*
	public int findPairs(int[] nums, int k) {
        
        int count = 0;
        if (null == nums || 0 == nums.length || k < 0) return count;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < nums.length; i ++) {
            
            if (map.containsKey(nums[i] - k) == true && map.get(nums[i] - k) != nums[i]) {
                //map.put(nums[i], nums[i] - k);
                if (set.add("" + Math.max(nums[i] - k, nums[i]) + "#" + 
                    Math.min(nums[i] - k, nums[i])) == true) {
                    count ++;
                    map.put(nums[i] - k, nums[i]);
                }
            }
            
            if (map.containsKey(nums[i] + k) == true && map.get(nums[i] + k) != nums[i]) {
                //map.put(nums[i], nums[i] + k);
                if (set.add("" + Math.max(nums[i] + k, nums[i]) + "#" + Math.min(nums[i] + k, nums[i])) == true) {
                    map.put(nums[i] + k, nums[i]);
                    count ++;
                }
            }
            
            if (map.containsKey(nums[i]) == false) map.put(nums[i], Integer.MIN_VALUE);
        }
        
        return count;
    }
    */
	
	public int findPairs(int[] nums, int k) {
        
        if (null == nums || 0 == nums.length || k < 0) return 0;
        Set<Integer> numSet = new HashSet<Integer>();
        Set<String> parisSet = new HashSet<String>();
        for (int i = 0; i < nums.length; i ++) {
            if (numSet.contains(nums[i] - k) == true)
                //map.put(nums[i], nums[i] - k);
                parisSet.add("" + Math.max(nums[i] - k, nums[i]) + "#" + Math.min(nums[i] - k, nums[i]));
            
            if (numSet.contains(nums[i] + k) == true)
                //map.put(nums[i], nums[i] + k);
                parisSet.add("" + Math.max(nums[i] + k, nums[i]) + "#" + Math.min(nums[i] + k, nums[i]));
            numSet.add(nums[i]);
        }
        
        return parisSet.size();
    }
}
