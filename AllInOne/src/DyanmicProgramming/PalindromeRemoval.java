/**
 * 
 * 1246. Palindrome Removal
 * 
 * @CHYGO1985
 * @history Oct 17, 2020
 * 
 * ref: https://www.geeksforgeeks.org/minimum-steps-to-delete-a-string-after-repeated-deletion-of-palindrome-substrings/
 * 
 * Status transfer formula:
 * 
 * dp[i][j] denotes the number of steps it takes to delete the substring s[i, j].
 * 
 * every step there are 3 possibilities:
 * 
 * dp[i][j] = min(1 + dp[i+1][j],
 *         dp[i+1][K-1] + dp[K+1][j],  where s[i] == s[K]
 *         1 + dp[i+2][j] )
 * 
 */
class Solution {
    public int minimumMoves(int[] arr) {
        
        int arrLen = arr.length;
        int[][] dp = new int[arrLen + 1][arrLen + 1];

        // init dp array
        for (int row = 0; row < arrLen; row ++) {
            for (int col = 0; col < arrLen; col ++) {
                dp[row][col] = 0;
            }
        }

        // iterate all the length possibility
        for (int len = 1; len <= arrLen; len ++) {

            // cal how many moves need within [left, right]
            // len = 1: [0, 0], [1, 0]...
            // len = 2: [0, 1], [1, 2]...
            // len = 3: [0, 2], [1, 3]...
            for (int left = 0, right = len - 1; right < arrLen; left ++, right ++) {

                if (len == 1) {
                    dp[left][right] = 1;
                } else {
                    // if delete single digit at a time
                    dp[left][right] = 1 + dp[left + 1][right];

                    // when [0, 0, 1] then [0,0,1] = 1 + [1]
                    if (arr[left] == arr[left + 1]) 
                        dp[left][right] = Math.min(1 + dp[left + 2][right], dp[left][right]);


                    // when from left to right, there is arr[k] == arr[left]
                    for (int shift = left + 2; shift <= right; shift ++) {
                        if (arr[shift] == arr[left]) {
                            
                            // [3 1 5 1 3] remove time = [5] = 1, so do not + 1 when arr[left] == arr[shift]
                            dp[left][right] = Math.min(dp[left][right], 
                                dp[left + 1][shift - 1] + dp[shift + 1][right]);
                        }
                    }
                }
            }           
        }

        return dp[0][arrLen - 1];
    }
}