package Greedy;
import java.util.Arrays;
import java.util.Comparator;

public class MinNumOfArrBurstBal {

	public static int findMinArrowShots(int[][] points) {
		// sort 
		// arrow = 1, get first ele as pre
		// for ( 1 --> points.len) compare cur with pre
		// if (cur.start < pre.end)
		// also need to check cur.end <= pre.end ? pre.end = cur.end
		// else (cur.start >= pre.end)
		// pre = cur and arrow ++
		if (points == null || points.length == 0) return 0;
		
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]; 
			}
		});
		
		int arrows = 1;
		int[] pre = points[0];
		for (int idx = 1; idx < points.length; idx ++) {
			if (points[idx][0] <= pre[1]) {
				pre[1] = Math.min(points[idx][1], pre[1]);
			}
			else { // points[idx][0] >= pre[1]
				arrows ++;
				pre = points[idx];
			}
		}
		
		return arrows;
    }
    
	public static void main(String[] args) {
        //int[][] test = {{10,16},{2,8},{1,6},{7,12}};
	}

}
