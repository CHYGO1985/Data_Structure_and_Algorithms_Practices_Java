import java.util.Arrays;

/**
 * round 1: solved, 1 hour, two pointers tech, O(n^2), 22ms, beat 72% 
 * 
 *   1    3   5    6   9 : target 8
 * begin              end
 * 
 * 1) 1+ 9 > 8, end --, dis = 2
 * 2) 1 + 6 < 8, begin ++, dis =1
 * 3) 3 + 6 = 9, end --, dis = 1
 * 4) 3 + 5 = 8, dis = 0;
 * 
 * @author jingjiejiang
 * @history Jun 14, 2017
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
        
        if (null == nums || nums.length < 3) throw new AssertionError();
        
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i ++) {
            
            int rest = target - nums[i];
            int begin = i + 1;
            int end = nums.length - 1;
            // *** the following logic is wrong for : -6 -4 -1 0 : -10, it can get -10, the logic will return -11
            /*
            if (rest <= nums[begin]) {
                int tmp = Math.abs(nums[begin] + nums[begin + 1] - rest);
                if (tmp < distance) {
                    distance = tmp;
                    sum = nums[i] + nums[begin] + nums[begin + 1]; 
                }
                continue;
            }
            */
            
            while (begin < end) {
                int tmp = Math.abs(nums[begin] + nums[end] - rest);
                if (tmp < distance) {
                    distance = tmp;
                    sum = nums[i] + nums[begin] + nums[end]; 
                }
                
                if (nums[begin] + nums[end] < rest) begin ++;
                else if (nums[begin] + nums[end] > rest) end --;
                // nums[begin] + nums[end] == rest
                else return target;
            }
        }
        
        return sum;
    }
}
