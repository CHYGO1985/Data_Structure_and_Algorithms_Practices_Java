package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author jingjiejiang created on Sep 8, 2018
 *
 */
public class NonOverlappingIntervals {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static List<Interval> sort(Interval[] intervals) {
		List<Interval> list = Arrays.asList(intervals);
		
		Collections.sort(list, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return (a.start != b.start) ? a.start - b.start : a.end - b.end;	
			}
		});
		
		return list;
	}
	
	public static int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length <= 1) {
			return 0;
		}
		
		List<Interval> list = sort(intervals);
		int count = 0;
		int end = list.get(0).end;
		
		for (int index = 1; index < list.size(); index ++) {
			Interval interval = list.get(index);
			if (interval.start >= end) {
				end = interval.end;
			}
			else if (interval.start < end) {
				// 1 -- 4 : 2 -- 4
				if (interval.end <= end) {
					// remove the bigger one
					end = interval.end;
				}
				// 1 -- 6 : 4 -- 7 (next 6 -- 8) 
				// keep the original
				count ++; 
			}
		}
		
		return count; 
    }

	public static void main(String[] args) {

	}

}
