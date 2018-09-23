package Greedy;

import java.util.Arrays;

/**
 * solution: https://leetcode.com/problems/create-maximum-number/discuss/77285/Share-my-greedy-solution
 * explanation: https://web.archive.org/web/20160120093629/http://algobox.org/create-maximum-number/
 * @author jingjiejiang
 *
 */
public class CreateMaximumNumber {
	
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
		int[] res = new int[k];
		int[] cursors = new int[2]; // record the current valid val positions 0 for nums1
		int[] starts = new int[2];
		
		// check which array should go first, false: nums1
		boolean pickOne = compare(Arrays.copyOf(nums1, nums1.length), Arrays.copyOf(nums2, nums2.length)); 
        
		int resIdx = 0;
		while (k > 0)  {
			resIdx = findMax(nums1, nums2, starts, cursors, res, resIdx, k, pickOne);
			k --;
		}
        
        return res;
    }
	
	// choose the smaller one or shorter one 
	public static boolean compare(int[] cpy1, int[] cpy2) {
		
    	Arrays.sort(cpy1);
    	Arrays.sort(cpy2);
    	int i = 0;
    	for (; i < cpy1.length && i < cpy2.length; i ++) {
    		if (cpy1[i] > cpy2[i]) {
    			return false;
    		}
    		else if (cpy1[i] < cpy2[i]) {
    			return true;
    		}
    	}
    	
    	if (i < cpy2.length) return true;
    	
    	return false;
	}
	
	public static int findMax(int[] nums1, int[] nums2, int[] starts,
			int[] cursors, int[] res, int resIdx, int k, boolean pickOne) {
		
		int maxPos1 = 0, maxPos2 = 0, max1 = -1, max2 = -1;
		
		for (int index = starts[0]; index < nums1.length; index ++) {
        	if (nums1[index] > max1
        			&& (nums1.length - index + nums2.length - cursors[1]) >= k) {
        		max1 = nums1[index];
        		maxPos1 = index;
        	}
        }
        
        for (int index = starts[1]; index < nums2.length; index ++) {
        	if (nums2[index] > max2 
        			&& (nums2.length - index + nums1.length - cursors[0]) >= k){
        		max2 = nums2[index];
        		maxPos2 = index;
        	}
        }
        
        if (max1 > max2 || (max1 == max2 && pickOne == true)) {
        	res[resIdx] = max1; 
        	cursors[0] = maxPos1 + 1;
        	starts[0] = maxPos1 + 1;
        }
        else {
        	res[resIdx] = max2;
        	cursors[1] = maxPos2 + 1;
        	starts[1] = maxPos2 + 1;
        }
		
        return ++ resIdx;
	}
	
	public static void main(String[] args) {
//		int[] nums1 = new int[]{3, 4, 6, 5};
//		int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
//		int[] nums1 = new int[]{3, 9};
//		int[] nums2 = new int[]{8, 9};
//		int[] nums1 = new int[]{8, 6, 9};
//		int[] nums2 = new int[]{1, 7, 5};
		int[] nums1 = new int[]{6, 7};
		int[] nums2 = new int[]{6,0,4};
		int[] res = maxNumber(nums1, nums2, 5);
		for (int val : res) {
			System.out.println(val);
		}
	}
}
