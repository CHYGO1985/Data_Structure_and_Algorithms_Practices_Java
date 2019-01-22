package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Jan 23, 2019
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end; 
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public boolean isMatch(String s, String p) {
		
		boolean[][] matches = new boolean[p.length() + 1][s.length() + 1];
		matches[0][0] = true;
		for (int row = 1; row < matches.length; row ++) {
			matches[row][0] = p.charAt(row - 1) == '*' ? 
					matches[row - 1][0] : false;
		}
		
		for (int row = 1; row < matches.length; row ++) {
			char rowChar = p.charAt(row - 1);
			for (int col = 1; col < matches[0].length; col ++) {
				char colChar = s.charAt(col - 1);
				if (rowChar == colChar || rowChar == '?') {
					matches[row][col] = matches[row - 1][col - 1];
				} else if (rowChar == '*') {
					matches[row][col] = matches[row - 1][col] || matches[row - 1][col - 1]
							|| matches[row][col - 1];
				} else {
					matches[row][col] = false;
				}
			}
		}
		
		return matches[p.length()][s.length()];
    }
	
	public static void main(String[] args) {
//		int[] arr = new int[]{1,3,4,5,2};
//		int[] nums1 = new int[] {3, 4, 6, 5};
//		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
//		System.out.println(1);
	}
}
