package src.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 49. Group Anagrams
 * 
 * @author jingjiejiang
 * @history Apr 23, 2022
 * 
 */
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
        
    assert strs != null && strs.length >= 1;

    Map<String, List<String>> strsMatchMap = new HashMap<>();

    for (int idx = 0; idx < strs.length; idx ++) {

      int[] charsArr = new int[26];
      Arrays.fill(charsArr, 0);
      for (char letter: strs[idx].toCharArray()) {
        charsArr[letter - 'a'] += 1;
      }

      StringBuilder strBuilder = new StringBuilder();
      for (int pointer = 0; pointer < 26; pointer ++) {
        strBuilder.append("#");
        strBuilder.append(charsArr[pointer]);
      }

      String key = strBuilder.toString();
      if (!strsMatchMap.containsKey(key)) {
        strsMatchMap.put(key, new ArrayList<>());
      }

      strsMatchMap.get(key).add(strs[idx]);
    }

    return new ArrayList(strsMatchMap.values());
  }
}
