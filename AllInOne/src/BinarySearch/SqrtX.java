package BinarySearch;
/**
 * 
 * 69. Sqrt(x)
 * 
 * round 1: unsolved, 1hr
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 27, 2017
 * 2. May 12, 2019 
 */
public class SqrtX {

	public int mySqrt(int x) {
        
		if (x <= 0) return 0;
        
		int left = 1, right = x;
		
		while (left < right) {
			
			int mid = left + (right - left) / 2;
			
			if ( mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1)) return mid;
				left = mid + 1;
			}
		}
		
		return left;
    }
}
