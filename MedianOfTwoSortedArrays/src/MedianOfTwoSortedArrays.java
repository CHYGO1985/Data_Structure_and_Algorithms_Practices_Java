import java.util.function.IntPredicate;


public class MedianOfTwoSortedArrays {
	
	/*
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // Method 1: brutal force: put them into an array, then sorted and them get the median, O((m+n)log(m+n))
        // Method 2: Merge (merge sort based), O(m + n) 
        // Method 3: left and right part comparing O(log(min(m, n)))
        // https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation/2
        // things learned: 1）use mathematical induction to try to find solution like the videos
        // 2）use abstraction presentation to get result
        
        if (0 == nums1.length && 0 == nums2.length) {
            return 0.0;
        }
        else if (0 == nums1.length) {
            return getMedian(nums2, 0, nums2.length - 1);
        }
        else if (0 == nums2.length) {
            return getMedian(nums1, 0, nums1.length - 1);
        }
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        // make sure A2 is the shorter one, sothe complexity is O(log(min(m, n)))
        if (length1 < length2) {
           return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = length2 * 2; // extended pos
        
        while (low <= high) {
            
            int mid2 = (low + high) / 2; // cut 2
            int mid1 = length1 + length2 - mid2; // cut 1
            
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double R1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE: nums2[(mid2 - 1) / 2];
            double R2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            
            if (L1 > R2) {
                low = mid2 + 1; // A1's lower half is too big; need to move C1 left (C2 right)
            }
            else if (L2 > R1) {
                high = mid2 - 1; ; // A2's lower half too big; need to move C2 left.
            }
            else {
                return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;
            }
            
        }
        
        return -1;
    }
    
    private static double getMedian(int[] nums, int front, int rear) {
        
        // *** be careful about boundaries in an array
        if (front == rear) {
            return nums[front];
        }
        
        // length is rear - front + 1, to optimise, ignore + 1
        int len = rear - front;
        // *** be careful about boundaries in an array
        if (len % 2 != 0) {
            // original: return (nums[len / 2 + front - 1] + nums[len / 2 + front - 1 + 1]) / 2;
            return (double)(nums[len / 2 + front] + nums[len / 2 + front + 1]) / 2;
        }
        else {
            return (double)nums[len / 2 + front];
        }
    }
   */
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // Method 1: brutal force: put them into an array, then sorted and them get the median, O((m+n)log(m+n))
        // Method 2: Merge (merge sort based), O(m + n) 
        // Method 3: left and right part comparing O(log(min(m, n)))
        // https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation/2
        // things learned: 1）use mathematical induction to try to find solution like the videos
        // 2）use abstraction presentation to get result
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if (0 == length1 && 0 == length2) {
            return 0.0;
        }
        else if (0 == length1) {
            return getMedian(nums2);
        }
        else if (0 == length2) {
            return getMedian(nums1);
        }
        
        // make sure A2 is the shorter one, sothe complexity is O(log(min(m, n)))
        if (length1 < length2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = length2 * 2; // extended pos
        
        while (low <= high) {
            
            int mid2 = (low + high) / 2; // cut 2
            int mid1 = length1 + length2 - mid2; // cut 1
            
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double R1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE: nums2[(mid2 - 1) / 2];
            double R2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            
            if (L1 > R2) {
                low = mid2 + 1; // A1's lower half is too big; need to move C1 left (C2 right)
            }
            else if (L2 > R1) {
                high = mid2 - 1; // A2's lower half too big; need to move C2 left.
            }
            else {
                return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;
            }
            
        }
        
        return -1;
    }
    
    private static double getMedian(int[] nums) {
        
    	int len = nums.length;
        // *** be careful about boundaries in an array
        if (1 == len) {
            return nums[0];
        }
        
        // *** be careful about boundaries in an array
        if (0 == len % 2) {
            // original: return (nums[len / 2 + front - 1] + nums[len / 2 + front - 1 + 1]) / 2;
            return (double)(nums[(len - 1) / 2] + nums[(len - 1) / 2 + 1]) / 2;
        }
        else {
            return (double)nums[len / 2];
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] nums1 = {2,5,100};
		int[] nums2 = {1,3,5,7,8};
		*/

		int[] nums1 = {};
		int[] nums2 = {2,3};
	
		double median = findMedianSortedArrays(nums1, nums2);
	}

}
