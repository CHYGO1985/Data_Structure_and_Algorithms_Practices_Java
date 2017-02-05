import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {

	public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
    }
	
	public List<Interval> merge(List<Interval> intervals) {
        // idea: method 1: sort the list according to the start, then compare intervel A and B (B is after A)
        // 1) if B.start >= A.start && B.start <= A.end (after sorting, B.start must bigger than A.start)
        // A.end = B.end; list.remove(B)
        // 2) else B.start >= A.end, then do nother
		// things learned: 1) the use of sort(List<T> list, Comparator<? super T> c), *** I one put in Comparator<> should
        // be Interval, not List<Interval>
        // 2) when iterate through a list and doing removing at the same time, be careful about the index
        // 3) reverse thinking for array, list, string...
        // result: 38ms, beat 13%
        /*
        if (null == intervals || 0 == intervals.size() || 1 == intervals.size()) {
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }    
        });
        
        Interval front = intervals.get(0);
        for (int i = 1; i < intervals.size(); i ++) {
            
            Interval rear = intervals.get(i);
            // sorted, so rear.start must >= front.start
            if (rear.start <= front.end) {
                // *** I did not consider the case that when rear.end < front.end
                if (rear.end > front.end) {
                    front.end = rear.end;
                }
                // *** here is another place that can easily make error: 
                // if one Interval is deleted from the list, then if i does not change, the next one will be skipped
                // so i must --
                intervals.remove(i --);
            }
            else {
                front = rear;
            }
        }
        
        return intervals;
        */
        
        // method 2: do the same thing from behind (reverse thinking) -- second round try this one
        // ref: https://discuss.leetcode.com/topic/33690/14ms-java-in-place-merge-solution
        // result: 26ms, beat 73%
        
        if (null == intervals || 0 == intervals.size() || 1 == intervals.size()) {
            return intervals;
        }
        
        int N = intervals.size();
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval i, Interval j){
                    return i.end - j.end;
        	}
        });
        for(int i = N-1; i>0;i--){
            Interval inter1 = intervals.get(i-1);
            Interval inter2 = intervals.get(i);
            if(inter1.end >= inter2.start){
                inter1.start = Math.min(inter1.start, inter2.start);
                inter1.end = inter2.end; //inter1.end is always smaller than inter2.end because of the sort, so no need to use Math.max()
                intervals.remove(i);
            }
        }
        return intervals;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
