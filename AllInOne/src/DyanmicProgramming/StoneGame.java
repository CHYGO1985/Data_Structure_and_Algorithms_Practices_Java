/**
 * 
 * 877. Stone Game
 * @author jingjiejiang
 * @history Sep 11, 2020
 * 
 */
class Solution {
//   public boolean stoneGame(int[] piles) {
      
//       int size = piles.length;
//       int[][][] dp = new int[size][size][2];
      
//       // init array
//       for (int row = 0; row < size; row ++) {
//           for (int col = 0; col < size; col ++) {
//               dp[row][col][0] = 0;
//               dp[row][col][1] = 0;
//           }
//       }
      
//       for (int row = 0; row < size; row ++) {
//           dp[row][row][0] = piles[row];
//           dp[row][row][1] = 0;
//       }
      
      
//       for (int col = 1; col < size; col ++) {
//           for (int row = 0, curCol = col; row < size && curCol < size ; row ++, curCol ++) {
              
//               int left = piles[row] + dp[row + 1][curCol][1];
//               int right = dp[row][curCol - 1][1] + piles[curCol];
              
//               dp[row][curCol][0] = left > right ? left : right;
//               dp[row][curCol][1] = left > right ? dp[row + 1][curCol][0] : dp[row][curCol - 1][0];
//           }
//       }
      
//       return dp[0][size - 1][0] > dp[0][size - 1][1];
//   }

  public boolean stoneGame(int[] piles) {
    
    if (piles == null || piles.length == 0) return false;
    if (piles.length == 1) return true;

    int size = piles.length;
    int[][][] dp = new int[size][size][2];

    // init array
    for (int row = 0; row < size; row ++) {
        for (int col = 0; col < size; col ++) {
            dp[row][col][0] = 0;
            dp[row][col][1] = 0;
        }
    }

    //  init start status
    for (int idx = 0; idx < size; idx ++) {
        dp[idx][idx][0] = piles[idx];
        dp[idx][idx][1] = 0;
    }

    // build dp array
    for (int col = 1; col < size; col ++) {
        for (int row = 0, curCol = col; row < size && curCol < size; row ++, curCol ++) {

            // either get left or right pile, and for the rest, can get the post hand
            int left = piles[row] + dp[row + 1][curCol][1];
            int right = piles[curCol] + dp[row][curCol - 1][1];

            dp[row][curCol][0] = left > right ? left : right;
            // current post hand = the first hand of left interval
            dp[row][curCol][1] = left > right ? dp[row + 1][curCol][0] : dp[row][curCol - 1][0];
     
        }
    }

    return dp[0][size - 1][0] > dp[0][size - 1][1];
  }
}