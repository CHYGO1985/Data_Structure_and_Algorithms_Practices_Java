import java.util.Arrays;

/**
 * round 2: try O(n) method
 * 
 * round 1: 30m, solved, method 1 sort (34ms, beat 90.75&)
 * method 2: unsolved, value <-> index match method, 30m, O(n)
 * ref: https://discuss.leetcode.com/topic/88112/java-o-n-beats-100/2
 * 
 * The output is the sum of the index of the maximum sum of min(ai, bi) mean
 * explanation: https://discuss.leetcode.com/topic/87682/please-explain-the-question-doesn-t-make-sense/4
 * 
 * @author jingjiejiang
 * @Jun 4, 2017
 */ 
public class ArrayPartitionI {
	
	// Method 1: sort, O(nlogn)
	/*
	public int arrayPairSum(int[] nums) {
        
        int sum = 0;
        if (null == nums || 0 == nums.length) return sum;
        
        for (int i = 0; i < nums.length; i += 2) sum += nums[i];
        
        return sum;
    }
	*/
	
	// method 2: value <-> index match, O(n)
	public int arrayPairSum(int[] nums) {
        
        int sum = 0;
        if (null == nums || 0 == nums.length) return sum;
        
		int[] extend = new int[20001];
		for (int i = 0; i < nums.length; i ++) extend[nums[i] + 10000] ++;
		
		boolean isOutput = true;
		for (int i = 0; i < extend.length; i ++) {
		    while (extend[i] > 0) {
		        if (isOutput == true) sum += i - 10000;
		        isOutput = !isOutput;
		        extend[i] --;
		    }
		}
		
		return sum;
	}
}
