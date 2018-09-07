package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
	
	public static List<Interval> sort(Interval[] intervals) {
		List<Interval> list = Arrays.asList(intervals);
        
        Collections.sort(list, new Comparator<Interval>() {
        	@Override
        	public int compare(Interval a, Interval b) {
        		return (a.start != b.start) ? (a.start - b.start) : (a.end - b.end);
        	}
		});
        
        return list;
	}
	
	public static int minMeetingRooms(Interval[] intervals) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		List<Interval> list = sort(intervals);
		int min = 0;
		for (int i = 0; i < list.size(); i ++) {
			Interval cur = list.get(i);
			if(queue.size() == 0) {
				queue.offer(cur.end);
				min = 1;
				continue;
			}
				
			int curMinEnd = queue.peek();
			if (cur.start >= curMinEnd) {
				queue.poll();
			}
			queue.offer(cur.end);
			
			min = Math.max(min, queue.size());
		}
		
		return min;
    }

	public static void main(String[] args) {

	}

}
