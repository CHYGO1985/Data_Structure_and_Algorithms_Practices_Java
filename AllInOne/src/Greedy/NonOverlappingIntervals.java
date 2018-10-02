package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author jingjiejiang created on Sep 8, 2018
 * 1. updated on Oct 2, 2018
 *
 */
public class NonOverlappingIntervals {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static int eraseOverlapIntervals(Interval[] intervals) {
		
		if (intervals == null || intervals.length == 0) return 0;
		
		int cnt = 0, curEnd = Integer.MIN_VALUE;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start == b.start ? a.start - b.start : a.end - b.end; 
			}
		});
		
		for (Interval interval : intervals) {
			// 1 -- 4 : 2 -- 4 , remove the larger one
			if (interval.start >= curEnd) {
				curEnd = interval.end;
			} else { // interval.start < curEnd
				if (interval.end <= curEnd) {
					curEnd = interval.end;
				}
				// 1 -- 6 : 4 -- 7 (next 6 -- 8) 
				cnt ++;
			}
		}
		
		return cnt;
    }

	public static void main(String[] args) {

	}

}
