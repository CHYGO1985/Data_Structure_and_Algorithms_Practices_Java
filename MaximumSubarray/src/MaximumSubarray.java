
public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
        // method 1: dp (check current sum very step)
        // ref: http://bangbingsyb.blogspot.com/2014/11/leetcode-maximum-subarray.html
        // result: 17ms, beat 33%, fastest is 14ms
        /*
        if (null == nums || 0 == nums.length) {
            return Integer.MIN_VALUE;
        }
        
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            curSum = ( curSum <= 0 ? nums[i] : curSum + nums[i]);
            max = Math.max(max, curSum);
        }
        
        return max;
        */
        
        if (null == nums || 0 == nums.length) {
            return Integer.MIN_VALUE;
        }
        
        return divide(nums, 0, nums.length - 1);
        
    }
    
    // method 2: divide and conquer
    // ref: http://www.cnblogs.com/springfor/p/3877058.html
    // ref: http://fisherlei.blogspot.com/2012/12/leetcode-maximum-subarray.html
    public int divide(int[] nums, int low, int high) {
        
        if (low == high) {
            return nums[low];
        }
        
        if (low == high - 1) {
            return Math.max(nums[low] + nums[high], Math.max(nums[low], nums[high]));
        }
        
        int mid = (low + high) / 2;
        int leftMax = divide(nums, low, mid - 1);
        int rightMax = divide(nums, mid + 1, high);
        
        int sum = nums[mid];
        int temp = sum;
        for (int i = mid - 1; i >= 0; i --){
            temp += nums[i];
            if (temp > sum) {
                sum = temp;
            }
        }
        
        temp = sum;
        for (int i = mid + 1; i <= high; i ++) {
            temp += nums[i];
            if (temp > sum) {
                sum = temp;
            }
        }
        
        return Math.max(sum, Math.max(leftMax, rightMax));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
