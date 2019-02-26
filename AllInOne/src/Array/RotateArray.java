package Array;

/**
 * 
 * author jingjiejiang Feb 26, 2019
 *
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
        
		if (nums == null || nums.length == 0) return ;
		int count = 0, shift = 0, start = 0;
		int len = nums.length;
		int preNum = nums[shift];
		
		while (count < nums.length) {
            // if back to original start, start from next one
			if (count > 0 && shift == start) {
                start += 1;
				shift = start;
				preNum = nums[shift];
			}
			int tmp = nums[(shift + k) % len];
			nums[(shift + k) % len] = preNum;
			preNum = tmp;
			count ++;
			shift = (shift + k) % len;
		}
    }
}
