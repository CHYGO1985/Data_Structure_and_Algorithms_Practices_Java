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

      
    }

    return new ArrayList(MatchMap.values());
  }
}
