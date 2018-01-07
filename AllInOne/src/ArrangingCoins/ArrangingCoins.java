package ArrangingCoins;

/**
 * 
 * 441. Arranging Coins
 * 
 * round 1: half-solved
 * The difference between : 0.5 * mid * mid + 0.5 * mid and mid * mid / 2 + mid / 2
 * 
 * @author jingjiejiang
 * @history
 * 1. Jan 7, 2018
 */
public class ArrangingCoins {
	
	public int arrangeCoins(int n) {
        
        int left = 0;
        int right = n;
        int mid = 0;
        
        while (left <= right) {
            
            mid = (right + left) / 2;
            
            // *** 0.5 * mid * mid + 0.5 * mid is diffrent from mid * mid / 2 + mid / 2
            // when mid = 3, former = 4.5 + 1.5 = 6, latter = 5.
            if (mid * mid * 0.5 + mid * 0.5 > n) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left - 1;
    }

}
