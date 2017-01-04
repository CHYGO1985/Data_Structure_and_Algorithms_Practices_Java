
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
	       
        // key idea: is to use a thing to represent different strings.
        
        // method 1: https://discuss.leetcode.com/topic/24494/share-my-short-java-solution
        // *** result: 28ms, beat 78.78% 
        // * thins learned: 1) I was confined by the idea that hash can only be used for numbers
        // hash can be used for any match
        // 2) sorted string --> used string as a key
        if (strs == null || strs.length == 0) 
            return new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (int i = 0; i < strs.length; i ++) {
            
            String temp = strs[i];
            char[] arr = temp.toCharArray();
            Arrays.sort(arr);
            String keyStr = String.valueOf(arr); // return the string form of arr [a,b,c] --> abc
            
            if (false == map.containsKey(keyStr))
                map.put(keyStr, new LinkedList<String>());
            map.get(keyStr).add(temp);
        }
        
        return new ArrayList<List<String>>(map.values());
        
        // method 2: I was thinking use sum to distinguish strings, in method 2, the author use teh fact of the product of
        // diff primes to represent each string
        // https://discuss.leetcode.com/topic/45639/java-beat-100-use-prime-number/2
        // similar to my method, but use the product of prime number.
        
        /*
        prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
    
            List<List<String>> res = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (String s : strs) {
                int key = 1;
                for (char c : s.toCharArray()) {
                    key *= prime[c - 'a'];
                }
                List<String> t;
                if (map.containsKey(key)) {
                    t = res.get(map.get(key));
                } else {
                    t = new ArrayList<>();
                    res.add(t);
                    map.put(key, res.size() - 1);
                }
                t.add(s);
            }
            return res; 
         
         */
        
        // * My method: group strings that have same --> same sums of chars - 'a' -- > I was wrong, coz, different
        // combination of chars can have the same sum. + sum of (chars in String a - chars in String b) = 0
        
        // method 1:
        // unsolved, 2 hours: 
        // special case
        /*
        // <index, appearance of chars>
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // store result
        List<List<String>> list = new ArrayList<List<String>>();
        int sum = 0;
        int listIndex = 0;
        
        
        for (int i = 0; i < strs.length; i ++) {
        
            List<String> curlist = new LinkedList<String>();
            String temp = strs[i];
            
            for (int j = 0; j < temp.length(); j ++) {
                int key = temp.charAt(j) - 'a';
            }
            
            // if temp is the new string
            int tempIndex = map.getOrDefault(sum, 0);
            if (0 == tempIndex) {
                // if map key start from 0, then map.getOrDefault(sum, 0) will return 0, which means there is no such sum
                for ()
                map.put(sum, listIndex + 1);
                curlist.add(temp);
                list.add(listIndex, curlist);
                listIndex ++;
            }
            // if list has anagram before like temp
            else {
                list.get(tempIndex - 1).add(temp);
            }
            
            sum = 0;
        }
        
        return list;
        */
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
