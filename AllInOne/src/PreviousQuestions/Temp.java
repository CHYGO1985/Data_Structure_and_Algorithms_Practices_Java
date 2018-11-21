package PreviousQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author jingjiejiang Nov 21, 2018
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
        Interval interval = new Interval();
        interval.start = 0;
        interval.end = 1;
        List<Interval> list = new LinkedList<>();
        list.add(interval);
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
        
        List<Interval> prioList = new LinkedList<>();
        Collections.sort(prioList, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start == o2.start? o1.end - o2.end : o1.start - o2.start;
			}
		});
        
        for (int i = 0; i < schedule.size(); i ++) {
        	for (int j = 0; j < schedule.get(i).size(); i ++) {
        		for (int m = 0; m < prioList.size())
        	}
        }
        
        
        return list;
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
