package PreviousQuestions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author jingjiejiang Oct 18, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int eraseOverlapIntervals(Interval[] intervals) {
		
		// sort
		// record pre and removeCnt
		// for (1 -> intervals.len)
		// if (cur.start < pre.end) 
		// removeCnt ++
		// also check if cur.end < pre.end then pre = cur (remove pre)
		// else cur.start >= ppre.end
		// pre = cur;
		
		if (intervals == null || intervals.length <= 1) return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start == b.start ? a.end - b.end : a.start - b.start;
			}
		});
		
		int removeCnt = 0;
		Interval pre = intervals[0];
		for (int idx = 1; idx < intervals.length; idx ++) {
			if (intervals[idx].start < pre.end) {
				removeCnt ++;
				if (intervals[idx].end < pre.end) {
					pre = intervals[idx];
				}
			}
			else { // intervals[idx].start >= pre.end
				pre = intervals[idx];
			}
		}
		
		return removeCnt;
    }
	
	public static void main(String[] args) {
	}
}
