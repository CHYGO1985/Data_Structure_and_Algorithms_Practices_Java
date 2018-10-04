package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 4, 2018
 *
 */
public class Temp {
	
	// iterate through, find if sum of gas >= cost 
	// and find the last pos that cur sum of gas > cur sum of cost
//	public int canCompleteCircuit(int[] gas, int[] cost) {
//        
//		int pos = -1, sumGas = 0, sumCost = 0, curGasSum = 0, curCostSum = 0;
//		for (int idx = 0; idx < gas.length; idx ++) {
//			sumGas += gas[idx];
//			sumCost += cost[idx];
//            curGasSum += gas[idx];
//            curCostSum += cost[idx];
//            
//			if (gas[idx] >= cost[idx] && pos == -1) {
//				curGasSum = gas[idx]; 
//				curCostSum = cost[idx];
//				pos = idx;
//			}
//			
//			if (curGasSum < curCostSum) pos = -1;
//			
//		}
//		
//		return sumGas >= sumCost ? pos : -1;
//	}
	
	//optimise
	public int canCompleteCircuit(int[] gas, int[] cost) {
  
		int pos = -1, sum = 0, tmpSum = 0;
		for (int idx = 0; idx < gas.length; idx ++) {
			sum += gas[idx] - cost[idx];
			tmpSum += gas[idx] - cost[idx];
      
		if (gas[idx] >= cost[idx] && pos == -1) {
			tmpSum = gas[idx] - cost[idx];
			pos = idx;
		}
		
		if (tmpSum < 0) pos = -1;
		
	}
	
	return sum >= 0 ? pos : -1;
}
	
	public static void main(String[] args) {
		
	}
}
