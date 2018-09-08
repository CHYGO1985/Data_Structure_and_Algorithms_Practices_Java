package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static boolean canAttendMeetings(Interval[] intervals) {
        List<Interval> list = Arrays.asList(intervals);
        boolean res = true;
        
        Collections.sort(list, new Comparator<Interval>() {
        	@Override
        	public int compare(Interval a, Interval b) {
        		return (a.start != b.start) ? (a.start - b.start) : (a.end - b.end);
        	}
		});
        
        for(int i = 1; i < list.size(); i ++) {
        	Interval preInter = list.get(i - 1);
        	int curStart = list.get(i).start;
        	if (curStart < preInter.end) res = false;
        }
        
        return res;
    }

	public static void main(String[] args) {
		
	}

}
