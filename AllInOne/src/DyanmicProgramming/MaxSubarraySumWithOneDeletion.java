/**
 * 
 * 1186. Maximum Subarray Sum with One Deletion
 * 
 * @author jingjiejiang
 * @hisotry Jan 14, 2021
 * 
 * ref: https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/391424/JAVA-4ms-Solution-short-and-precise-O(n)-With-Explanation
 * 
 */
class Solution {
    public int maximumSum(int[] arr) {

        assert arr != null && arr.length >= 1;

        int del = arr[0], keep = arr[0], res = arr[0];

        for (int idx = 1; idx < arr.length; idx ++) {

            // del is to choose between pre keep (not include the current ele)
            // or choose prev del + current ele (happen when previous negative num is smaller then the current one)
            del = Math.max(keep, del + arr[idx]);
            // keep is to keep the current max sum of con subarr (without deletion)
            keep = Math.max(keep + arr[idx], arr[idx]);
            res = Math.max(res, Math.max(keep, del));
        }

        return res;
    }
}