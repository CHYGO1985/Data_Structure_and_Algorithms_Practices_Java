package FindSmallestLetterGreaterThanTarget;

/**
 * 
 * 
 * @author jingjiejiang
 * @history
 * 1. Created on Mar 1, 2018
 */
public class FindSmallestLetterGreaterThanTarget {
	
	public static char nextGreatestLetter(char[] letters, char target) {
        
        int left = 0;
        int right = letters.length - 1;
        int mid = 0;
        
        while (left < right) {
            
            mid = (left + right) / 2;
            
            if ((target - 'a') % 26 < letters[mid] - 'a') {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return letters[right - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
