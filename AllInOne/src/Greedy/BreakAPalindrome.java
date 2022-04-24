/**
 * 
 * 1328. Break a Palindrome
 * 
 * @author jingjiejiang
 * @history Apr 24, 2022
 * 
 */
public class BreakAPalindrome {
  public String breakPalindrome(String palindrome) {
     
    // find first non "a" char, replace it as a
    // if all "a", the last one as b
    // if one char, return "";
    assert palindrome != null && palindrome.length() >= 1;

    if (palindrome.length() == 1) return "";

    char[] palindromeArr = palindrome.toCharArray();

    for (int idx = 0; idx < palindrome.length() /2; idx ++) {
      if (palindromeArr[idx] != 'a') {
        palindromeArr[idx] = 'a';
        return String.valueOf(palindromeArr);
      }
    }

    palindromeArr[palindrome.length() - 1] = 'b';

    return String.valueOf(palindromeArr);
  }
}
