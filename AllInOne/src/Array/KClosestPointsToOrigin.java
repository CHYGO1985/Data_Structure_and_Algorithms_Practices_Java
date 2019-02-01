package Array;

import java.util.Arrays;

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
        // quick sort
		sort(points, 0, points.length - 1);
		return Arrays.copyOfRange(points, 0, K);
    }
	
	private void sort(int[][] points, int start, int end) {
		
		int left = start, right = end, pivot = left;
		
		while (left < right) {
			while (compare(points, left, pivot) < 0) left ++;
			while (compare(points, right, pivot) > 0) right --;
			
			if (left <= right) {
				int[] tmp = points[left];
				points[left ++] = points[right];
				points[right --] = tmp;
			}
		}
		
		if (start < right) {
			sort(points, start, right);
		}
		
		if (left < end) {
			sort(points, left, end);
		}
	}
	
	private int compare(int[][] points, int left, int right) {
		return points[left][0] * points[left][0] + points[left][1] * points[left][1]
				- points[right][0] * points[right][0] - points[right][1] * points[right][1];
	}
}
