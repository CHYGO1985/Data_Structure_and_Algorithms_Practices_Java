package Greedy;

/**
 * 
 * @author jingjiejiang created on Sep 5, 2018
 * @ref: https://leetcode.com/problems/gas-station/discuss/164669/Java-Clean-O(n)-and-constant-space-solution-beats-100
 */
public class GasStation {

	// from brutal force to O(n) solution
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		
        int count = 0;
        int pos = 0;
        int sum = 0;
        
        for (int i = 0; i < gas.length; i ++) {
        	count += gas[i] - cost[i]; // temporary sum
        	sum += gas[i] - cost[i];
        	
        	if (count < 0) {
        		count = 0;
        		pos = (i + 1) % gas.length;
        	}
        }
        
        return sum >= 0? pos : -1;
    }

	public static void main(String[] args) {
		
		int[] gas = new int[]{1,2,3,4,5};
		int[] cost = new int[]{3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
