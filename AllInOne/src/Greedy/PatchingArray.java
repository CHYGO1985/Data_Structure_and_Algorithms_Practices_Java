
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
		int cnt = 0;
		for (int i = 0; max < n;) {
			if (i >= nums.length || max < nums[i] - 1) {
				// here is the greedy part, use max to cover the range (max + 1 will be the missing value)
				// e.g. 1 n = 3, then missing is 2, max = 1 + 2(1+ 1)
				max += max + 1;
				cnt++;
			} else {
				max += nums[i]; // add the value that the array has to the max
				i++;
			}
		}
		return cnt;
    }

	public static void main(String[] args) {
		int[] nums = new int[]{1};
		System.out.println(minPatches(nums, 3));
	}

}
