package PreviousQuestions;

public class Temp {

	// 0 for sell and 1 for buy
	public static boolean canJump(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return true;
		}
		
		int max = nums[0];
		for (int i = 1; i < nums.length - 1; i ++) {
			max = Math.max(max, i + nums[i]);
		}
		
		return max >= nums.length ? true : false; 
    }
	
	public static void main(String[] args) {
//		System.out.println(1 << 1);
//		System.out.println(new Random().nextInt(32));
	}

}
