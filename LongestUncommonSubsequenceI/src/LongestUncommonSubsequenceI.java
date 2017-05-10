
public class LongestUncommonSubsequenceI {
	public int findLUSlength(String a, String b) {
        // round 1: AC after one attempt.
        
        if (null == a && null == b)
            return -1;
        else if (null == a)
            return b.length();
        else if (null == b)
            return a.length();
            
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}
