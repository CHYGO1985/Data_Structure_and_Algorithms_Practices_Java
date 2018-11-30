package PreviousQuestions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author jingjiejiang Nov 30, 2018
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
        
	    List<Interval> schdList = new LinkedList<>();
	    List<Interval> freeTimeList = new LinkedList<>();
	    
	    schedule.forEach(slots -> schdList.addAll(slots));
	    Collections.sort(schdList, (s1, s2) -> s1.start - s2.start);
	    
	    Interval cur = schdList.get(0);
	    for (Interval slot : schdList) {
	    	if (cur.end < slot.start) {
	    		freeTimeList.add(new Interval(cur.end, slot.start));
	    		cur = slot;
	    	}
	    	else {
				cur = cur.end < slot.end ? slot : cur;
			}
	    }
	    
	    return freeTimeList;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,4,5,2};
		int[] nums1 = new int[] {3, 4, 6, 5};
		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
//		System.out.print(candy(arr));
//		maxNumber(nums1, nums2, 5);
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
