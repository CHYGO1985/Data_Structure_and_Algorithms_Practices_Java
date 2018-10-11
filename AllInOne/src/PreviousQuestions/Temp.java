package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 11, 2018
 *
 */
public class Temp {
	
	public boolean isMatch(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[0][0] = true;
		
		for (int idx = 1; idx < match[0].length; idx ++) {
			if (p.charAt(idx - 1) == '*') match[0][idx] = match[0][idx - 1];
		}
		
		for (int row = 1; row < match.length; row ++) {
			for (int col = 1; col < match[0].length; col ++) {
				if (s.charAt(row - 1) == p.charAt(col - 1) || p.charAt(col - 1) == '?') {
					match[row][col] = match[row - 1][col - 1];
				} 
				else if (p.charAt(col - 1) == '*') {
					match[row][col] = match[row - 1][col - 1] || match[row][col - 1] ||
							match[row - 1][col];
				}
				else {
					match[row][col] = false;
				}
			}
		}
		
		return match[s.length()][p.length()];
    }
	
	public static void main(String[] args) {
	}
}
