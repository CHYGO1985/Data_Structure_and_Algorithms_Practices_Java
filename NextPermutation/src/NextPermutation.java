/***
 * round 1: solved, two flags + two pointers tech(for reverse), 1 hour, 17ms, beat 97.4%
 *  
 * prepare a long test case to observe
 * [1,6,9,8,7,6,5,4,3]
 * 
 * idea: two flags (maxPos and minPos) 
 * 1.from end to begin, to locate the position where ascending interrupt at pos A
 * [1,  6,  9,  8,  7,  6,  5,  4,  3]
 *      A  max      *               min
 * 2.swap A with ele with[max...min] the fist ele that > A, in the example is 7
 * [1,  7,  9,  8,  6,  6,  5,  4,  3]
 *      A  max      *               min
 * 
 * 3.(two pointers tech)revese [max .. nums.length - 1]
 *  
 * @author jingjiejiang
 * @history Jun 17, 2017
 */
public class NextPermutation {

	public void nextPermutation(int[] nums) {
        
        if (null == nums || nums.length <= 1) return ;
        int maxPos = nums.length - 1, minPos = nums.length - 1, shift = nums.length - 2;
        
        while (shift >= 0) {
            if (nums[shift] >= nums[maxPos]) maxPos = shift --;
            // nums[shift] < maxPos
            else {
                // *** shoud use >= not >, [1,5,1], it does not make sense to swap 1 and 1
                while (nums[shift] >= nums[minPos]) minPos --;
                swap(nums, shift, minPos);
                break;
            }
        }
        int end = nums.length - 1;
        while (maxPos < end) swap(nums, maxPos ++, end --);
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}
