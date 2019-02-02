package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author jingjiejiang Feb 2, 2019
 *
 */
public class NextGreaterEleI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
		if (nums2.length == 0) return new int[]{};
		
		int[] res = new int[nums1.length];
		// num : greater num
		Map<Integer, Integer> greaterMap = new HashMap<>();
		Stack<Integer> numStack = new Stack<>();
		
		numStack.push(nums2[0]);
		
		for (int num : nums2) {
			while (numStack.isEmpty() == false && num > numStack.peek()) {
				greaterMap.put(numStack.pop(), num);
			}
			numStack.push(num);
		}
		
		for (int idx = 0; idx < nums1.length; idx ++) {
			res[idx] = greaterMap.getOrDefault(nums1[idx], -1);
		}
		
		return res;
    }
}
