package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author jingjiejiang Feb 3, 2019
 *
 */
public class InterOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        
		Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> interSet = new HashSet<>();
        
        for (int num1 : nums1) {
        	nums1Set.add(num1);
        }
        
        for (int num2 : nums2) {
        	if (nums1Set.contains(num2) == true) {
        		interSet.add(num2);
        	}
        }
        
        Integer[] resInter = interSet.toArray(new Integer[interSet.size()]);
        int[] res = new int[resInter.length];
        for (int idx = 0; idx < res.length; idx ++) {
        	res[idx] = resInter[idx].intValue();
        }
        return res;
    }
}
