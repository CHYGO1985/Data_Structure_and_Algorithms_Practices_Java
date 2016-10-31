
public class MissingNumber {
	
	public static int missingNumber(int[] nums) {
        // unsolved: I could not understand the quesion. The thing is that the array can be [0] ,[1], or [0, 1]
        // special case: [0] / [1]
        //
        /*
        int miss = 1;
        
        for (int i = 1; i < nums.length; i ++) {
            if ( (nums[i] - nums[i - 1]) != 1 ) {
                miss = nums[i - 1] + 1;
                break;
            }
        }
        
        if (1 == nums.length && 1 == nums[0]) {
            return 0;
        }
        return miss;
        */
        
        // method 1: https://discuss.leetcode.com/topic/37594/java-solution-time-o-n-space-o-1-no-xor-no-gauss-math-method
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i] - i;
        return nums.length - sum;
        
        // method 2: http://www.cnblogs.com/grandyang/p/4756677.html (arithmetic progression)
        /*
        int sum = 0, n = nums.size();
        for (auto &a : nums) {
            sum += a;
        }
        return 0.5 * n * (n + 1) - sum;
        */
        
        // method 3: bit manipulation http://www.cnblogs.com/grandyang/p/4756677.html
        /*
        int res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;        
        */
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
