package Greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author jingjiejiang Nov 23, 2018
 *
 */
public class EmployeeFreeTime {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
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
}
