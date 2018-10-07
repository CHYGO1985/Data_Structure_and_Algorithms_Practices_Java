package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 7, 2018
 *
 */
public class Temp {
	
	public int minPatches(int[] nums, int n) {
		
		long max = 0;
		int cnt = 0, idx = 0;
		while (max < n) {
			if (idx >= nums.length || max < nums[idx] - 1) {
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
		
	}
}
