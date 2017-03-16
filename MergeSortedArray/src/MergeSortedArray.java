
public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        // * idea: round 1: start from front, use binary search, the time complexity is O(nlogn)
        // round 2: did not think about start from tail which makes the things much easier
        
        // *** I didn't think about compare the arrays from their tails, which will make things much easier.
        // , I didn't think for this solution, it related to reverse thinking.
        // ref: https://discuss.leetcode.com/topic/10257/3-line-java-solution/2
		
		// things learned: 1) array problem: compare from the tail (reverse thinking)
        /*
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? 
                                 nums1[tail1--] : nums2[tail2--];
        }
    
        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
        */
        
        // own implementation of "merge from tail" solution
        if ( (null == nums1 && null == nums2)
                || (0 == nums1.length && 0 == nums2.length)
                || (0 == nums2.length) )
            return;
            
        int tails1 = m - 1;
        int tails2 = n - 1;
        int sumLen = m + n - 1;
        
        while (tails1 >= 0 && tails2 >= 0) {
            
            nums1[sumLen --] =  (nums1[tails1] > nums2[tails2])? nums1[tails1 --] : nums2[tails2 --];
        }
        
        while (tails2 >= 0) {
            nums1[sumLen --] = nums2[tails2 --]; 
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
