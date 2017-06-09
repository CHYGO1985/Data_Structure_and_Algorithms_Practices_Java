import java.util.HashMap;
import java.util.Map;

/**
 * round 1: O(n) unsolved, 4 hours (use the wrong match position, should find the same val not the matching val)
 * *** 
 * pre : 5  1 1 5 0
 *       23 2 6 4 7
 * cur : 5  2 0 0 1
 * find 5 and 5, then return true (I used 1 and 5, which cause it cannot detech multiple value, e.g. 2 1 1 2 for 6 )
 * when there is a repeat, means the interval % k == 0 or interval == 0 (when k = 0)
 * 
 * idea: optimise from brutal force
 * 1. brutal force: O(n^2), build sum array, from index = 2, check all index - i (i ++, until index - i == 0)
 * 2. from brutal force --> find remaind matching(hashtable), if there is remainder x + y == k, and interval >= 2, then 
 * return true
 * *** the importance is to check whether the mid subarray can find a match for k, and to avoid multiple times check of K,
 * the fast way is to check whether there is a remainder matching (from observation)
 * 
 * 1. *** test case: did not consider k = 0
 * 1) 0 0 : 0 : true
 * 2) 0 : 0 false
 * 
 * @author jingjiejiang
 * @history Jun 9, 2017
 */
public class ContinuousSubarraySum {
	
	public static boolean checkSubarraySum(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
	    int runningSum = 0;
	    for (int i=0;i<nums.length;i++) {
	        runningSum += nums[i];
	        if (k != 0) runningSum %= k; 
	        Integer prev = map.get(runningSum);
	        if (prev != null) {
	            if (i - prev > 1) return true;
	        }
	        else map.put(runningSum, i);
	    }
	    return false;
	}

	public static void main(String[] args) {
		// boolean res = checkSubarraySum(new int[]{23, 2, 6 ,4, 7}, 6);
		boolean res = checkSubarraySum(new int[]{5, 2, 1, 4, 7}, 6);
	}
}
