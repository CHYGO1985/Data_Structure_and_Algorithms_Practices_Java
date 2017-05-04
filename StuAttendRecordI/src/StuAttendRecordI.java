
public class StuAttendRecordI {
	public boolean checkRecord(String s) {
        // idea: two int to keep count 
        // method 2: Regular Expression
        // return !s.matches(".*LLL.*|.*A.*A.*");
        // ref: https://discuss.leetcode.com/topic/86466/java-1-liner
        
        if (null == s)
            return false;
        if (0 == s.length())
            return true;
        int absent = 0;
        int late = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == 'A') {
                absent ++;
                late = 0;
                if (absent > 1) 
                    return false;
            }
            else if (s.charAt(i) == 'L'){
                late ++;
                if (late > 2)
                    return false;
            }
            else {
                late = 0;
            }
        }
        
        return true;
    }
}
