/**
 * 
 * 69. Sqrt(x)
 * 
 * @author jingjiejiang
 * @history Apr 6, 2021
 * 
 */
public class SqrtX {
    public int mySqrt(int x) {
        
        int left = 0, right = x;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            long product = (long)mid * mid;

            if (product > x) {
                right = mid - 1;
            } else if (product < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        // e.g. left = 3, right = 4, res = 11 => left = right = 4
        return right;
    }
}
