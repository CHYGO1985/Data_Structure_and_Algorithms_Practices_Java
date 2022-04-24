/**
 * 
 * 125. Valid Palindrome
 * 
 * @author jingjiejiang
 * @history Apr 23, 2022
 * 
 */
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
        
    assert s != null & s.length() >= 1;
    
    int leftPointer = 0, rightPointer = s.length() - 1;
    s = s.toLowerCase();
    
    while (leftPointer <= rightPointer) {
        
        while ( leftPointer < s.length() && !isAphanumeric(s.charAt(leftPointer)) ) {
            leftPointer ++;
        }
        
        while (rightPointer >= 0 && !isAphanumeric(s.charAt(rightPointer)) ) {
            rightPointer --;
        }

        // use Character.isLetterOrDigit
        // while (leftPointer < s.length() && !Character.isLetterOrDigit(s.charAt(leftPointer))) {
        //   leftPointer ++;
        // }
        
        // while (rightPointer >= 0 && !Character.isLetterOrDigit(s.charAt(rightPointer))) {
        //     rightPointer --;
        // }
        
        if (leftPointer > rightPointer) {
            break;
        }
        
        if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
            return false;
        }
        
        leftPointer ++;
        rightPointer --;
    }
    
    return true;
  }

  private boolean isAphanumeric(char character) {
      
      return  (character - 'a' >= 0 && character - 'a' <= 25)
              || (character - '0' >= 0 && character - '0' <= 9);
  }  
}
