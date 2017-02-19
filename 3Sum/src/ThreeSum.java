import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
	    // method 2: https://discuss.leetcode.com/topic/8125/concise-o-n-2-java-solution
        // core idea: sort the array, from low and high, according the sum of low and high, shift low to right
        // shift hight to left.
        
        // things learned: 1) Arrays.asList(nums[i], nums[lo], nums[hi])
        
		int target = 0;
        // sort array
        List<List<Integer>> res = new LinkedList<>();
        if (null == nums || 0 == nums.length) {
            return res;
        }
        
        Arrays.sort(nums);
        // iterate through nums
        // avoid duplicate number
        // sum = target - nums[i]
        // allocate low and high
        for (int i = 0; i < nums.length - 2; i ++) {
            // coz the target is 0, if min > 0, then it is impossible to reach 0. 
            // ref: https://discuss.leetcode.com/topic/32302/java-minor-improve-beats-95
            // improvement of method 2
            if(nums[i] > 0) break; 
            
            if(i > 0 && nums[i] == nums[i-1])
                continue;
                
            int low = i + 1;
            int high = nums.length - 1;
            int sum = target - nums[i];
            // while low < high
            // 1) if low + high == sum, 
            // a. add the date to result list
            // b. find the next avil low and high
            // 2) low + high < sum, low ++
            // 3) low + high > sum, low --
            // *** my improvement of method 2: if min > sum, there no need to continue
            if(nums[low] > sum) 
                continue;
                
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1])
                        low ++;
                    while (low < high && nums[high] == nums[high - 1])
                        high --;
                    low ++;
                    high --;
                }
                else if (nums[low] + nums[high] < sum) {
                    low ++;
                }
                else {
                    high --;
                }
            }
        }
        return res;
        
        // idea: method 1: use hashtable to find match (simliar to 4sum, but exceed time limit)
        // as the solution contains index, so the hash must be Key: num, value: index
        // Inspired by the solution of 4sum https://leetcode.com/problems/4sum/
        // 1) how to construct the hashtable
        // construct hash for key: sum of two nums (nums[i] + nums[j]), value : [i, j]
        // 2) how to find match: go through nums one by one find hash.containsKey(target - nums[i])
        // 3) *** hanlde repeat: (I did not know how to hanlde repeat numbers) 
        // a. when construct hash table,simplely check key replicates sort the nums, skip the nums with same value
        // b. when search from nums to void replicate, 
        // 4) *** handle ordering problem: check the num[i] which is the min in doubles, if it is bigger than the num
        // of the looping nums, then add to the list.
        /*
        // target number
        int target = 0;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        
        // edge case
        if (null == nums || 0 == nums.length) {
            return res;
        }
        
        int[] duplicates = new int[nums.length];
        duplicates = nums;
        Arrays.sort(nums);
        
        // add nums and 0 - num to a hashtable
        // use List<int[]>, coz there might be multiple doubles have the same sum
        Map<Integer, List<int[]>> hashMap = new HashMap<Integer, List<int[]>>();
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                int temp = nums[i] + nums[j];
                if (false == hashMap.containsKey(temp)) {
                    List<int[]> list = new LinkedList<>();
                    list.add(new int[]{i, j});
                    hashMap.put(temp, list);
                }
                else {
                    List<int[]> list = hashMap.get(temp);
                    list.add(new int[]{i, j});
                    hashMap.put(temp, list);
                }
            }
        }
        
        for (int index = 0; index < nums.length; index ++) {
        	
            int temp = target - nums[index];
            if (true == hashMap.containsKey(temp)) {
                
                List<int[]> list = hashMap.get(temp);
                // *** this is to record whether the current loop is the first time
                boolean flag = false;
                for (int i = 0; i < list.size(); i ++) {
                    
                    int[] pairs = list.get(i);
                    if (pairs[0] <= index)
                        continue;
                    
                    if (true == flag && res.get(res.size()-1).get(2) == nums[pairs[1]])
                        continue;
                    
                    List<Integer> data = add(nums[index], nums[pairs[0]], nums[pairs[1]]); 
                    res.add(data);
                    flag = true;
                }
            }
        }
        
        return res;
        */
    }
    
	/*
	// part of method 1
    private static List<Integer> add(int i,int j,int k){
        List<Integer> list = new ArrayList<Integer>(3);
        list.add(i);
        list.add(j);
        list.add(k);
        return list;
    }
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list = threeSum(data);
		
	}

}
