package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Nov 7, 2018
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
		int cnt = 0;
        long sum = 0;
        for (int num : nums) {
            while (sum < num - 1 && sum < n) {
                sum += sum + 1;
                cnt ++;
            }
            
            sum += num;
        }
        
        while (sum < n) {
            sum += sum + 1;
            cnt ++;
        }
        
        return cnt;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,2,2,1};
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
