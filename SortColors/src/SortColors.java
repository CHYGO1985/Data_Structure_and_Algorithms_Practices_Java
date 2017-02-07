
public class SortColors {
	
    public static void sortColors(int[] nums) {
        // idea: method 1: two loop (one: count 0, 1, 2; two: rewrite the array according to the count results)
        
        // method 2: one pass, two pointers technique (plus a new pointer)
        // two pinters iterate through, swap when necessary (principle: swap 0 to left, 2 to right)
        // 1) pairs (0, 0), (0 , 1), (0, 2), (1, 0), (1, 2), (2, 0), (2, 1), (2, 2) is easy to handle
        // 2) pairs (1, 1) is a bit of trouble
        // a. generate a new pointer (temp) start from left to right
        // b. if meet 0m swap (left, temp); meet 2, swap (temp, right); meet 1, swap ()
        // result: 1ms, beat 5%. not exact one pass, as the temp travel in between.
        /*
        if (null == nums || 0 == nums.length || 1 == nums.length) {
            return ;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            
            // left is 0, then ++, else stop
            while (0 == nums[start] && start < end) {
                start ++;
            } 
            
            // right is 2, then --. else stop
            while (2 == nums[end] && start < end) {
                end --;
            }
            
            if (1 == nums[start] && 1 == nums[end]) {
                int temp = start + 1;
                
                while (temp < end) {
                    // temp travel from left to right, so left is not simply ++
                    if (0 == nums[temp]) {
                        swap(nums, start, temp);
                        start ++;
                        break;
                    }
                    else if (2 == nums[temp]) {
                        swap(nums, temp, end);
                        end --;
                        break;
                    }
                    else {
                        temp ++;
                    }
                }
                
                // *** did not add the condition
                if (temp >= end) {
                	return;
                }
            }
            else {
                swap(nums, start, end);
                if (0 == nums[start]) {
                    start ++;
                }
                
                if (2 == nums[end]) {
                    end --;
                }
            } 
        }
        */
        
        // method 3: The one pass solution is hiding from my method 2 (similar with hanlde 1,1)
        // a. generate a new pointer (temp) start from left to right
        // b. if meet 0m swap (left, temp), left ++; meet 2, swap (temp, right), end --;
        if (null == nums || 0 == nums.length || 1 == nums.length) {
            return ;
        }
        
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end; i ++) {
            while (2 == nums[i] && i < end) {
                swap(nums, i, end);
                end --;
            }
            
            while (0 == nums[i] && i > start) {
                swap(nums, start, i);
                start ++;
            }
        }
    }
	
	private static void swap(int[] nums, int a, int b) {
        
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] nums = {1,1,0,0,1,1};
	    sortColors(nums);
	}

}
