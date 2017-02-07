import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class SimplifyPath {
	
	public String simplifyPath(String path) {
        // I am not familiar with Unix path, I have no idea what to do.
        // Idea: the use of stack (to reverse the order)
        // ref: https://discuss.leetcode.com/topic/7675/java-10-lines-solution-with-stack/2
        // ref2: unix path: http://teaching.idallen.com/cst8207/12f/notes/160_pathnames.html#dot-and-dot-dot-.-and-..
        
        // things learned: 1) unix path knowledge 2) the use of stakc to reverse the order
        
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            // if it is .., pop the previous directory
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            // for . and "", just ignore
            else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
