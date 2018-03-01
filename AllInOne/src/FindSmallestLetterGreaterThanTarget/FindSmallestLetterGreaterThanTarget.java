package FindSmallestLetterGreaterThanTarget;

/**
 * 
 * 744. Find Smallest Letter Greater Than Target
 * 
 * Round 1: 1.5 hrs
 * Was stuck on return value.
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
            
            // a > z
            if ((letters[mid] - 'a') > (target - 'a')) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return letters[left] - 'a' > target - 'a' ? letters[left] :
        	(left == letters.length - 1 ? letters[0] : letters[left + 1]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] letters = new char[]{'c','f','j'};
		char target = 'k';
		
		char res = nextGreatestLetter(letters, target);

	}

}
