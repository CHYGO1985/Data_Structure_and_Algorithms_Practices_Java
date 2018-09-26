package PreviousQuestions;

public class Temp {

	public static int jump(int[] nums) {
		
		if (nums == null || nums.length == 0) return 0;
		
		int count = 0, curEnd = 0, curMax = 0;
		for (int i = 0; i < nums.length; i ++) {
			curEnd = Math.max(curMax, i + nums[i]);
			if (i == curEnd) {
				curEnd = curMax;
				count ++;
			}
		}
			
		return count;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1};
		System.out.println(jump(nums));
	}

}
