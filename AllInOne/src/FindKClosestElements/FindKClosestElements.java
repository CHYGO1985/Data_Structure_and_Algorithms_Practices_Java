package FindKClosestElements;

import java.util.LinkedList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 * 
 * 1. unsolved, 
 * was aiming to find low and high, but only need to find low;
 * https://leetcode.com/problems/find-k-closest-elements/discuss/106419/O(log-n)-Java-1-line-O(log(n)-+-k)-Ruby
 * 
 * @author jingjiejiang
 *
 */
public class FindKClosestElements {
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        
		List<Integer> list = new LinkedList<>();
        
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid+k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        for (int i = lo; i < lo + k; i ++) {
            list.add(arr[i]);
        }
		
        return list;
    }

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,2,3,4,5};
		List<Integer> res = findClosestElements(arr, 4, -1);
		
		for (int i = 0; i < res.size(); i ++) {
			System.out.println(res.get(i));
		}
	}
}
