package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Nov 9, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		long sum = 0, curSum = 0;
        int pos = 0;
        
        for (int idx = 0; idx < gas.length; idx ++) {
            int curLeft = gas[idx] - cost[idx];
            sum += curLeft;
            curSum += curLeft;
            if (curSum < 0) {
                pos = idx + 1;
                curSum = 0;
            }
        }
        
        return sum >= 0 ? pos : -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,2,2,1};
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
