import java.util.LinkedList;
import java.util.List;

/**
 * round 1; 3 hours, solved, beat 65.72%
 * 
 * Error: Memory Limit Exceeded
 * *** JAVA list: cann't do remove in a list during a for loop from begin to end 
 * Solution: 1. but can do from end to start)
 * for (int i = list.size() - 1; i>=0; i--) {
 *  String fruit = list.get(i);
 *  System.out.println(fruit);
 *  if ("banane".equals(fruit)) {
 *      list.remove(fruit);
 *  }
 * }
 * 
 * solution 2: use iterator or listInterator 
 * for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) 
 * https://stackoverflow.com/questions/23674666/how-to-add-values-to-a-list-while-iterating-it
 * 
 * *** JAVA Iterator: Iterator vs listIterator
 * Interator only have remove();
 * listIterator has add(), previous(), previousIndex(), nextIndex();
 * 
 * method 2: only check and do merging when newInterval is overlapping with cur ele
 * https://discuss.leetcode.com/topic/7808/short-and-straight-forward-java-solution
 * 
 * @author jingjiejiang
 * @history Jun 16, 2017
 */
public class InsertInterval {
	
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	/*
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> list = new LinkedList<>();
        
        if (null == intervals || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }
        
        Interval tmp = new Interval();
        for (int i = 0; i < intervals.size(); i ++) {
            tmp = intervals.get(i);
            if (newInterval.end < tmp.start) {
                list.add(newInterval);
                while (i < intervals.size()) {
                    list.add(intervals.get(i ++));
                }
                break;
            }
            // *** for [[1,5]] [6,8]  [[1,5]] --> [[1,5],[6,8]]
            // *** [[1,2],[4,5],[6,7]] [8,9] --> add until [6,7]
            else if (newInterval.start > tmp.end) {
                list.add(tmp);
                // *** for [[1,5]] [6,8]  [[1,5]] --> [[1,5],[6,8]]
                if (i == intervals.size() - 1) {
                    list.add(newInterval);
                }
            }
            // 1) newInter.end == tmp.begin; 
            else {
                tmp.start = Math.min(newInterval.start, tmp.start);
                tmp.end = Math.max(newInterval.end, tmp.end);
                newInterval = tmp;
                // *** do not add tmp to list unless it is the last
                if (i == (intervals.size() - 1)) list.add(newInterval);
            }
        }
        return list;
    }
	*/
	
	// refactoring version
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> list = new LinkedList<>();
        
        if (null == intervals || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }
        
        Interval tmp = new Interval();
        for (int i = 0; i < intervals.size(); i ++) {
            tmp = intervals.get(i);
            if (newInterval.end < tmp.start) {
                list.add(newInterval);
                while (i < intervals.size()) list.add(intervals.get(i ++));
                break;
            }
            // *** for [[1,5]] [6,8]  [[1,5]] --> [[1,5],[6,8]]
            // *** [[1,2],[4,5],[6,7]] [8,9] --> add until [6,7]
            else if (newInterval.start > tmp.end) list.add(tmp);
            // 1) newInter.end == tmp.begin; 
            else {
                tmp.start = Math.min(newInterval.start, tmp.start);
                tmp.end = Math.max(newInterval.end, tmp.end);
                newInterval = tmp;
                // *** do not add tmp to list unless it is the last
                // if (i == (intervals.size() - 1)) list.add(newInterval);
            }
            
            // for newInterval.start > tmp.end and newInter is overlapped with tmp
            // *** for [[1,5]] [6,8]  [[1,5]] --> [[1,5],[6,8]]
            if (i == intervals.size() - 1) list.add(newInterval);
        }
        return list;
    }
	
	// cann't use Iterator.next() to return Interval, as the class does not have assign method
	/* 
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        if (null == intervals || intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        
        boolean isStart = true;
        for (ListIterator<Interval> iterator = intervals.listIterator(); iterator.hasNext() == true; ) {
            
            Interval tmp = iterator.next();
            if (newInterval.end < tmp.start) {
                iterator.add(newInterval);
                if (isStart == true) break ;
            }
            else if (newInterval.start > tmp.end) {
                isStart = false;
                continue;
            }
            // 1) newInter.end == tmp.begin; 
            else {
                iterator.remove();
                tmp.start = Math.min(newInterval.start, tmp.start);
                tmp.end = Math.max(newInterval.end, tmp.end);
                newInterval = tmp;
                iterator.add(tmp);
                isStart = false;
            }
        }
        
        return intervals;
        
        
    }
	*/
}
