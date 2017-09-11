import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 368. Largest Divisible Subset
 * 
 * round 1: unsolved, but close. used 2hr45m to reach the solution.
 * 
 * idea: 
 * 1. I first think about brutal force then try to optimise from brutal force
 * 
 * 2. I found that if 8 % 4 ==0. 4 % 2 == 0, then 8 % 2 must == 0
 * which means for each brutal force substep, (e.g. 1 2 4 8)
 * I can only calculate one division, 8 % 4 == 0, means 8 % (2/1) == 0
 * 
 * 3. so next question is how to save the information? 
 * e.g. i draw an example
 *       1 2 4 8
 * init. 1 0 0 0
 *    1  1 2 2 2
 *    2  1 2 3 3
 *    3  1 2 3 4
 * i reach the conlusion that when nums[j] % nums[i] == 0, len of nums[j]
 * = len of nums[i] + 1, there comes the DP
 * 
 * 4. the question requests to return a list, i was stuck on how to save the 
 * list. I tend to save the list in one go, however, i found out it is very
 * complicated, for example, 1 2 3 4 6 8 10 12 15 16 20, for every number i
 * need to keep a list for it. then i went no where.
 * *** Missed: the fact is i do not need to save it, i can used the index of
 * max value of the longest list to get the ele of the list.
 * ref: https://discuss.leetcode.com/topic/49741/easy-understood-java-dp-solution-in-28ms-with-o-n-2-time
 * 
 * 5. i used the wrong method to get the list.
 * 1) i first thought about get the list by dividing the ele from maxNumPos 
 * to start, if nums[max] % nums[x] == 0, then add it to list
 * *** it may happen that add nums that are not in the list
 * 1 3 4 12 (3 is not in the longest list)
 * 
 * 2) then i came out an idea of dividing from maxNumPos to start, first add 
 * all x that nums[maxNumPos] % nums[x] == 0. then for each
 * num at pos x, i check from x to 0, if there is y, nums[x] % nums[y] == 0.
 * curMaxlen --, if finally curMaxLen == 1, keep it in the list, otherwise
 * remove it.
 * *** it turned out wrong for 1) 1 2 3 4 12, when 2 and 3 have same dp val 2.
 * 2) if there is multiple nums that can be divided by cur max, the curlen may
 * become minus val, which end up with removing an ele from the list.
 * 
 * *** the right solution is to use the length information saved in DP array.
 * therefore, for each current x
 * we can check dp[x] = cur maxLen - 1 && curMaxNum % nums[x] == 0
 * if == true, then add nums[x] to list. 
 * 
 * @author jingjiejiang
 * @history 
 * 1.Sep 11. 2017
 */
public class LargestDivisibleSubset {
	
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> list = new LinkedList<Integer>();
        if (null == nums || 0 == nums.length) return list;
            
        // sort
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        // *** i only initiate dp[0] = 1 at the beginning, which is wrong
        Arrays.fill(dp, 1);
        
        int maxLen = 1; 
        // the pos of the biggest num in the group
        int maxNumPos = 0;
        
        // find the longest group and the biggest num in the longest group
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] % nums[i] == 0)
                    dp[j] = dp[i] + 1;
                if (dp[j] > maxLen) {
                    maxLen = dp[j];
                    maxNumPos = j;
                }
            }
        }
        
        list.add(nums[maxNumPos]);
        // should use the set length stored in dp here
        // conditions: dp[x] = cur maxLen - 1 && curMaxNum % nums[x] == 0
        // when there is a match cur maxlen --; curMaxNum = nums[x]
        for (int i = maxNumPos - 1; i >= 0; i --) {
            if (dp[i] == maxLen - 1 && nums[maxNumPos] % nums[i] == 0) {
                list.add(0, nums[i]);
                maxLen --;
                maxNumPos = i;
            }
        }
        
        return list;
        // from end to front, get the all ele that max % ele == 0
        // from ele that is most close to max, check whether their
        // length = current maxLen (the most close one, maxLen = ori maxLen - 1)
        /*
        for (int i = maxNumPos - 1; i >= 0; i --) {
            if (nums[maxNumPos] % nums[i] == 0)
                list.add(0, nums[i]);
        }
        
        maxLen --;
        for (int i = list.size() - 2; i >= 1; i --) {
            int curMax = list.get(i);
            // *** for case 1 2 3 4 12 (2 3 has the same maxLen val)
            if (list.get(i + 1) % curMax != 0) {
                list.remove(i);
                continue;
            }
            int curLen = maxLen;
            // *** there is a problem here, other non set nums can also divided by
            // curMax. which may lead to curLen as 0, so the method does not work
            for (int j = i - 1; j >= 0; j --) {
                // *** this condition is not enough
                if (curMax % list.get(j) == 0)
                    curLen --;
            }
            
            if (curLen == 1) maxLen --;
            else list.remove(i);
        }
        */
    }

}
