package Array;

/**
 * 
 * @author jingjiejiang Feb 23, 2019
 *
 */
public class MergeSortedArray {
	
	// from back to front
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        
		int idx1 = m - 1, idx2 = n - 1, tailIdx = nums1.length - 1;
		
		while (idx1 >= 0 && idx2 >= 0) {
			nums1[tailIdx --] = (nums1[idx1] >= nums2[idx2]) ? nums1[idx1 --] :
				nums2[idx2 --];
		}
		
		while (idx1 >= 0) {
			nums1[tailIdx --] = nums1[idx1 --];
		}
		
		while (idx2 >= 0) {
			nums1[tailIdx --] = nums2[idx2 --];
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
