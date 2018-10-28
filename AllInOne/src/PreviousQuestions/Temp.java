package PreviousQuestions;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * 
 * @author jingjiejiang Oct 28, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
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
		int curNum = nums[idx];
		cnt ++;
		idx ++;
		
		for (; idx < nums.length; idx ++) {
			int cur = nums[idx] - nums[idx - 1];
			if (pre * cur < 0) {
				pre = cur;
				curNum = nums[idx];
				cnt ++;
			}
			else {
				if (pre > 0) {
					// 1 7 8
					curNum = Math.max(curNum, nums[idx]); 
				}
				else {
					// 3 2 1 or 3 2 2
					curNum = Math.min(curNum, nums[idx]);
				}
			}
		}
		
		return cnt;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3};
	}
}
