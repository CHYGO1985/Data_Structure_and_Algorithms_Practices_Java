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
	
	public int jump(int[] nums) {
        long curEnd = 0, curFarthest = 0;
		int cnt = 0;
		for (int idx = 0; idx < nums.length - 1; idx ++) {
			curFarthest = Math.max(curFarthest, idx + nums[idx]);
			if (idx == curEnd) {
				curEnd = curFarthest;
				cnt ++;
			}
		}
		
		return cnt;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3};
	}
}
