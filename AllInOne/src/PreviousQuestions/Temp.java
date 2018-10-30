package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 30, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int idx = 0; idx < nums.length - 1; idx ++) {
            if (idx <= farthest) {
                farthest = Math.max(farthest, idx + nums[idx]);
            }
        }
        return farthest < nums.length - 1 ? false : true;     
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3};
	}
}
