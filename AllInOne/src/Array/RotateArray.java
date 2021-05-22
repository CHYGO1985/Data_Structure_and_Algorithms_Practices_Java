package Array;

/**
 * 
 * 189. Rotate Array
 * 
 * author jingjiejiang Feb 26, 2019
 * @history Oct 16, 2020
 *
 * ref: https://leetcode.com/problems/rotate-array/solution/ 
 * 
 */
public class RotateArray {
	// public void rotate(int[] nums, int k) {
        
	// 	if (nums == null || nums.length == 0) return ;
	// 	int count = 0, shift = 0, start = 0;
	// 	int len = nums.length;
	// 	int preNum = nums[shift];
		
	// 	while (count < nums.length) {
    //         // if back to original start, start from next one
	// 		if (count > 0 && shift == start) {
    //             start += 1;
	// 			shift = start;
	// 			preNum = nums[shift];
	// 		}
	// 		int tmp = nums[(shift + k) % len];
	// 		nums[(shift + k) % len] = preNum;
	// 		preNum = tmp;
	// 		count ++;
	// 		shift = (shift + k) % len;
	// 	}
	// }
	
	// refactor of previous method
	public void rotate(int[] nums, int k) {
    if (nums === undefined || nums.length < 2) return;

    let count = 0, shift = 0, start = 0;
    let len = nums.length;
    let preNum = nums[shift];

    while (count < nums.length) {
        // if back to original start, start from next one, rest all nums
        if (count > 0 && shift === start) {
            start += 1;
            shift = start;
            preNum = nums[shift];
        }

        // tmp is to keep the num that will be replaced
        let tmp = nums[(shift + k) % len]; 
        nums[(shift + k) % len] = preNum;
        preNum = tmp;
        count++;
        //shift is the next number for moving
        shift = (shift + k) % len;
    }
}
