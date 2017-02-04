import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinNumOfArrBurstBal {

	public static int findMinArrowShots(int[][] points) {
        // idea: Greedy method
        // 1) sort the points first, then use arrows to cover all the points
        // 2) *** why I cannot figure out the solution? I thought the to get the points one by one from the points set,
        // then I cannot get solve the question. The solution is from arrow to points, reverse my thinking
        // Things learned: 1) min, max like questions, think about DP, greedy and divide and conquer, cause there is not
        // other way.
        // 2) reverse thinking
        // 3) the use of java comparator
        
        // http://www.cnblogs.com/grandyang/p/6050562.html
        // 然后我们将res初始化为1，因为气球数量不为0，所以怎么也得先来一发啊，然后这一箭能覆盖的最远位置就是第一个气球的
        // 结束点，用变量end来表示。然后我们开始遍历剩下的气球，*如果当前气球的开始点小于等于end*，说明跟之前的气球有重合，
        // 之前那一箭也可以照顾到当前的气球，此时我们要更新end的位置，*end更新为两个气球结束点之间较小的那个*，这也是当前
        // 气球和之前气球的重合点，然后继续看后面的气球；如果某个气球的起始点大于end了，说明前面的箭无法覆盖到当前的气球
        // ，那么就得再来一发，既然又来了一发，那么我们此时就要把end设为当前气球的结束点了，这样贪婪算法遍历结束后就能得
        // 到最少的箭数了
        
		// implementation ref: https://discuss.leetcode.com/topic/66579/java-greedy-soution
		
        // hanlde malinput
        if (null == points || 0 == points.length || 0 == points[0].length) {
            return 0;
        }
        
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        }); 
        
        int arrowLimit = points[0][1];
        int arrowCount = 1;
        for (int i = 1; i < points.length; i ++) {
            if (points[i][0] > arrowLimit) {
                arrowCount ++;
                arrowLimit = points[i][1];
            }
            else {
                arrowLimit = Math.min(points[i][1], arrowLimit);
            }
        }
        
        return arrowCount;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //int[][] test = {{10,16},{2,8},{1,6},{7,12}};
        
		int[][] test = {{1,1},{2,2},{3,3}};
		
		int a = findMinArrowShots(test);
	}

}
