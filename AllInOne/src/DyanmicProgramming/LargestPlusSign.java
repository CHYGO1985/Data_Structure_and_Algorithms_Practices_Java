import java.util.Arrays;

/**
 * 
 * 764. Largest Plus Sign
 * 
 * @author jingjiejiang
 * @history Dec 6, 2020
 * 
 */
class Solution {
  public int orderOfLargestPlusSign(int N, int[][] mines) {
      
    assert N > 0 && mines != null;

    // store the min len for each [row][col] at four directions
    int[][] grids = new int[N][N];

    for (int row = 0; row < grids.length; row ++) {
      Arrays.fill(grids[row], N); // as need to calc min val
    }

    for (int[] mine : mines) {
      grids[mine[0]][mine[1]] = 0;
    }

    for (int row = 0; row < N; row ++) {

      // colLToR is a column index, iterate from left to right
      // every time check how far left it can reach.
      // if grid[row][colLToR] is 0, l needs to start over from 0 again, otherwise increment
      for (int colLToR = 0, cnt = 0; colLToR < N; colLToR ++) {
        grids[row][colLToR] = Math.min(grids[row][colLToR],
          cnt = (grids[row][colLToR] == 0 ? 0 : cnt + 1));
      }

      // colRToL is a column index, iterate from right to left
      // every time check how far right it can reach.
      // if grid[row][colRToL] is 0, r needs to start over from 0 again, otherwise increment
      for (int colRToL = N - 1, cnt = 0; colRToL >= 0; colRToL --) {
        grids[row][colRToL] = Math.min(grids[row][colRToL],
          cnt = (grids[row][colRToL] == 0 ? 0 : cnt + 1));
      }

      // rowTopToBot is a row index, iterate from top to bottom
      // every time check how far up it can reach.
      // if grid[rowTopToBot][row] is 0, u needs to start over from 0 again, otherwise increment
      for (int rowTopToBot = 0, cnt = 0; rowTopToBot < N; rowTopToBot ++) {
        grids[rowTopToBot][row] = Math.min(grids[rowTopToBot][row],
          cnt = (grids[rowTopToBot][row] == 0 ? 0 : cnt + 1));
      }

      for (int rowBotToTop = N - 1, cnt = 0; rowBotToTop >= 0; rowBotToTop --) {
        grids[rowBotToTop][row] = Math.min(grids[rowBotToTop][row],
          cnt = (grids[rowBotToTop][row] == 0 ? 0 : cnt + 1));
      }

      // after four loops each time taking Math.min over the grid value itself
      // all grid values will eventually take the min of the 4 direcitons.
    }

    int res = 0;

    for (int row = 0; row < N; row ++) {
      for (int col = 0; col < N; col ++) {
        res = Math.max(res, grids[row][col]);
      }
    }
        
    return res;
  }
}