package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Nov 12, 2018
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
		long sum = 0;
        int cnt = 0;
        
        for (int idx = 0; idx < nums.length || sum < n; idx ++) {
        	int limit = idx < nums.length ? nums[idx] - 1 : n; 
				
            while (sum < limit && sum < n) {
                sum += sum + 1;
                cnt ++;
            }
        
            if (idx < nums.length) sum += nums[idx];
        }
        
        return cnt;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,2,2,1};
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
