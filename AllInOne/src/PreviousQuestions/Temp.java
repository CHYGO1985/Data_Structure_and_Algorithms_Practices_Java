package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Nov 8, 2018
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
	    
		if (nums.length <= 1) return nums.length;
		
		int idx = 1;
		// skip equal nums 1 1 1 2
		while (nums[idx] == nums[idx - 1]) {
            idx ++;
            // *** commit error here
            if (idx >= nums.length) return 1;
        }
		int preSign = nums[idx] - nums[idx - 1];
		int cnt = preSign == 0 ? 1 : 2;
		
		for (idx += 1; idx < nums.length; idx ++) {
			int curSign = nums[idx] - nums[idx - 1];
			if (curSign * preSign < 0) {
				preSign = curSign;
				cnt ++;
			}
		}
		
		return cnt;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,2,2,1};
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
