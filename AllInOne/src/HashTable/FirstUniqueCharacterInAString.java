package HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author jingjiejiang Feb 6, 2019
 *
 */
public class FirstUniqueCharacterInAString {

	public static int firstUniqChar1(String s) {
		// * idea: finding matches --> hash table
		// 1. it is not possible to find a non-repeating char without iterate through all the chars in a string
		// --> store repeat information: hash table
		// 2. need to record timeline of fisrt non-repeating char
		
		// method 1: two rounds of iterationg, one round: construct hash table (array): two round: find the chars that in
		// the hash table which value is one (if not, return -1).
		
		// I didn't implement method1. it is strait forward. 
		// https://discuss.leetcode.com/topic/55148/java-7-lines-solution-29ms
		// method 1 is fastert then method 2, even method 1 iterate through string for twice and and method 2 iterate through
		// string for once. as method 2 used complicated data structure (for such small data), I think that is why it is much slower.
		
		// method 2: one round solution. (space exchange for time). need to keep match records and time records
		// ****I was closed to find one iteration solution, but don't know how to keep match records and time
		// infor in one time. The auther used linkedhashmap to solve the problem.https://discuss.leetcode.com/topic/55488/java-one-pass-solution-with-linkedhashmap/2
		// result: 85ms. beat 31.36%
		int result = -1;
		Set<Character> set = new HashSet<Character>();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i ++) {
			
			char temp = s.charAt(i);
			
			// if current char already exist in the set and map, remove it from map
			if (false == set.add(temp)) {
				if (map.get(temp) != null) {
					map.remove(temp);
				}
			}
			// if not, add it to map and set
			else {
				set.add(temp);
				// *** here is the important part, store the index
				map.put(temp, i);
			}
		} 
		
		if (map.size() != 0) {
			// get the first ele in the linkedhashmap that index is 0
			result = map.entrySet().iterator().next().getValue();
		}
		
		return result;
	}

	public static int firstUniqChar1(String s) {

		assert s != null;

		if (s.length() == 1) return 0;

		int[] charCnts = new int[26];
		Arrays.fill(charCnts, 0);

		for (int idx = 0; idx < s.length(); idx ++) {
			charCnts[s.charAt(idx) - 'a'] += 1;
		}

		for (int idx = 0; idx < s.length(); idx ++) {
			if (charCnts[s.charAt(idx) - 'a'] == 1) {
				return idx;
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {

	}
}
