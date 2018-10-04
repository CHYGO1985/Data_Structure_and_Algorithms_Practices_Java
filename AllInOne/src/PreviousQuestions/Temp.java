package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 2nd, 2018
 *
 */
public class Temp {
	
	// A B C
	// if (B - A) * (C - B) < 0, continue
	// else if < <, then get max(B, C) = C
	// else > >, then get min (B, C) = C
	public int wiggleMaxLength(int[] nums) {
		
		if (null == nums || 0 == nums.length) return 0;
		if (nums.length <= 2) return nums.length;
		
		int sum = 2, start = nums[0], mid = nums[1];
		
		for (int idx = 2; idx < nums.length; idx ++) {
			int left = mid - start, right = nums[idx] - mid;
			if (left * right < 0) {
				sum ++;
				start = mid;
			}
			mid = nums[idx];
		}
		
		return sum;
    }
	
	public static void main(String[] args) {
		
	}
}
