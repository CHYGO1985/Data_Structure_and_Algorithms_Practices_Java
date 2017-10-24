
/**
 * The implementation of KMP Algorithm.
 * 
 * @author jingjiejiang
 * @history JJJ May 31, 2017
 */
public class KMPAlgorithm {
	
	public static int[] KMPAlgorithm(String s) {
		
		int len = s.length();
		int[] next = new int[len];
		int prefix = -1;
		int suffix = 0;
		next[suffix] = prefix;
		
		while (suffix < len - 1) {
			if (prefix == -1 || s.charAt(prefix) == s.charAt(suffix)) {
				prefix ++;
				suffix ++;
				next[suffix] = prefix;
			}
			else {
				prefix = next[prefix];
			}
		}
		
		return next;
	}

	public static void main(String[] args) {
		int[] next = KMPAlgorithm("abacccaba");
	}
}
