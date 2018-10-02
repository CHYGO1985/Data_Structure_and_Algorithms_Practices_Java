package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class QueueReconsbyHeight {
	
	public int[][] reconstructQueue(int[][] people) {
        // round 1: did not solve it, should draw on paper to test the idea before implementation
        
        // idea: I should tried different sorting when my previous sorting is not working
        // method 1: sort it as (height descending order first, if height equals, num natural ordering)
		// ref: https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution/5
        // [7.0] [7,1] [6,1] [5,0] []
        // [7,0]
        // [7,0] [7,1]
        // [7,0] [6,1] [7,1] (pos of conflict 1: [7,1] shift to next)
        // [5,0] [7,0] [6,1] [7,1] (conflict 0: all shift to next)
        // ...
        
        // things learned:
        // 1) *** I do not mecessarily need to use Collections 
        // 2) *** papameter for new Comparator new Comparator<int[]>(){
        // 3) *** i was confused about the order again compare(a, b) a-b or b-a
        // Compare(a, b): a -b >0 means a >b, put like b, a
        // use  b - a >0 (in reality) (note the parameters' order are still (a , b)) so now is a > b (the result)
        // so put b, a (desending order)
        
        
		if (people == null || people.length == 0) return new int[0][0];
		
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
			}
		});
		
		List<int[]> list = new ArrayList<>(people.length);
		
		for (int[] person : people) {
			list.add(person[1], person);
		}
		
		return list.toArray(new int[people.length][people[0].length]);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
