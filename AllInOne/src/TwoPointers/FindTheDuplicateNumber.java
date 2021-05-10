/**
 * 
 * 287. Find the Duplicate Number
 * 
 * @author jingjiejiang
 * @history May 6, 2021
 * 
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {

        assert nums != null && nums.length >= 1;

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {

            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

