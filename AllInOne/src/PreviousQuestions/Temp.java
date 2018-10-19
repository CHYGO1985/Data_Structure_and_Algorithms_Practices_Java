package PreviousQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author jingjiejiang Oct 18, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int[][] reconstructQueue(int[][] people) {
		// sort the array as h in descend order and k in ascend order
		// insert the people in to a list with pos at k
		// conver list to array
		if (people == null || people.length == 0 || people[0].length == 0)
			return people; 
        
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
			}
		});
		
		List<int[]> list = new LinkedList<>();
		
		for (int[] person : people) {
			list.add(person[1], person);
		}
		
		return list.toArray(new int[people.length][2]);
    }
	
	public static void main(String[] args) {
	}
}
