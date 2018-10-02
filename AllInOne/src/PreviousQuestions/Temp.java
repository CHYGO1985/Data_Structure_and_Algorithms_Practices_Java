package PreviousQuestions;

import java.awt.event.MouseWheelEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import Greedy.NonOverlappingIntervals.Interval;

/**
 * 
 * @author jingjiejiang Oct 2nd, 2018
 *
 */
public class Temp {
	
	// 1. sort
	// 2. iterate through to get the most overlapping one
	// 3. only compare with the current range, if next.start >= cur.end, update the range
	// 4. if next.end <= cur.end. update cur.end as next.end (get rid of the bigger one)
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int eraseOverlapIntervals(Interval[] intervals) {
		
if (intervals == null || intervals.length == 0) return 0;
		
		int cnt = 0, curEnd = Integer.MIN_VALUE;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start == b.start ? a.start - b.start : a.end - b.end; 
			}
		});
		
		for (Interval interval : intervals) {
			if (interval.start >= curEnd) {
				curEnd = interval.end;
			} else { // interval.start < curEnd
				if (interval.end <= curEnd) {
					curEnd = interval.end;
				}
				cnt ++;
			}
		}
		
		return cnt;
    }
	
	public static void main(String[] args) {
		
	}
}
