/**
 * 
 * 799. Champagne Tower
 * 
 * @author jingjiejiang
 * @history Oct 26, 2020
 * 
 */
class Solution {

  // the waster is not evenly distributed, if draw a gragh to cal it carefully, that is why my solution is wrong
  public double champagneTower(int poured, int query_row, int query_glass) {
      
    double res = 0;

    // get sum = n(n + 1)/2, and it is for row pre of query_row, so it is (query_row - 1)(query_row - 1 + 1)/2
    double curRowCups = poured - query_row * (query_row - 1) / 2;
    
    if (curRowCups >= query_row) return 1.0d;
    // every row: there are 2 of 0.5 cups. and row - 2 of full cup
    // so n as 0.5 cup, we get 2n + 2n(row - 2) = sum - presum
    // n = (sum - presum)/2*(row - 1)
    res = (poured - curRowCups) / 2 * (query_row - 1);

    return (query_glass == 1 || query_glass == query_row) ? res : res * 2;
  }
}
