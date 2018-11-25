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
        // init a prioritylist, sort the element in the list as 
        // a.start != b.start ? a.start - b.start : a.end - b.end
        // for (0 --> schedule.size)
        //   for (slot : schedule.get(i))
        //     new = slot
        //     int j = 0;
        //     for (0 -> prilist.size)
        //       cur = prilist.get(j)
        //       if (new.start < cur.end && new.start >= cur.start)
        //         merge new into cur
        //       else if (new.start >= cur.end)
        //         continue
        //       else if (new.end <= cur.start)
        //        add to prilist, break;
        //      if j >= list.size, then add new to prilist
        List<Interval> schedList = new LinkedList<>();
        List<Interval> resList = new LinkedList<>();
        
        schedule.forEach(slot -> schedList.addAll(slot));
        
        Collections.sort(schedList, (a, b) -> a.start - b.start);
        
        Interval temp = schedList.get(0);
        for (Interval slot : schedList) {
        	if (slot.start > temp.end) {
        		resList.add(new Interval(temp.end, slot.start));
        		temp = slot;
        	} else {
        		temp = temp.end < slot.end ? slot : temp;	
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
