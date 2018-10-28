package Greedy;
/**
 * 
 * 376. Wiggle Subsequence
 * 
 * round 1: solved, 40m, 0ms, 1 time pass
 * 
 * idea: similar to "300. longest increasing subseq" problem. I first think
 * about using an array to record the ones that can fit the condition, and
 * replace those are not.
 * 
 * coz a partially valid wiggle subseq can be part of the whole wiggle subseq
 * so, i can ignore the previous elems, only focus on the lastest one of it.
 * 
 * If there is the lastest one X that not fit wiggle condition, we can simplely
 * use it as the lastest ele of the wiggle array (not increasing the length),
 * to compare with next ele. I spend some time to think about whether it is
 * work or not. 
 * My thought is if a one kepts increasing or decreasing, obviously, it 
 * increases the chance the the next one fist decreasing or increasing.
 * 
 * e.g. 1 2 3 2, 
 * 1) at index nums[2] = 3, it supposed to be < 2, but it kepts increasing
 * 2) we simply replace 2 with 3 to check next 0ne, and now for 3, it works
 * for 1 and 2, and 2 only works for 1. 
 * 
 * 
 * @author jingjiejiang
 * @history 
 * 1. Sep 18, 2017
 * 2. Oct 13, 2018
 */
public class WiggleSubsequence {

	/*
	public int wiggleMaxLength(int[] nums) {
        
		// iterate through nums
		// record previous sign  1 or -1
		// record the longest length
		// record preNum for comparing
		// 1) for each current num: check cur sign * pre sign = -1
		// 2) y: longest len ++
		// 3) n: preNum = cur
		if (nums == null || nums.length == 0) return 0;
		
		int preSign = 0, preNum = nums[0], res = 1;
		for (int idx = 1; idx < nums.length; idx ++) {
			int curSign = nums[idx] - preNum;
			if (preSign == 0) {
				res += (curSign) != 0 ? 1 : 0;
			}
			else {
				if (preSign * curSign < 0) {
					res ++;
				}
			}
			preSign = curSign == 0 ? preSign : curSign;
			preNum = nums[idx];
		}
		
		return res;
    }
	*/
	
	public int wiggleMaxLength(int[] nums) {
		// if nums.len < 2, return nums.len
		// find the fst [i] - [i - 1] that does not == 0
        // cnt = pre == 0 ? 1: 2;
		// int curNum = [i];
		// for (i --> len) {
		// cur = [i] - [i - 1]
		// if (pre * cur < 0) {cnt ++, curNum = [i]}
		// else 
		// {if (pre > 0) curNum = max(cur, [i]) // 1 7 8
		// else (pre < 0) curNum = min(cur, [i])} // 3 2 1
		if (nums.length < 2) return nums.length;
		int idx = 1, cnt = 1;
		
		while (idx < nums.length && nums[idx] - nums[idx - 1] == 0) idx ++;
		if (idx == nums.length) return 1;
		
		int pre = nums[idx] - nums[idx - 1];
		cnt ++;

		for (idx ++; idx < nums.length; idx ++) {
			int cur = nums[idx] - nums[idx - 1];
			if (pre * cur < 0) {
				pre = cur;
				cnt ++;
			}
			// 1 7 8 or 3 2 1 or 3 2 2 curNum = [i]
		}
		
		return cnt;
    }
}
