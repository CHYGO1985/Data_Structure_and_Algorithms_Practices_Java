package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 26, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int minPatches(int[] nums, int n) {
        // sum = 0, cnt = 0;
		// for (i --> len && sum < n)
		// int limit = idx < len ? min([i], n) : n;
		// while (sum < limit)
		// { sum += sum + 1; cnt ++}
		// sum += [i]
		if (nums == null) return 0;
		
		long sum = 0;
        int cnt = 0;
		for (int idx = 0; idx < nums.length || sum < n; idx ++) {
			long limit = (idx < nums.length) ? Math.min(nums[idx] - 1, n) : n;
			while (sum < limit) {
				sum += sum + 1;
				cnt ++;
			}
			sum += nums[idx];
		}
        
		return cnt;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3};
	}
}
