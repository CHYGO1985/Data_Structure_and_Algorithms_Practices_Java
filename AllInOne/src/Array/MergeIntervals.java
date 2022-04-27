package src.Array;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
/**
 * 
 * 56. Merge Intervals
 * 
 * @author jingjiejiang
 * @history Apr 26, 2022
 * 
 */
public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
        
    assert intervals != null && intervals.length > 1;

    List<int[]> resList = new LinkedList<>();

    Arrays.sort(intervals, (intval1, intval2) -> intval1[0] != intval2[0] ?
                            intval1[0] - intval2[0] : intval1[1] - intval2[1]);
    
    int[] preIntval = intervals[0]; 

    for (int row = 1; row < intervals.length; row ++) {

      if (intervals[row][0] <= preIntval[1]) {
        preIntval[1] = Math.max(intervals[row][1], preIntval[1]);
      } else { // post[0] > pre[1]
        resList.add(preIntval);
        preIntval = intervals[row];
      }
    }

    resList.add(preIntval);

    int[][] resArr = new int[resList.size()][2];

    return resList.toArray(resArr);
  }
}
