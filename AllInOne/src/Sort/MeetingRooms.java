package Sort;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang Feb 4 ,2019
 *
 */
public class MeetingRooms {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public boolean canAttendMeetings(Interval[] intervals) {
		
		boolean canAttendAll = true;
		
		Arrays.sort(intervals, (inter1, inter2) -> {
			return inter1.start == inter2.start? inter1.end - inter2.end
					: inter1.start - inter2.start;
		});
		
		for (int idx = 1; idx < intervals.length; idx ++) {
			if (intervals[idx].start < intervals[idx - 1].end) {
				canAttendAll = false;
			}
		}
		
		return canAttendAll;
    }
}
