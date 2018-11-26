package PreviousQuestions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author jingjiejiang Nov 25, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		
		List<Interval> resList = new LinkedList<>();
		List<Interval> schdleList = new LinkedList<>();
		
		schedule.forEach((slots) -> schdleList.addAll(slots));
		Collections.sort(schdleList, (s1, s2) -> s1.start - s2.start);
		
		Interval cur = schdleList.get(0);
		for (Interval slot : schdleList) {
			if (cur.end < slot.start) {
				resList.add(new Interval(cur.end, slot.start));
				cur = slot;
			}
			else {
				cur = cur.end < slot.end ? slot : cur;
			}
		}
		
		return resList;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,2,2,1};
		int[] nums1 = new int[] {3, 4, 6, 5};
		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
//		maxNumber(nums1, nums2, 5);
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
