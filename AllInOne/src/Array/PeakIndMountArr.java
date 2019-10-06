package Array;

/**
 * 
 * @author jingjiejiang Feb 1, 2019
 *
 */
public class PeakIndMountArr {
	public int peakIndexInMountainArray(int[] A) {
		
		int left = 0, right = A.length - 1;
		int mid = (left + right) / 2;
		
		while (left < right && mid > 0 && mid < A.length - 1) {
			// left (consider boundry case)
			if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
				left = mid  + 1;
			}
			else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) { // right
				right = mid - 1;
			} else {
				return mid;
			}
			
			mid = (left + right) / 2;
		}
		
        return mid;
    }
}
