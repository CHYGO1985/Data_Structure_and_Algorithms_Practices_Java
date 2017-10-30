/**
 * 
 * 367. Valid Perfect Square.
 * 
 * round 1: solved, 40m, test case: num = 1
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 28, 2017
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
        
        int left = 1;
        int right = num / 2;
        // give num the value num for case when num = 1
        int res = num;
            
        while (true) {
            // *** should add this condition
            if (left > right) break;
            
            int mid = left + (right - left) / 2;
            if (num / mid > mid) {
                left = mid + 1;
            }
            else if (num / mid < mid){
                right = mid - 1;
            }
            else {
                res = mid;
                break;
            } 
        }
        return res * res == num ? true : false;
	}
}
