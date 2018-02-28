package ArrangingCoins;

/**
 * 
 * 441. Arranging Coins
 * 
 * round 1: half-solved
 * The difference between : 0.5 * mid * mid + 0.5 * mid, mid * mid / 2 + mid / 2, mid * mid * 0.5 + mid * 0.5
 * 1) 0.5 * mid * mid: = (0.5*mid)*mid put 0.5 in front, the result will be converted to double
 * 2) mid * mid * 0.5: = (mid*mid)*0.5, coz mid is int, so mid*mid is int if mid*mid may exceed
 * the max range of int.
 * 
 * @author jingjiejiang
 * @history
 * 1. Jan 7, 2018
 * 2. Finished on Feb 27,2018 
 */
public class ArrangingCoins {
	
	public static int arrangeCoins(int n) {
        
        int left = 0;
        int right = n;
        int mid = 0;
        
        while (left <= right) {
            
            mid = (right + left) / 2;
            
            // *** 0.5 * mid * mid + 0.5 * mid is diffrent from mid * mid / 2 + mid / 2
            // when mid = 3, former = 4.5 + 1.5 = 6, latter = 5.
            if (0.5 * mid * mid + mid * 0.5 > n) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left - 1;
        
    }
	
	public static void main (String[] args) {
		
		int a = arrangeCoins (1804289383);
		System.out.println(a);
	}

}
