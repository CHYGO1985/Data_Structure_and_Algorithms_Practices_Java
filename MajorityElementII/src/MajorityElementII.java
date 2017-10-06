import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 229. Majority Element II
 * 
 * round 1: unsolved, do not know boyer moore voting algorithm
 * ref: https://discuss.leetcode.com/topic/29390/concise-java-solution-based-on-moore-s-voting-algorithm
 * 
 * idea: use the feature the if an ele is the majority, then the num of it will exceed others
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 6, 2017
 */
public class MajorityElementII {

public List<Integer> majorityElement(int[] nums) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums.length==0) return res;
        
        int count[] = new int[2];        
        int x[] = new int[2];       
   
        x[0] = 0; x[1] = 1;        
        for (int i = 0; i < nums.length; i++) {
        	if (x[0] == nums[i])
        		count[0]++;
        	else if (x[1] == nums[i])
        		count[1]++;
        	else if (count[0] == 0) {
        		x[0] = nums[i];
        		count[0] = 1;
        	} else if (count[1] == 0) {
        		x[1] = nums[i];
        		count[1] = 1;
        	} else {
        		count[0]--;
        		count[1]--;        		
        	}
        }
        
        Arrays.fill(count, 0);
        for (int i : nums) {// Count again for x1, x2
            if (i == x[0]) count[0]++;
            else if (i == x[1]) count[1]++;
        }
        for (int j = 0; j < 2; j++) {
            if (count[j] > nums.length/3 && !res.contains(x[j])) res.add(x[j]);
        }        
        return res;
    }
}
