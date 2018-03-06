package FindKClosestElements;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> list = new LinkedList<>();
        
        int pos = Arrays.binarySearch(arr, 1);
        pos = pos < 0 ? - (pos + 1) : pos;
        
        // pos == -1/0;
        // add from 0 to k - 1
        
        // pos in the mid (+/-)
        // -1,+1,-2,+2 until k-1
        // (pos - 0) == left numbers of eles
        // right: pos + 1 to pos + pos - 0
        
        
        // pos == arr.length - 1/-arr.length - 1
        // add from arr[arr.length - 1] to arr.length - (k - 1)
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
