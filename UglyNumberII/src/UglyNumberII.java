/**
 * 
 * 264. Ugly Number II
 * 
 * round 1: unsovled, have no idea how to optimise from brutal force solution.
 * 
 * idea:
 * ref: https://discuss.leetcode.com/topic/21791/o-n-java-solution/3
 * 
 * 1. I thought about use factors to get the numbers (sort of bottom up method)
 * but did not go further. I did not realise the situation. the following fact:
 * cause it only contains 2,3,5, it means that 4, 6, 8 is also 2, 3 
 * 
 * 2. first, we think about it from math perspective, to get all nums that 
 * contains only 2,3,5, we can use the numA from the initial list, and get all
 * possible nums from numA by cal numA*(2/3/5)
 * 1) first, is 2 3 5, min is 2, we use 2*2, 2*3, 2*5, so now, the array is
 * 2 3 4 5 6 10
 * 2) next min is 3, so we get 3*2, 3*3, 3*5, ... (2 3 4 5 6 9 10 15..)
 * 3) next min is 4, so we get 4*2, 4*3, 4*5 ... 2 3 4 5 6 8 9 10 12 15 20
 * 4) next min is 5, so we get 5*2, 5*3, 5*5, ... 
 * 
 * 3. from previous analyse, we can get a solution that using a list(with compator)
 * every time get the min (record the index change, e.g  2 (index 0) have choose, 
 * then next index is 1 (3)) from the list and multiple 2, 3, 5 and then add them to
 * the list, repeated until list size = n. The time complexity of such brutal force
 * method is O(n * nlogn) = O(n ^ 2 * logn)
 * 
 * 4. how to optimise from the method? from 2. we can tell that for 4, 4*2 = 2*4
 * 4*3 = 3*4, 4*5 = 5*4, we get that for 2 3 5, it will need to multiple all the 
 * nums in the growing list (2 3 5) * (2 3 4 5 6 8 9 10 12 15 20)
 * 
 * 5. how we control 2 3 5 to multiply the nums in the growing list, we of course
 * use indices for 2 3 5 to control which factors it should multiply. 
 * 
 * 6. from 5. we can tell that a list is not necessary, we only need to use keep
 * 2, 3, 5 as base, then decide with one should be used to multply the num of the
 * dp array. 
 * 
 * 7. from the following table, we realise that by only updating the min val of three
 * we can decide which num should multiply.
 *               1*2=2 m   2*2=2   4            4 m  4*2=8  8
 *               1*3=3  ->         3 m ->3*3=9  6 ->        6 -> ...
 *               1*5=5             5            5           5 m
 * list updating  1 2       1 2 3         1 2 3 4    1 2 3 4 5
 * m means min num of the current num
 * 
 * Actively upting the DP list
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 21, 2017
 */
public class UglyNumberII {

	public static int nthUglyNumber(int n) {
        
        if (n == 0) return 0;
        
        int[] dp = new int[n];
        dp[0] = 1;
        int prim1 = 2, prim2 = 3,  prim3 = 5;
        // *** to control 
        int index1 = 0, index2= 0, index3 = 0;
        
        for (int i = 1; i < n; i ++) {
            
            int min = Math.min(prim1, Math.min(prim2, prim3));
            dp[i] = min;
            if (prim1 == min) prim1 = 2 * dp[++ index1];
            if (prim2 == min) prim2 = 3 * dp[++ index2];
            if (prim3 == min) prim3 = 5 * dp[++ index3];
        }
        
        return dp[n - 1];
    }
	
	public static void main(String[] args) {
		nthUglyNumber(10);
	}
}
