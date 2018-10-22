package PreviousQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jingjiejiang Oct 23, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public boolean isPossible(int[] nums) {
        
	    // use map to count frequency of each num in nums
		// use pontencialMap to record potential sub num for a 3 digits raw
		// for (num : nums)
		// if (map.get(num) == 0) continue
		// else if (potentialMap.getOrDefault() > 0) append num + 1, append(num).cnt - 1
		// else if (num + 1, num + 2 exist in map) (num + 1).cnt --, (num + 2).cnt --, append.num + 3
		// else return false
		// num.cnt ---
		
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> potencialMap = new HashMap<>(); 
		
		for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
		
		for (int num : nums) {
			if (map.get(num) == 0) continue;
			else if (potencialMap.getOrDefault(num, 0) > 0) {
				potencialMap.put(num, potencialMap.get(num) - 1);
				potencialMap.put(num + 1, potencialMap.getOrDefault(num + 1, 0) + 1);
			}
			else if (map.getOrDefault(num + 1, 0) > 0 && map.getOrDefault(num + 2, 0) > 0) {
				map.put(num + 1, map.get(num + 1) - 1);
				map.put(num + 2, map.get(num + 2) - 1);
				potencialMap.put(num + 3, potencialMap.getOrDefault(num + 3, 0) + 1);
			}
			else return false;
			map.put(num, map.get(num) - 1);
		}
		
		return true;
    }
	
	public static void main(String[] args) {
	}
}
