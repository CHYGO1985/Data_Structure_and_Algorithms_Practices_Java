
/**
 * 
 * 673. Number of Longest Increasing Subsequence
 * 
 * round 1: 1.5 hours, I thought about find the length of longest subq, then
 * use dfs to get the num of LIS. this very complicated algorithm, I was trying
 * to optimise it, but have no clue.
 * 
 * O(n^2) solution:
 * ref: https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 * 
 * @author jingjiejiang
 * @history
 * 1. SEp 20, 2017
 */
public class NumOfLongestIncSubseq {

	public static int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        
        // i from 1 to n, j from 0 to i - 1, compare nums[i] and nums[j]
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                	// 1 6 5 7, len[7] = len[5] + 1,
                    if(len[i] == len[j] + 1)
                    	cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            
            // same length, 1 6 7 2 3, len[7] = len[3] then count + cnt[i] 
            if(max_len == len[i])
            	res += cnt[i];
            else if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findNumberOfLIS(new int[]{1,6,5,7});

	}

}
