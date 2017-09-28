/**
 * 
 * 81. Search in Rotated Sorted Array II
 * 
 * round 1: solved, 2 hours, 4 attemps.
 * 
 * idea: 
 * 1. first, analysis non repeat situation, draw 5 nums
 *    L   M   R
 * 1) 1 2 3 4 5
 * 2) 2 3 4 5 1
 * 3) 3 4 5 1 2
 * 4) 4 5 1 2 3
 * 5) 5 1 2 3 4
 * 
 * I check all the cases of there are two large cate: relation between L M R and
 * tar with nums[L/M/R], i first try to categories them with tar with nums[L/M/R]
 * with consideration of relation between L M R. Found very complicated
 * 
 * 2. So I try to categories the relation between L M R, then sub categories each
 * with the relation between tar and nums[L/M/R]
 * 
 * we can get 3 categories for relation between L M R
 * 1) L < M < R
 * 2) R < L < M (2, 3)
 * 3) M < R < L (4, 5)
 * 
 * for R < L < M :
 * only fixed range is that when L < tar < M, we search (L, M -1)
 * other wise (M + 1, R)
 * 
 * for M < R < L
 * only fix range is when M < tar < R, we search (M + 1, R)
 * then we get (L, R - 1) 
 * 
 * 3. we then consider the repeated eles
 * draw nums with duplicates, we find that we only need to
 * consider one extra case : L == R
 * if tar != L/R, we search (L + 1. R -1)
 * 
 * *** test case:
 * the fist condition in recursive method :
 * // if (front < 0 || rear >= nums.length) return false;
 * 1. I did not considered case like: [1], 0
 * which will cause rear < 0 (or other case: front >= nums.length)
 * 2. I did not considered case like: front > rear
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 28, 2017
 */
public class SearchInRotatedSortedArrayII {
	
	// test case [1], 0
    // [3,1,2,2,2] 1, did not condier mid == front || mid == right
    public boolean search(int[] nums, int target) {
        
        if (null == nums || 0 == nums.length) return false;
        
        return biSearch(nums, 0, nums.length - 1, target);
    }
    
    private boolean biSearch(int[] nums, int front, int rear, int target) {
        // *** did not consider that front can be >= nums.length, or rear < 0,
        // [1], 0 -> rear < 0
        // *** stackoverflow error: unended recursive method, did not add front > rear
    	// if (front < 0 || rear >= nums.length) return false;
        if (front < 0 || front >= nums.length || rear < 0 
        		|| rear >= nums.length || front > rear) return false; 
        
        int mid = (front + rear) / 2;
        if (target == nums[mid] || target == nums[front] 
                || target == nums[rear])  return true;
        
        if (nums[front] == nums[rear]) {
            return biSearch(nums, front + 1, rear - 1, target);
        }
        else if (nums[front] <= nums[mid] && nums[mid] <= nums[rear]) {
            if (target > nums[mid])
                return biSearch(nums, mid + 1, rear, target);
            else
                return biSearch(nums, front, mid - 1, target);
        }
        else if (nums[rear] <= nums[front] && nums[front] <= nums[mid]) {
            if (target > nums[front] && target < nums[mid])
                return biSearch(nums, front, mid - 1, target);
            else
                return biSearch(nums, mid + 1, rear, target);
        }
        else if (nums[mid] <= nums[rear] && nums[rear] <= nums[front]) {
            if (target > nums[mid] && target < nums[rear]) 
            	// *** misplace tio put biSearch(nums, front, mid - 1, target); here
                return biSearch(nums, mid + 1, rear, target);
            else
                return biSearch(nums, front, mid - 1, target);
        }
        
        return false;
    }
}
