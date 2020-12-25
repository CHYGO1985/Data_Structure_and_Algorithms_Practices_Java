/**
 * 
 * 698. Partition to K Equal Sum Subsets
 * 
 * @author jingjiejiang
 * @history Dec 25, 2020
 * 
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        assert nums != null && nums.length >= 1 && nums.length <= 16 && k >= 1;

        int totalSum = 0, len = nums.length;
        for (int num : nums) totalSum += num;
        if (totalSum % k != 0) return false;

        boolean[] visited = new boolean[len];
        Arrays.sort(nums);

        return dfs(nums, 0, len - 1, visited, totalSum / k, k);
    }
    
    // if startPos is 0, for case like 1 2 2 3 3 4 5 (target=5), there will be mismatch for 1 2 2
    // so start from tail is much better
    public boolean dfs(int[] nums, int sum, int curStartPos,
        boolean[] visited, int target, int round) {

        if (round == 0) return true;
        
        if (sum == target && dfs(nums, 0 , nums.length - 1, visited, target, round - 1))
            return true;

        for (int pos = curStartPos; pos >= 0; pos --) {
            
            if (!visited[pos] && sum + nums[pos] <= target) {
                visited[pos] = true;
                if (dfs(nums, sum + nums[pos], pos - 1, visited, target, round)) {
                    return true;
                }
                visited[pos] = false;
            }
        }    
        
        return false;
    }
}