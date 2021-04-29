/**
 * 
 * 4. Median of Two Sorted Arrays
 * 
 * @author jingjiejiang
 * @history Apr 29, 2021
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length, len2 = nums2.length;
        
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        
        int left = 0, right = len1;
        int checkPoint = (len1 + len2 + 1) / 2;

        while (left < right) {
            int pivot1 = left + (right - left) / 2; 
            int pivot2 = checkPoint - pivot1;

            if (nums1[pivot1] < nums2[pivot2 - 1]) {
                
                left = pivot1 + 1;
            } else {
                right = pivot1;
            }
        }

        int pivot1 = left;
        int pivot2 = checkPoint - pivot1;

        // max(nums1[m1 - 1], nums2[m2- 1])
        int medianLeft = Math.max(pivot1 == 0 ? Integer.MIN_VALUE : nums1[pivot1 - 1],
                                  pivot2 == 0 ? Integer.MIN_VALUE : nums2[pivot2 - 1]);

        
        // if sum is odd, then return pivot1 directly
        if ((len1 + len2) % 2 == 1) {
            return medianLeft;
        }

        // min(nums1[m1], nums2[m2])
        int medianRight = Math.min(pivot1 >= len1 ? Integer.MAX_VALUE : nums1[pivot1],
                                   pivot2 >= len2 ? Integer.MAX_VALUE : nums2[pivot2]);

        // if sum is even
        return (medianLeft + medianRight) * 0.5;
    }
}