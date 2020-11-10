/**
 * 
 * 1105. Filling Bookcase Shelves
 * 
 * @CHYGO1985
 * @history Nov 10, 2020
 * 
 * ref: https://leetcode.com/problems/filling-bookcase-shelves/discuss/323315/Java-DP-solution
 * 
 */
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {

        int[] dp = new int[books.length + 1];

        // 0 shelf
        dp[0] = 0;

        for (int idx = 1; idx <= books.length; idx ++) {

            int width = books[idx - 1][0];
            int height = books[idx - 1][1];
            // every book is put on a new shelf first
            dp[idx] = height + dp[idx - 1];

            for (int shift = idx - 1; shift > 0 && width + books[shift - 1][0] <= shelf_width; shift --) {
                // this meeans that the idx - 1 one  put on the new shelf as dp[idx], because dp[0] = 0, dp[1] is the actual first shelf
                height = Math.max(height, books[shift - 1][1]);
                width += books[shift - 1][0];
                // books[shift] is the same shelf as idx, so from books[shift - 1] to books[1], is another shelf
                // so it is dp[shift - 1]
                dp[idx] = Math.min(dp[idx], dp[shift - 1] + height);
            }
        }

        return dp[books.length];
    }
}