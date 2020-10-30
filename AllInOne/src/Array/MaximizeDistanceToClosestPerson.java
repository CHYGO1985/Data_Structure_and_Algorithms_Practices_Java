/**
 * 
 * 849. Maximize Distance to Closest Person
 * 
 * @author jingjiejiang
 * @history Oct 30, 2020
 * 
 */
class Solution {
  public int maxDistToClosest(int[] seats) {
      
    if (seats.length <= 0) return 0;

    int start = -1, maxGap = 0;

    for (int idx = 0; idx < seats.length; idx ++) {
      if (seats[idx] == 1) {
        if (start == -1) { // if it is the first non-empty seat 0 0 0 1 0 0
          start = idx;
          maxGap = Math.max(maxGap, idx - 0);
        } else { // if it is the second non-empty seat 1 ... 1 0 0 0 1 0 0
          maxGap = Math.max(maxGap, (idx - start) / 2);
          start = idx;
        }
      }
    }

    // for case 0 0 1 0 0 0
    if (start != -1) {
      maxGap = Math.max(maxGap, seats.length - 1 - start);
    }

    return maxGap;
  }
}