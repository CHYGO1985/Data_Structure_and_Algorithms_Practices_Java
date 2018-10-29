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
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// int sum = 0, pos = 0, totalSum = 0;
		// for (i --> len)
		//   sum += gas[i] - cost[i];
		//   totalSum += sum;
		//   if (sum < 0) {pos = i + 1; sum = 0;}
		// return totalSum < 0 ? - 1 : pos;
		long totalSum = 0; 
		int curSum = 0, pos = 0;
		for (int idx = 0; idx < cost.length; idx ++) {
			curSum += gas[idx] - cost[idx];
			totalSum += curSum;
			if (curSum < 0) {
				pos = idx + 1;
				curSum = 0;
			}
		}
        return totalSum < 0 ? -1 : pos;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3};
	}
}
