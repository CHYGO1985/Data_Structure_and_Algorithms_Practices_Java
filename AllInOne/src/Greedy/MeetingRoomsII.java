package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  
 * solution 1: priority queue, O(nlogn)
 * solution 2: use two arrays for start and end 
 * https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-@pinkfloyda 
 * 
 * @author jingjiejiang created on sep 7, 2018 
 *
 */
public class MeetingRoomsII {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	// sort
	// user priorityqueue to record all ends to classroom, replace with the min first if new meeting comes
	public int minMeetingRooms(Interval[] intervals) {

		int roomCnt = 0;
		if (null == intervals || 0 == intervals.length) return roomCnt;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start == b.start ? a.end - b.end : a.start - b.start;
			}
		});
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (Interval interval : intervals) {
			if (queue.isEmpty()) {
				queue.offer(interval.end);
			}
			else {
				if (interval.start >= queue.peek()) {
					queue.poll();
				}
				// start >= peek or < peek. we all will need to add the end to queue
				queue.offer(interval.end);
			}
			roomCnt = Math.max(roomCnt, queue.size());
		}
	    
		return roomCnt;
    }

	public static void main(String[] args) {

	}

}
