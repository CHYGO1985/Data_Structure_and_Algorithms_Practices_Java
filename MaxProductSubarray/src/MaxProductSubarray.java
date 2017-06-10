
/**
 * round 2: try method 2: 
 * 
 * round 1: solved 2 hours, O(n) solution, 3ms (36.47%), beat 56.52%
 * idea: from brutal force, it can be observe that
 * Method 1: 1.sepereate the array if there is 0，and record the max when building multiplicity array
 * 2. for each seperate array, if the last one < 0, find the first negative sum, check which one is larger, save it
 * 
 * - 1  2  3  2   4
 *  -1 -2 -6 -12 -48
 * -48 / -1 = 48
 * 
 * Test case: 0 and negative nums 
 * [-2]
 * [-1,2,3,-2,4]
 * []
 * [2,3,0,3,0,3,4,0,5]
 * [0,0,0,0]
 * 
 * method 2: flag method(flag swapping) O(n) time complexity and O(1) space complexity
 * ref: https://discuss.leetcode.com/topic/4417/possibly-simplest-solution-with-o-n-time-complexity
 * 
 * @author jingjiejiang
 * @history Jun 10, 2017
 */
public class MaxProductSubarray {

	 // method 1:
	 /*
	 public int maxProduct(int[] nums) {
     
        if (null == nums || 0 == nums.length) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] sum = new int[nums.length];
        List<Integer> list = new LinkedList<>();
        // for case that have only one ele in nums, so assgin nums[0]
        int max = nums[0];
        sum[0] = nums[0];
        int start = nums[0] != 0 ? 0 : 1;
        
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == 0) list.add(i);
            
            int ele = sum[i - 1] == 0 ? 1 : sum[i - 1]; 
            sum[i] = nums[i] * ele;
            // for case -4,-3,-2, divide in the mid
            max = Math.max(sum[i], max);
        }
        
        if (list.size() > 0) {
            for (int pos : list) {
                max = Math.max(max, getMax(sum, nums, start, pos - 1));
                start = pos + 1;
            }
            // for case: only one 0 [1,0,-1,2,3,-5,-2]
            if (start < nums.length) max = Math.max(max, getMax(sum, nums, start, nums.length - 1));
                
        }
        else max = Math.max(max, getMax(sum, nums, 0, sum.length - 1));
        
        return max;
    }
    
    // I have divided nums, to make sure the ele before pos will not have 0
    private int getMax(int[] sum, int[] nums, int start, int end) {
        // if there is only one ele from start to pos, then should not return sum[pos] / sum[i]
        // for case sum[pos] == 0 for case: [0, 0] ;
        if (sum[end] >= 0 || start == end) return sum[end];
        
        int i = start;
        for (; i <= end; i ++) if (nums[i] < 0) break;
        
        if (i > 0) return Math.max(sum[end] / sum[i], sum[i - 1]);
        // for case -1, 3, 4 (i == 0) 
        else return sum[end] / sum[i];
    }
	*/
	
	// method 2: flag swapping
	public int maxProduct(int[] nums) {
	     
        // store the result that is the max we have found so far
        int r = nums[0];
    
        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
    
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
    
            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }
}
