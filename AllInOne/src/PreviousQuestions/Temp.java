package PreviousQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author jingjiejiang Oct 15, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int minMeetingRooms(Interval[] intervals) {
		// sort the array as ascend order
		// put in priority queue
		// if new.start < queue.peek.end, queue.pool and queue.offer(new)
		// else queue.offer(new)
		// each round cnt = max(cnt, queue.size)
		int roomCnt = 0;
		if (intervals == null || intervals.length == 0) return 0;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start == b.start ? a.end - b.end : a.start - b.start;
			}
		});
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(); 
		
		for (Interval interval : intervals) {
			if (queue.size() == 0) {
				queue.offer(interval.end);
			}
			else {
				if (interval.start >= queue.peek()) {
					queue.poll();
				}
				queue.offer(interval.end);
			}
			
			roomCnt = Math.max(roomCnt, queue.size());
		}
		
		return roomCnt;
    }
	
	public static void main(String[] args) {
	}
}
