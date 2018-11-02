package PreviousQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jingjiejiang Nov 2, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static boolean isPossible(int[] nums) {
		// 1 2 3 3 4 5
        // 1 2 3 4 5
        // get count map<num, count>
        // for (0 --> nums) 
        // 3 cases
        // if map.get(nums[i]) == 0 continue;
        // if potentialMap.get(nums[i]) > 0 
        //   potentialMap.[i] count - 1
        //   potentialMap.nums[i] + 1 count + 1
        // if map.get(nums[i] + 1) > 0 && map.get(nums[i] + 2) > 0
        //   map.nums[i]+1 count - 1;
        //   map.nums[i]+2 count - 1;
        //   potentialMap.nums[i] + 2 count + 1
        // return false
		Map<Integer, Integer> numMap = new HashMap<>();
		Map<Integer, Integer> pontentialMap = new HashMap<>();
		
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}
		
		for (int num : nums) {
			if (numMap.get(num) == 0) {
                continue;
            }
			else if (pontentialMap.getOrDefault(num, 0) > 0) {
				pontentialMap.put(num, pontentialMap.get(num) - 1);
				pontentialMap.put(num + 1, pontentialMap.getOrDefault(num + 1, 0) + 1);
			}
			else if (numMap.getOrDefault(num + 1, 0) > 0 && 
                     numMap.getOrDefault(num + 2, 0) > 0) {
				numMap.put(num + 1, numMap.get(num + 1) - 1);
				numMap.put(num + 2, numMap.get(num + 2) - 1);
				pontentialMap.put(num + 3, pontentialMap.getOrDefault(num + 3, 0) + 1);
			}
			else {
				return false;
			}
            
            numMap.put(num, numMap.get(num) - 1);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3, 4, 5};
		isPossible(arr);
	}
}
