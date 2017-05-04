import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	
	public List<String> generateParenthesis(int n) {
        // round 1: spend 3 hours, 2ms solution, beat 93.27%
        // idea: permutation --> DFS
        // 1. first one must be "(", the last one must be ")"
        // round 1: *** did not think about case like ())( and ()())(...
        
        // *** 1. Arrays.toString() is not only transfer the content of array to string: char[] ca = {'(', ')'};
        // Arrays.toString(ca) = "[(, )]"
        // *** 2. best way of converting array to: String a = new String(array);
        // *** 3. DFS: always remember to record temp status, and then return the original status after each dfs call
        
        // round 2:
        
        List<String> list = new LinkedList<String>();
        if (n == 0) {
            list.add("");
            return list;
        }
            
        // *** the length should be n*2
        char[] permu = new char[n*2];
        permu[0] = '(';
        // *** initialise all the permu, so do not need to fill it with ')' every time when need to add to the linkedlist
        for (int i = 1; i < permu.length; i ++)
            permu[i] = ')';
        dfs(1, n - 1, permu, list, 1, 0);
        return list;
    }
    
    private void dfs(int startIndex, int count, char[] permu, List<String> list, int gap, int preAvail) {
        
        if (count == 0) {
            // add permu to list
            list.add(new String(permu));
            return;
        }
        
        for (int i = startIndex; i < permu.length - 1; i ++) {
            // *** I did not consider ())(() where the gap > exsiting the num of (
            // *** the calculation of gap is revised when this ((()))() is missing, n = 4
            if (count > 0 && (i - preAvail - 1 <= gap)) {
                permu[i] = '(';
                
                int tempGap = gap;
                gap ++;
                gap = gap - (i - preAvail - 1);
                
                count --;
                int temp = preAvail;
                preAvail = i;
                // *** every time, start from i + 1
                dfs(i + 1, count, permu, list, gap, preAvail);
                permu[i] = ')';
                count ++;
                preAvail = temp;
                gap = tempGap;
            }
        }
    }
    
    /*
    // refactoring
    private void addArrToList(char[] permu, List<String> list) {
        
        for (int i = 1; i < permu.length - 1; i ++) {
            if (permu[i] != '(')
                permu[i] = ')';
        }
        list.add(new String(permu));
    }
    */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
