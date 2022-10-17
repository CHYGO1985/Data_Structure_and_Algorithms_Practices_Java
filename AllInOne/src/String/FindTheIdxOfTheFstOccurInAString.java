package src.String;

/**
 * 
 * 28. Find the Index of the First Occurrence in a String
 * 
 */
public class FindTheIdxOfTheFstOccurInAString {
  public int strStr(String haystack, String needle) {    
    assert haystack != null && needle != null;

    int fstOccurIdx = -1;
    int heysStackIdx = 0;

    for (int idx = 0; idx < haystack.length(); idx ++) {
      int hayIdx = idx;
      int needleIdx = 0;
      while (hayIdx < haystack.length() 
        && haystack.charAt(hayIdx) == needle.charAt(needleIdx)) {
          hayIdx ++;
          needleIdx ++;

          if (needleIdx >= needle.length()) {
            return hayIdx - needle.length();
          }
      }
    }

    return fstOccurIdx;
  }
}


// eeabcd
// idx = 2
// should return 2
// heyidx = 5