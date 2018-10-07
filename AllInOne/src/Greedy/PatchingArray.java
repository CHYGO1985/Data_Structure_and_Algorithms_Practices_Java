package Greedy;

/**
 * 
 * https://leetcode.com/problems/patching-array/discuss/78490/Share-my-greedy-solution-by-Java-with-simple-explanation-(time:-1-ms)
 * 
 * @author jingjiejiang created on Sep 24, 20170
 *
 */
public class PatchingArray {
	
	public static int minPatches(int[] nums, int n) {
		
		long max = 0;
		int cnt = 0, idx = 0;
		while (max < n) {
			if (idx >= nums.length || max < nums[idx] - 1) {
				// here is the greedy part, use max to cover the range (max + 1 will be the missing value)
				// e.g. 1 n = 3, then missing is 2, max = 1 + 2(1+ 1)
				
				// if the gap is large, num[] = 1, 10, n 20, then it will iterate multi times to get 10
				// 1 --> 3 (1 + (1 + 1)) --> 7 (3 + (3 + 1)) --> 4
				max += max + 1; // patch for next num of the max
				cnt ++;
			}
			else {
				max += nums[idx ++];
			}
		}
		
		return cnt;
    }

	public static void main(String[] args) {
		int[] nums = new int[]{1, 10};
		System.out.println(minPatches(nums, 20));
	}

}
