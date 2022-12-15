package src.BinarySearch;

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

	public int mySqrt1(int x) {
        
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

	public int mySqr2(int x) {
        
        // if (x <= 1) return x;
        // if (x == 3) return 1;
        
        int left = 0, right = x;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            long product = (long) mid * mid;

            if (product > x) {
                right = mid - 1;
            } else if (product < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        // e.g. left = 3, right = 4, res = 11 => left = right = 4 => product > res => right = 3, left = 4
        // finally we get right < left (with right * right < x, left * left > x)
        return right; 
    }
}
