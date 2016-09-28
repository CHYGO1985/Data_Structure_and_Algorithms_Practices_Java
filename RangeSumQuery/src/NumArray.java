
public class NumArray {
	
    private int[] nums;
    
    public NumArray(int[] nums) {
        
        for(int i = 1; i < nums.length; i++)
        nums[i] += nums[i - 1];
        
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        
        // *** ***I thought about accumulate the sums in the array, but could not go further
        // https://discuss.leetcode.com/topic/29194/java-simple-o-n-init-and-o-1-query-solution
        // result: 3ms
        if(i == 0)
        return nums[j];
    
        return nums[j] - nums[i - 1];
        
        // solution 1: *** I used straight forward method, but exceed time limit.
        // skip index < i, and return sum as soon as index >j, 
        // *** result: 102 ms. beat 2%, lowest: 2ms.
        /*
        int sum = 0;
        
        for (int index = i; index < nums.length; index ++) {
            
            if (index < i) {
                continue;
            }
            else if (index >= i && index <= j){
                sum += nums[index];
            }
            else {
                return sum;
            }
        }
        
        return sum;
        */
        
        // improve 1: it is an array, so should be able to go to i directly.
        // *** result: 197 ms
        /*
        int sum = 0;
        
        if ( i < 0 || j > nums.length)
            return 0;
        
        for (int index = i; index <= j; index ++) {
            
            sum += nums[index];
          
        }
        
        return sum;
        */
        
    }

}
