import javax.xml.namespace.QName;

/**
 * 
 * 1288. Remove Covered Intervals
 * 
 * @author jingjiejiang
 * @hisotry Oct 5, 2020
 * 
 */
class Solution {
    // public int removeCoveredIntervals(int[][] intervals) {
        
    //     if (intervals == null || intervals.length == 0) return 0;

    //     int count = 1;
    //     Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    //     int[] preInterval = intervals[0];

    //     for (int idx = 1; idx < intervals.length; idx ++) {

    //         if (preInterval[0] == intervals[idx][0]) {
    //             preInterval[1] = Math.max(preInterval[1], intervals[idx][1]);
    //             continue ;
    //         }

    //         if (preInterval[1] <= intervals[idx][0]) {
    //             preInterval = intervals[idx];
    //             count ++;
    //         } else {
    //             if (preInterval[1] < intervals[idx][1]) {
    //                 preInterval = intervals[idx];
    //                 count ++;
    //             }
    //         }

    //         // do not need to do anything when preInterval[1] >= intervals[idx][1]
    //     }

    //     return count;
    // }

    // refactoring from previous one
    public int removeCoveredIntervals(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0) return 0;

        int count = 1;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] preInterval = intervals[0];

        for (int idx = 1; idx < intervals.length; idx ++) {

            if (preInterval[0] == intervals[idx][0]) {
                preInterval[1] = Math.max(preInterval[1], intervals[idx][1]);
                continue ;
            }

            if ((preInterval[1] <= intervals[idx][0]) ||
                ( (preInterval[1] > intervals[idx][0]) && (preInterval[1] < intervals[idx][1]) )) {
                preInterval = intervals[idx];
                count ++;
            }

            // do not need to check if pre[0] < cur[0], as it is sorted
            // do not need to do anything when preInterval[1] >= intervals[idx][1]
        }

        return count;
    }
}