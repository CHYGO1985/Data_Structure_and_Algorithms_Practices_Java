package Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jingjiejiang created on Sep 13, 2018
 * ref: https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/106496/Java-O(n)-Time-O(n)-Space
 *
 */
public class SplitArrayIntoConsecSubseq {
	
	// appendfreq:  it means the tail of a consecutive subsequence or the value we can add to the previous consecutive subsequence.
	// for example: we have [1 2 3 3 4 4 5], 1 2 3 can be the one subsequence which has minimum length of 3, we start with the 
	// first element which is 1. the subsequence can be [1 2 3] and longer (which will be determined later). we reduce the 
	// frequency in the freq map and add 4 to the map2 (appendfreq). so it means, 4 can be a candidate if we want to make 
	// the previous subsequence(s) longer.
	public static boolean isPossible(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
	    for (int i : nums) freq.put(i, freq.getOrDefault(i,0) + 1);
	    for (int i : nums) {
	        if (freq.get(i) == 0) continue;
	        // this is for the appending nums
	        else if (appendfreq.getOrDefault(i,0) > 0) {
	            appendfreq.put(i, appendfreq.get(i) - 1);
	            appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0) + 1);
	        }   
	        else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
	            freq.put(i+1, freq.get(i+1) - 1);
	            freq.put(i+2, freq.get(i+2) - 1);
	            appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
	        }
	        else return false;
	        freq.put(i, freq.get(i) - 1);
	    }
	    return true;
    }

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,3,4,4,5,5};
		System.out.println(isPossible(nums));
	}    
}
