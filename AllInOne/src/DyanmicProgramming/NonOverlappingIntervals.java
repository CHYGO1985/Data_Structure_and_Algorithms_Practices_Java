/**
 * 
 * 435. Non-overlapping Intervals
 * 
 * @author jingjiejiang
 * @history Sep 13, 2020
 * 
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int res = 0;
        if (intervals == null || intervals.length == 0) return res;
        
        Arrays.sort(intervals, (interval1, interval2) -> interval1[1] - interval2[1]);        
        // Arrays.sort(intervals, (int[] interval1, int[] interval2) -> { return interval1[1] - interval2[1]; })
        
        int preIntervalPos = 0;
        
        for (int idx = 1; idx < intervals.length; idx ++) {
            
            if (intervals[idx][0] >= intervals[preIntervalPos][1]) {
                preIntervalPos = idx;
            } else {
                res ++;
            }
        }    
    
        return res;
    }
}