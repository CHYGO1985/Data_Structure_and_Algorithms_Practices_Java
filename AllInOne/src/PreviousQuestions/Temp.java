package PreviousQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author jingjiejiang Oct 2nd, 2018
 *
 */
public class Temp {
	
	public int[][] reconstructQueue(int[][] people) {
		
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
		
	}
}
