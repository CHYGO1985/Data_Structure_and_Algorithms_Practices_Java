package DepthFirstSearch;

import java.util.List;

/**
 * 
 * @author jingjiejiang Mar 26, 2019
 *
 */
public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
        
    }
	
	private void dfs(String S, List<String> list, int start, StringBuilder builder) {
		
		if (start >= S.length()) {
			list.add(builder.toString());
			return ;
		}
		
		for (int idx = start; idx < S.length(); idx ++) {
			
			char cur = S.charAt(idx);
			if (Character.isLetter(cur)) {
				cur = Character.toUpperCase(cur);
			}
			builder.append(cur);
			dfs(S, list, start + 1, builder);
			
		}
	}
}
