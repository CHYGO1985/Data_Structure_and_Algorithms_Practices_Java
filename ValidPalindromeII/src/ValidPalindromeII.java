
/**
 * 680. Valid Palindrome II
 * 
 * round 1: 1.5 hours, solved, two pointers tech + recursive method.
 * 
 * idea: 1) I first thought about using array to count even and odd apprearance, than I realised
 * for case like baebcabacea, aacceebbb, the method does not work.
 * 
 * 2) so i went with method brutal force --> skip one char from 0 to end, check whether there is
 * a valid palindrome, then of course, TLE
 * 
 * 3) then I think about treat it as a usual palindrome, use two pointers tech to check equal pairs
 * if meet one mismatch then go to next one, either left + 1 OR right - 1. then I meet another case
 * that if cuuu ... uuucu, in this case we should do right - 1, but my method will go with left + 1,
 * so I realise it is a recursive problem, when meet mistach check both left + 1 AND right - 1.  
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 17, 2017
 */
public class ValidPalindromeII {
	
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
	
	// 7 lines solution
	public boolean validPalindrome(String s) {
        
        return isValid(s, -1, s.length(), 0);
    }
    
    private boolean isValid(String s, int left, int right, int count) {
        
        while ( ++ left <= -- right) 
        	if (s.charAt(left) != s.charAt(right)) {
                if (count == 1) return false;
                return isValid(s, left + 1, right, 1) | isValid(s, left, right - 1, 1);
            }
        
        return true;
    }
}
