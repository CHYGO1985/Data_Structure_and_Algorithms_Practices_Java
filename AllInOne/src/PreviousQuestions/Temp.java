package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 13, 2018
 *
 */
public class Temp {
	
	// two substasks: record previious is pos or neg
	// replace max or min if  < < (replace max) or > > (replace min)
	public int wiggleMaxLength(int[] nums) {
        
		// iterate through nums
		// record previous sign  1 or -1
		// record the longest length
		// record preNum for comparing
		// 1) for each current num: check cur sign * pre sign = -1
		// 2) y: longest len ++
		// 3) n: preNum = cur
		if (nums == null || nums.length == 0) return 0;
		
		int preSign = 0, preNum = nums[0], res = 1;
		for (int idx = 1; idx < nums.length; idx ++) {
			int curSign = nums[idx] - preNum;
			if (preSign == 0) {
				res += (curSign) != 0 ? 1 : 0;
			}
			else if (preSign * curSign < 0) {
				res ++;
			}
			// *** missed curSing == 0
			preSign = curSign == 0 ? preSign : curSign;
			preNum = nums[idx];
		}
		
		return res;
    }
	
	public static void main(String[] args) {
	}
}
