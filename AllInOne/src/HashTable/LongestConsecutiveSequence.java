/**
 * 
 * 128. Longest Consecutive Sequence
 * 
 * @author jingjiejiang
 * @history May 19, 2021
 * 
 * ref: https://leetcode.com/problems/longest-consecutive-sequence/solution/
 * 
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        assert nums != null && nums.length >= 0;

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int maxLen = 0;

        for (int num : nums) {

            // check if num is in an already counted streak
            if (!numSet.contains(num - 1)) {

                int curNum = num;
                int curStreak = 1;

                while (numSet.contains(curNum + 1)) {
                    curNum += 1;
                    curStreak += 1;
                }

                maxLen = Math.max(maxLen, curStreak);
            }
        }

        return maxLen;
    } 
}
