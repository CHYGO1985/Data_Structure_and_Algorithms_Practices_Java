package String;

/**
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 17, 2017
 * 2. Feb 24, 2019
 * 
 */
public class ValidPalindrome {
	
	/*
	public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        return isValid(s, left, right, 0);
    }
    
    private boolean isValid(String s, int left, int right, int count) {
        
        while (left <= right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                if (count == 1) return false;
//                else {
//                    if (left + 1 == right) return true;
//                    else {
//                        return isValid(s, left + 1, right, 1) | isValid(s, left, right - 1, 1);
//                    } 
//                }
//            }
        	// further optimise
        	if (s.charAt(left) != s.charAt(right)) {
                if (count == 1) return false;
                else return isValid(s, left + 1, right, 1) | isValid(s, left, right - 1, 1);
            }
            left ++;
            right --;
        }
        
        return true;
    }
    */
	
	public static boolean isPalindrome(String s) {
        
		if (s == null || s.length() == 0) return true;
		
		int head = 0, tail = s.length() - 1;
		// The prob of two pointers is to tell the dif between unmatch head >= tail and match head >= tail
		
		while (head < tail) {
			char headChar = s.charAt(head);
			char tailChar = s.charAt(tail);
			// Character.isLetterOrDigit, Character.toLowerCase
			while (Character.isLetterOrDigit(headChar) == false && head < tail) {
				head ++;
				headChar = s.charAt(head);
			}
			while (Character.isLetterOrDigit(tailChar) == false && head < tail) {
				tail --;
				tailChar = s.charAt(tail);
			}
			
			if (head >= tail) break;
			
			if (Character.toLowerCase(headChar) == Character.toLowerCase(tailChar)) {
				head ++;
				tail --;
			} else {
				return false;
			}
		}
		
		return true;
    }
    
    public static void main(String[] args) {
//    	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    	System.out.println(isPalindrome("0P"));
    }
}
