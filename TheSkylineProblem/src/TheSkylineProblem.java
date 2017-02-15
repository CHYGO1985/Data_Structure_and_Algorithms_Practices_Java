import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class TheSkylineProblem {
	
	public static List<int[]> getSkyline(int[][] buildings) {
		// idea ref: 
        // https://segmentfault.com/a/1190000003786782
        /*
        如果按照一个矩形一个矩形来处理将会非常麻烦，我们可以把这些矩形拆成两个点，一个左上顶点，一个右上顶点。将所有顶点按照
        横坐标排序后，我们开始遍历这些点。遍历时，通过一个堆来得知当前图形的最高位置。堆顶是所有顶点中最高的点，只要这个点没
        被移出堆，说明这个最高的矩形还没结束。对于左顶点，我们将其加入堆中。对于右顶点，我们找出堆中其相应的左顶点，然后移出
        这个左顶点，同时也意味这这个矩形的结束。具体代码中，为了在排序后的顶点列表中区分左右顶点，左顶点的值是正数，而右顶点
        值则存的是负数。
        */
        // Core idea: sovle the problem points by points (left top and right top points) instead of rectangular by rectangular
        // by drawing on paper, it shows that the check recangular by rectangular are very complicated, when I reach the point
        // I should think about use points to check.
       
        // implementation ref:
        // https://discuss.leetcode.com/topic/28482/once-for-all-explanation-with-clean-java-code-o-n-2-time-o-n-space
        // result: 135ms, beat 67.83%, fastest is 3ms
        // things learned: 1) abstract and simply question domain. for this question, simplify from rectangular to two points
        // 2) the the parameter in Comparator. the parameter should be the same as data type in compare(type A, type B));
        // 3) use compare (type A, type B) to control ascending or descending: a - b (ascending/natural ordering)
        // b - a (descending)
        
        List<int[]> res = new LinkedList<int[]>();
        
        // edge cases:
        if (null == buildings || 0 == buildings.length || 0 == buildings[0].length) {
            return res;
        }
        
        // store the (left-top and right-top) points of each rectangular
        // 1) sort by coordinate of X axis, (if equals) then sort by height
        // 2) for representing left and right, assign the height of left-top as negative
        List<int[]> points = new LinkedList<int[]>();
        
        for (int[] building : buildings) {
            points.add(new int[]{building[0], -building[2]});
            points.add(new int[]{building[1], building[2]});
        }
        
        // *** 1) the parameter in Comparator(the data type in compare(type A, type B)); 
        Collections.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });
        
        // use a heap to store the height data
        // *** initialise a priority queue
        Queue<Integer> heightQue = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                // *** must return b - a not a - b ??? why?? here use b - a is for descending order, a - b is for ascending
                // order, because compare is for natural ordering (acending)
                // 1) negative: first < second
                // 2) positive: first > second
                // e.g: a < b, if use b - a, then the result is positive, the system will consider a > b, then put a after b
                return b - a;
            }
        });
        int max = 0;
        // points start with 0;
        heightQue.offer(0);
        
        // get points one by one
        // 1) if x < 0, then it is the left points, add the height data to the heap
        // 2) if x > 0, means the current rectangular is over, pop the height data from the heap
        // get cur max height
        // 1) if cur != max height, then add to final res, update the pre max height
        for (int[] point: points) {
            if (point[1] < 0) {
                heightQue.offer(- point[1]);
            }
            else {
                heightQue.remove(point[1]);
            }
            
            int cur = heightQue.peek();
            if (cur != max) {
                res.add(new int[]{point[0], cur});
                max = cur;
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] points =  {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        List<int[]> res = getSkyline(points);
	}

}
