package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 5, 2018
 *
 */
public class Temp {
	
	// iterate through, for each step nextRange = max(i + nums[i], curRange);
	// at pos = 0, 
	// if (i == curRange), then curRange = nextRange, cnt ++;
	// until i <= nums.length - 1
	public int jump(int[] nums) {
		
		if (nums == null) return 0;
		
		int curRange = 0, nextRange = 0, count = 0;
		for (int idx = 0; idx < nums.length - 1; idx ++) {
			nextRange = Math.max(nextRange, idx + nums[idx]);
			if (idx == curRange) {
				count ++;
				curRange = nextRange;
			}
		}
		
        return count;
    }
}
