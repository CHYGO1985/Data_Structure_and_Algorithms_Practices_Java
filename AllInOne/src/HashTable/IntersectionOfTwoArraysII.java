import java.util.Arrays;

/**
 * 
 * 350. Intersection of Two Arrays II
 * 
 * @author jingjiejiang
 * @history Apr 8, 2021
 * 
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
     
        // we will use the long array to store result and avoid using extra list
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> numCnts = new HashMap<>();

        for (int num : nums2) {
            numCnts.put(num, numCnts.getOrDefault(num, 0) + 1);
        }

        int shiftIdx = 0;
        for (int num : nums1) {
            if (numCnts.getOrDefault(num, 0) == 0) {
                continue;
            }

            nums1[shiftIdx ++] = num;
            numCnts.put(num, numCnts.getOrDefault(num, 0) - 1);
        }

        return Arrays.copyOfRange(nums1, 0, shiftIdx);
    }
}
