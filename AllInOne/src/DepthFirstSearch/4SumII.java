/**
 * 
 * 454. 4Sum II
 * 
 * @author jingjiejiang
 * @history Apr 14, 2021
 * 
 */
public class 4SumII {
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
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

    // extedn to 5 sum, 6 sum ... N sum
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        assert nums1 != null && nums2 != null && nums3 != null && nums4 != null;


        Map<Integer, Integer> sumCntMap = new HashMap<>();
        int[][] matrix = new int[][]{nums1, nums2, nums3, nums4};
        addToMap(matrix, sumCntMap, 0, 0);

        return findCompliments(matrix, sumCntMap, matrix.length / 2, 0);
    }

    private void addToMap(int[][] matrix, Map<Integer, Integer> sumCntMap, int rowIdx, int sum) {

        if (rowIdx >= matrix.length / 2) {
            sumCntMap.put(sum, sumCntMap.getOrDefault(sum, 0) + 1);
            return ;
        }

        for (int num : matrix[rowIdx]) {
            addToMap(matrix, sumCntMap, rowIdx + 1, sum + num);
        }
    }

    private int findCompliments(int[][] matrix, Map<Integer, Integer> sumCntMap, int rowIdx, int sum) {

        if (rowIdx >= matrix.length) {
            return sumCntMap.getOrDefault(sum, 0);
        }

        int res  = 0;

        for (int num : matrix[rowIdx]) {
            res += findCompliments(matrix, sumCntMap, rowIdx + 1, sum - num);
        }

        return res;
    }
}
