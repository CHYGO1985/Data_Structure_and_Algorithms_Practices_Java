import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class GenerateParentheses {
	
	public static List<String> generateParenthesis(int n) {
        // idea: permutation --> DFS
        // 1. first one must be "(", the last one must be ")"
        
        // *** 1. Arrays.toString() is not only transfer the content of array to string: char[] ca = {'(', ')'};
        // Arrays.toString(ca) = "[(, )]"
        // *** 2. best way of converting array to: String a = new String(array);
        
        List<String> list = new LinkedList<String>();
        char[] permu = new char[n*2];
        permu[0] = '(';
        permu[permu.length - 1] = ')';
        dfs(1, n - 1, permu, list);
        return list;
    }
    
    private static void dfs(int startIndex, int count, char[] permu, List<String> list) {
        
        if (count == 0) {
            // add permu to list
            addArrToList(permu, list);
            return;
        }
        
        for (int i = startIndex; i < permu.length - 1; i ++) {
            if (count > 0) {
                permu[i] = '(';
                count --;
                dfs(i + 1, count, permu, list);
                permu[i] = ' ';
                count ++;
            }
        }
    }
    
    private static void addArrToList(char[] permu, List<String> list) {
        
        for (int i = 1; i < permu.length - 1; i ++) {
            if (permu[i] != '(')
                permu[i] = ')';
        }
        
        list.add(new String(permu));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = generateParenthesis(4);

	}

}
