package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 13, 2018
 *
 */
public class Temp {
	
	// use an array to record previous max for each num
	// iterate through, for each num of N, check 3 to num, get the max max = max(max. dp[num])
	public int canCompleteCircuit(int[] gas, int[] cost) {
        
	   int pos = -1;  
	   long preSum = 0;
	   for (int idx = 0; idx < gas.length; idx ++) {
		   int curLeft = gas[idx] - cost[idx];
		   
		   //do nothing if preSum + curLeft >= 0
		   if (pos >= 0) {
			   preSum += curLeft;
			   if (preSum < 0) {
				   pos = -1;
				   preSum = 0;
			   }
		   }
		   else {
			   if (curLeft >= 0) {
				   preSum = curLeft;
				   pos = idx;
			   }
		   }
	   }
	   
	   return pos;
    }
	
	public static void main(String[] args) {
	}
}
