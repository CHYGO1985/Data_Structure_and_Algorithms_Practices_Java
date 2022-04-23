/**
 * 
 * 242. Valid Anagram
 * 
 * @author jingjiejiang
 * @history Apr 23, 2022
 * 
 */
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
  
    assert s != null && t != null && s.length() >= 1 && t.length() >= 1;
        
    if (s.length() != t.length()) return false;

    int[] charCntArr = new int[26];
    int charSum = 0;
    
    for (char letter : s.toCharArray()) {
        charCntArr[letter - 'a'] += 1;
        charSum ++;
    }
    
    for (char letter : t.toCharArray()) {
        
        if (charCntArr[letter - 'a'] == 0) return false;
        // if charCntArr[letter - 'a'] > 0
        charCntArr[letter - 'a'] -= 1;
        charSum --;
    }        
    
    return charSum == 0? true : false;
  }
}
