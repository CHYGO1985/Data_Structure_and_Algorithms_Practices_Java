/**
 * 
 * 287. Find the Duplicate Number
 * 
 * round 1: O(nlogn) solved, O(n) unsolved
 * explaination: https://www.hrwhisper.me/leetcode-find-the-duplicate-number/
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 28, 2017
 */
public class FindTheDuplicateNumber {
	
	public static int findDuplicate3(int[] nums)
	{
		if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            //let slow and fast meet in a cycle
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            
            fast = 0;
            // find the entry point
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
	}

	public static void main(String[] args) {
		findDuplicate3(new int[]{2,5,9,6,9,3,8,9,7,1});

	}

}
