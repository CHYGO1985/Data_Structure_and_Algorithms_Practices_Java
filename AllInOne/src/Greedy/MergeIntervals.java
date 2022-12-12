package src.Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 56. Merge Intervals
 * 
 * @CHYGO1985
 * @history Sep 25, 2020
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        List<int[]> res = new LinkedList<>();
        int[] curInterval = intervals[0];

        for (int idx = 1; idx < intervals.length; idx ++) {

            // cur start <= pre end, then check whether the pre interval
            if (intervals[idx][0] <= curInterval[1]) {
                // curInterval[1] = intervals[idx][1] > curInterval[1] ? intervals[idx][1] : curInterval[1];
                curInterval[1] = Math.max(intervals[idx][1], curInterval[1]);
            } else {
                res.add(curInterval);
                curInterval = intervals[idx];
            }
        }

        res.add(curInterval);

        int[][] array = new int[res.size()][2];
        return res.toArray(array);
    }
}