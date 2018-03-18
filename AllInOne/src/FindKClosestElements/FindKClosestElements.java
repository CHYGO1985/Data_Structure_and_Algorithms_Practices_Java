package FindKClosestElements;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 * 
 * 1. unsolved, 
 * was aiming to find low and high, but only need to find low;
 * 
 * @author jingjiejiang
 *
 */
public class FindKClosestElements {
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        
		List<Integer> list = new LinkedList<>();
        
        int pos = Arrays.binarySearch(arr, x);
        pos = pos < 0 ? - (pos + 1) : pos;
        if (k == 0) {
            return list;
        }
        if (k == 1) {
            list.add(arr[pos]);
            return list;
        }
        
        int right = pos;
        int left = right - 1;
        int count = 1;
        
        if (arr[pos] == x) {
            right ++;
        }
        
        while (left >= 0 && right < arr.length && count < k ) {
            
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left --;
            }
            else {
                right ++;
            }
            count ++;
        }
        
        while (left >= 0 && count < k) {
            left --;
            count ++;
        }
        
        while (right < arr.length && count < k) {
            right ++;
            count ++;
        }
        
        for (int i = left >= 0 ? left : 0; i < right; i ++) {
            list.add(arr[i]);
        }
        
        return list;
    }

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,2,3,4,5};
		findClosestElements(arr, 4, -1);
	}
}
