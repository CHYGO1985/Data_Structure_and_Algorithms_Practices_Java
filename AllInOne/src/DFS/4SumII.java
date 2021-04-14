/**
 * 
 * 454. 4Sum II
 * 
 * @author jingjiejiang
 * @history Apr 14, 2021
 * 
 */
public class 4SumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        assert nums1 != null && nums2 != null && nums3 != null && nums4 != null;

        // sum : count
        Map<Integer, Integer> sumCnt = new HashMap<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int curSum = num1 + num2;
                sumCnt.put(curSum, sumCnt.getOrDefault(curSum, 0) + 1);
            }
        }

        int res = 0;
        for (int num3: nums3) {
            for (int num4 : nums4) {
                int curSum = num3 + num4;
                res += sumCnt.getOrDefault(0 - curSum, 0);
            }
        }

        return res;
    }
}
