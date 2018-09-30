package PreviousQuestions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author jingjiejiang Sep 30, 2018
 *
 */
public class Temp {

	public static int findMinArrowShots(int[][] points) {
        // sort the points
		// iterate through
		// 1) get the range of current point A, count ++
		// 2) skip points until, B.min > A.max, then repeat for 1
		
		if (points == null || points.length == 0) return 0;
		
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? (a[1] - b[1]) : a[0] - b[0];
			}
		});
		
		int count = 1;
		int curEnd = points[0][1];
		
		for (int index = 0; index < points.length; index ++) {
			if (points[index][0] > curEnd) {
				curEnd = points[index][1];
				count ++;
			}
            
			curEnd = Math.min(curEnd, points[index][1]);
		}
		
		return count;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{2, 1};
//		System.out.println(jump(nums));
	}

}
