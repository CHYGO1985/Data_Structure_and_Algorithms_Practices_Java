/**
 * 
 * 290. Word Pattern
 * 
 * @author jingjiejiang
 * @history Sep 7, 2020
 */
class Solution {
  public boolean wordPattern(String pattern, String str) {
      
      if ( (pattern == null && str != null) ||
           (pattern != null && str == null) ) {
          return false;
      }
      
      String[] words = str.split(" ");
      
      if (words.length != pattern.length()) return false;
      
      Map<Character, String> charWordMap = new HashMap<>();
      Set<String> wordsSet = new HashSet<>();
          
      for (int idx = 0; idx < pattern.length(); idx ++) {
          
          char curChar = pattern.charAt(idx);
          String preWordForCurChar = charWordMap.getOrDefault(curChar, "");
          
          if (preWordForCurChar == "") {
              if (wordsSet.contains(words[idx]) == false) {
                  charWordMap.put(curChar, words[idx]);
                  wordsSet.add(words[idx]);
                  continue;
              } else {
                  return false;
              }
          } else {
              if (preWordForCurChar.equals(words[idx]) == false) return false;
          }        
      }    
          
      return true;
  }
}