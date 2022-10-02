package src.DepthFirstSearch;

import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * 47. Permutations II
 * 
 * @CHYGO1985
 * @history Nov 13, 2020
 * 
 * ref: https://leetcode.com/problems/permutations/discuss/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> resList = new LinkedList<>();

        Arrays.sort(nums);
        dfs(resList, new LinkedList<>(), nums, new boolean[nums.length]);
        
        return resList;
    }
    
    private void dfs(List<List<Integer>> resList, List<Integer> curList, int[] nums, boolean[] visited) {
     
        if (curList.size() == nums.length) {
            
            resList.add(new LinkedList<>(curList));
            return ;
        } else {

            for (int idx = 0; idx < nums.length; idx ++) {
            
                // repeated case: 1 1 1 2  (when iterate to the 3rd 1, and the 2nd 1 is not visited, skip for repeat)
                if (visited[idx] || (idx > 0 && nums[idx] == nums[idx - 1] && !visited[idx - 1])) continue;
                visited[idx] = true;
                curList.add(nums[idx]);
                dfs(resList, curList, nums, visited);
                visited[idx] = false;
                curList.remove(curList.size() - 1);
            }
        }
    }
}