import java.util.Arrays;

/**
 * 
 * 252. Meeting Rooms
 * 
 * @author jingjiejiang
 * @history Nov 2, 2020
 * 
 */
class Solution {
  public boolean canAttendMeetings(int[][] intervals) {
      
    if (intervals == null || intervals.length < 2) return true;

    int len = intervals.length;
    int[] starts = new int[len];
    int[] ends = new int[len];

    Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    for (int idx = 0; idx < len; idx ++) {
      starts[idx] = intervals[idx][0];
      ends[idx] = intervals[idx][1];
    }

    int startIdx = 0, endIdx = 0;
    boolean hasMeeting = false;

    while (startIdx < len & endIdx < len) {
      if (starts[startIdx] < ends[endIdx]) {
        if (hasMeeting == true) return false;
        hasMeeting = true;
        startIdx ++;
      } else { // startIdx >= endIdx
        endIdx ++;
        hasMeeting = false;
      }
    }

    return true;
  }
}
