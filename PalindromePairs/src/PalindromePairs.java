import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PalindromePairs {

	public List<List<Integer>> palindromePairs(String[] words) {
        // round 1: unsolved -> do not now how to iterate through the string quickly to find corresponding palindromes
        // *** method 1: iterate the whole string char by char, check whether there exist palindrome
        // 1) "bat": "" + "bat", "" is still counted as palindrome
        // ref: https://discuss.leetcode.com/topic/40657/150-ms-45-lines-java-solution/2
        // *** Java String.substring(int beginIndex)
        
        List<List<Integer>> res = new LinkedList<>();
        if (null == words || words.length < 2) return res;
        
        // put string in a hashmap, <String, Integer(index)>
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i ++) map.put(words[i], i);
        
        // iterate through all ele in words, and check each char in a string
        // 1) if one of the parts is palindrome including "", reverse the other part, try to find the match in hashmap
        // if find one, add it to list
        for (int i = 0; i < words.length; i ++) {
            for (int j = 0; j < words[i].length(); j ++) {
                String part1 = words[i].substring(0, j);
                String part2 = words[i].substring(j);
                if (isPalindrome(part1) == true) {
                    StringBuilder builder = new StringBuilder();
                    String rev = builder.append(part2).reverse().toString();
                    if (map.containsKey(rev) == true && map.get(rev) != i) {
                        List<Integer> list = new ArrayList<>(2);
                        // *** order matters
                        list.add(map.get(rev));
                        list.add(i);
                        res.add(list);
                    }
                }
                
                if (isPalindrome(part2) == true) {
                    StringBuilder builder = new StringBuilder();
                    String rev = builder.append(part1).reverse().toString();
                    if (map.containsKey(rev) == true && map.get(rev) != i) {
                        List<Integer> list = new ArrayList<>(2);
                        list.add(i);
                        list.add(map.get(rev));
                        res.add(list);
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalindrome(String s) {
        int begin = 0;
        int rear = s.length() - 1;
        while (begin < rear)
            if (s.charAt(begin ++) != s.charAt(rear --)) return false;
        return true;
    }
}
