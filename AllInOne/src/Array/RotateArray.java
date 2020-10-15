package Array;

/**
 * 
 * 189. Rotate Array
 * 
 * author jingjiejiang Feb 26, 2019
 * @history Oct 16, 2020
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
        
        if (k == 0) return ;
        
        int len = nums.length;
        int curIdx = 0, preNum = nums[curIdx], startIdx = 0;
        int count = 0;
        
        while (count < len) {
            
            if (count > 0 && curIdx == startIdx) {
                startIdx ++;
                curIdx = startIdx;
                preNum = nums[curIdx];
            }
            
            int nextIdx = (curIdx + k) % len;
            int tmp = nums[nextIdx];
            nums[nextIdx] = preNum;
            preNum = tmp;
            curIdx = nextIdx;
            count ++;
        }
    }
}
