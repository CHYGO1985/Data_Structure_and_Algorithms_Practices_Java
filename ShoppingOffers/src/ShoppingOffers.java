import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 638. Shopping Offers
 * 
 * round 1: half-solved, 5 hours, DP solution, very slow.
 * *** it proves that unfixed problem size is not suitable for DP, DFS + DP 
 * will be much better.
 * 
 * ref: DP: https://discuss.leetcode.com/topic/95272/a-just-for-fun-only-dp-solution/2
 * DSF + DP: https://discuss.leetcode.com/topic/95237/java-dfs-dp
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aug 5, 2017
 *
 */
public class ShoppingOffers {
	
	// DP version 1
	public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        if (null == price || 0 == price.size() || null == needs || 0 == needs.size())
            return 0;
        
        int item0 = needs.get(0), 
            item1 = needs.size() >= 2? needs.get(1) : 0, 
            item2 = needs.size() >= 3? needs.get(2) : 0,
            item3 = needs.size() >= 4? needs.get(3) : 0,
            item4 = needs.size() >= 5? needs.get(4) : 0,
            item5 = needs.size() >= 6? needs.get(5) : 0;
        
        // 6 dimensional dp
        int[][][][][][] dp = new int[7][7][7][7][7][7];
        
        int price0 = price.get(0), 
            price1 = price.size() >= 2? price.get(1) : 0, 
            price2 = price.size() >= 3? price.get(2) : 0,
            price3 = price.size() >= 4? price.get(3) : 0, 
            price4 = price.size() >= 5? price.get(4) : 0, 
            price5 = price.size() >= 6? price.get(5) : 0;
            
        // fill special to length 7
        // the actual items listed in an offer
    	// *** fill special is different, as the price 2 3 5, should be 2 3 0 0 0 0 5 (the cost is 5)
        // not 2 3 5 0 0 0 0 (the cost is 0)
        if (special != null && special.size() > 0 && special.size() < 7) {
	        for (int i = 0; i < special.size(); i ++) {
	        	List<Integer> temp = special.get(i);
	        	for (int j = price.size(); j < 6; j ++) temp.add(j, 0);
	        }
        }
        
        // init dp array
        // dp[0][0][x][0][0][0], set as single price
        dp[0][0][0][0][0][0] = 0;
        
        // start from dp[1][1][0][0][0][0], check all "special"s, get the min of it
        // finish the process at dp[need.get(0)][needs.get(1)][needs.get(2)]...[needs.get(5)]
        for (int i = 0; i < 7; i ++) 
            for (int j = 0; j < 7; j ++)
                for (int k = 0; k < 7; k ++)
                    for (int l = 0; l < 7; l ++)
                        for (int m = 0; m < 7; m ++) 
                            for (int n = 0; n < 7; n ++) {
                                dp[i][j][k][l][m][n] = price0 * i + price1 * j + price2 * k
                                    + price3 * l + price4 * m + price5 * n; 
                            }
        
        for (List<Integer> cur: special) {
        	
        	// *** avoid checking bounaries
        	for (int i = cur.get(0); i < 7; i ++) 
                for (int j = cur.get(1); j < 7; j ++)
                    for (int k = cur.get(2); k < 7; k ++)
                        for (int l = cur.get(3); l < 7; l ++)
                            for (int m = cur.get(4); m < 7; m ++) 
                                for (int n = cur.get(5); n < 7; n ++) {
                                	dp[i][j][k][l][m][n] = Math.min(dp[i][j][k][l][m][n], 
                                            dp[i - cur.get(0)][j - cur.get(1)][k - cur.get(2)][l - cur.get(3)]
                                                [m - cur.get(4)][n - cur.get(5)] + cur.get(6));
                                }
        }
                                
        return dp[item0][item1][item2][item3][item4][item5];
    }

	// test
	public static void main(String[] args) {
		List<Integer> price = new ArrayList<>(Arrays.asList(2, 5));
		List<Integer> needs = Arrays.asList(3, 2);
		List<Integer> temp1 = new ArrayList<>(Arrays.asList(3, 0, 5));
		List<Integer> temp2 = new ArrayList<>(Arrays.asList(1, 2, 10));
		List<List<Integer>> special = new ArrayList<>();
		special.add(temp1);
		special.add(temp2);
		int a = shoppingOffers(price, special, needs);
		System.out.println(a);
		
	}
}
