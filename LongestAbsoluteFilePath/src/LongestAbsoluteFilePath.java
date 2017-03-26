
public class LongestAbsoluteFilePath {
	
	public int lengthLongestPath(String input) {
        // idea: iterate through the input, keep in process data
        // split the array (\n), then get max len of each level (the number of \t), add it to the maxLen
        // The most important part is to skip \n and \t
        // *** problem 1: I did not consider multiple parent dir before file dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext 
        
        // I though about using an array to store the length of each level, but do not know how to define the length
        // *** the solution is that \t is the the max of input.split("\n") + 1
        // ref: https://discuss.leetcode.com/topic/55247/9-lines-4ms-java-solution/2
        // the showed exaple used DP to record different level information
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for(String s:paths){
            // when there is not "\t", it will return - 1, so +1 is to prevent minus case.
            int lev = s.lastIndexOf("\t") + 1;
            // this statements can also update the length for the same level
            int curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if(s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
