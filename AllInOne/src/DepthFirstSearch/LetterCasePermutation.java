package DepthFirstSearch;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author jingjiejiang Mar 27, 2019
 *
 */
public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
        char[] arr = S.toCharArray();
        List<String> list = new LinkedList<>();
        dfs(list, 0, arr);
        
        return list;
    }
    
    private void dfs (List<String> list, int index, char[] arr) {
        if (index >= arr.length) {
            list.add(String.valueOf(arr));
            return ;
        }
        
        // if it is a digit number, pass to next step
        if (Character.isDigit(arr[index])) {
            dfs(list, index + 1, arr);
        }
        else {
            dfs(list, index + 1 , arr);
            arr[index] = Character.isLowerCase(arr[index]) ? (char)(arr[index] - 32) : (char)(arr[index] + 32);
            dfs(list, index + 1, arr);  
        }
    } 
}
