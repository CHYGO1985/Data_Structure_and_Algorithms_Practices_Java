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
        if (pos == -1 || pos == 0) {
        	for (int i = 0; i < k && i < arr.length; i ++) {
        		list.add(arr[i]);
        	}
        }
        // pos == arr.length - 1/-arr.length - 1
        // add from arr[arr.length - 1] to arr.length - (k - 1)
        else if (pos == arr.length - 1 || pos == -arr.length) {
        	int count = 0;
        	while (count < k && arr.length - 1 - count >= 0) {
        		list.add(arr[arr.length - 1 - count]);
        		count ++;
        	}
        }
        // pos in the mid (+/-)
        // -1,+1,-2,+2 until k-1
        // (pos - 0) == left numbers of elem
        // right: pos + 1 to pos + pos - 0
        else {
        	if (pos < 0) {
        		pos = - (pos + 1);
        	}
        	
        	// two pointers tech to decide the range
        }
        
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
