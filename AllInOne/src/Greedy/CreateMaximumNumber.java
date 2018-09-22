package Greedy;

public class CreateMaximumNumber {
	
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
		int[] res = new int[k];
		int[] arr = new int[nums1.length * 2 + nums2.length];
        int max = Integer.MIN_VALUE;
        int maxPos = 0;
        
        // assemble nums1 + nums2 + nums1
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        System.arraycopy(nums1, 0, arr, nums1.length + nums2.length, nums1.length);
        
        // find the max
        for (int index = 0; index < arr.length; index ++) {
        	if (arr[index] > max) {
        		max = arr[index];
        		maxPos = index;
        	}
        }
        res[0] = max;
        // deal with max < nums1.length, nums1.length < max < nums2.length 
        int limit =  (maxPos < nums1.length) ? nums1.length + nums2.length : arr.length; 
        	
        return getMaxArray(arr, res, 1, maxPos + 1, k - 1, limit);
    }
	
	// search from start to limit
	public static int[] getMaxArray(int[] arr, int[] target, int targetPos, int start, int k, int limit) {
		
		if (start + k >= limit) {
			System.arraycopy(arr, start, target, targetPos, k);
			k = 0;
		}
		
		if (k == 0) return target;
		
		target[targetPos] = Integer.MIN_VALUE;
		int maxPos = 0;
		
		// no need to limit - k + 1 here, as limit is the length, not the actual index
		for (int index = start; index <= limit - k; index ++) {
			if (arr[index] > target[targetPos]) {
				maxPos = index;
				target[targetPos] = arr[maxPos];
			}
		}
		
		return getMaxArray(arr, target, targetPos + 1, maxPos + 1, k - 1, limit);
	}
	
	public static void main(String[] args) {
//		int[] nums1 = new int[]{3, 4, 6, 5};
//		int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
		int[] nums1 = new int[]{3, 9};
		int[] nums2 = new int[]{8, 9};
		int[] res = maxNumber(nums1, nums2, 3);
		for (int val : res) {
			System.out.println(val);
		}
	}
}
