import java.util.Arrays;

/**
 * round 2: sep, 19, 2017
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 19, 2017
 */
public class LongestIncSubsequence {
	
	public static int lengthOfLIS(int[] nums) {            
		 // Method 1: used a hashmap to record all the lists (when there is a samller ele came, add it to the hash map)
        // for every ele, compare it with the lists in hashmap (maxelem, length); if the ele > maxelem, list length + 1
        // for this method, time complexity is O(n^2) (compare until max length > the rest ele in nums)
        
        // Method 2: idea: dp, O(nlogn)
        // The idea is to keep the previous longest subsequence info, for example, if the current sequence is 2,5,10,100
        // then it comes 20, then 20 will replace 100, 2,5,10,20, then comes 22, it will become 2,5,10,20,22, it won't
        // affect the previous sequence, in this way, it only needs to keep the previou longest sequence information.
        // things learned: 1) the feature of binarySearch(int[] a,int fromIndex, int toIndex, int key) in Arrays Class.
		// 2) DP idea
        
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
        	
        	// public static int binarySearch(int[] a,int fromIndex, int toIndex, int key)
        	// if key is bigger than any ele in the dp, return - toIndex - 1
        	// or the index of the first element in the range greater than the key, - index -1
            int i = Arrays.binarySearch(dp, 0, len, x);
            // *** here is the most tricky part, which decides the replace places
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            
            // keep updating the len
            if(i == len) len++;
        }

        return len;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18}; 
        //int[] nums = {10,11,20,5,7,22,21};
        
        int len = lengthOfLIS(nums);
	}

}
