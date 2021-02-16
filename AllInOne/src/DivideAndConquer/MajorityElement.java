/**
 * 
 * 169. Majority Element
 * 
 * @author jingjiejiang
 * @history Feb 6, 2021
 * 
 */
class Solution {
    // Boyer-Moore Voting Algorithm
    public int majorityElement1(int[] nums) {
        
        int cnt = 1, num = nums[0];

        for (int idx = 1; idx < nums.length; idx ++) {

            if (nums[idx] == num) {
                cnt ++;
                continue;
            }

            // nums[idx] != num
            if (cnt > 0) {
                cnt --;
            } else {
                num = nums[idx];
                cnt = 1;
            }
        }

        return num;
    }

    // divide and conquer
    public int majorityElement2(int[] nums) {
        
        return getMajElem(nums, 0, nums.length - 1);
    }

    private int getMajElem(int[] nums, int start, int end) {

        if (start == end) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;
        int left = getMajElem(nums, start, mid);
        int right = getMajElem(nums, mid + 1, end);

        if (left == right) {
            return left;
        }

        int leftCnt = getNumCntInRange(nums, left, start, end);
        int rightCnt = getNumCntInRange(nums, right, start, end);

        return leftCnt > rightCnt? left : right;
    }

    private int getNumCntInRange(int[] nums, int target, int start, int end) {

        int cnt = 0;
        for (int idx = start; idx <= end; idx ++) {
            if (nums[idx] == target) cnt ++;
        }

        return cnt;
    }
}