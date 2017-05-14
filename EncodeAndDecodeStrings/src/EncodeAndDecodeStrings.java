import java.util.LinkedList;
import java.util.List;


public class EncodeAndDecodeStrings {
	
	// round 1: semi-sovled, 1.5 hours, stuck on test case that when length of string > 9 (the length have two chars 
    // in a string)
    // Idea: to generalise to all ascii characters, needs a way to record the length of each string
    // method 1: use the first char of each to store the length of each substring in decoded string
    // 1) string: 111ms. 2) StringBuilder: 12ms, beat 88.97%
    // test case : *** hanlde edge cases: when strs == null or strs = ""
    
    // *** java String: indexOf(int ch, int fromIndex)
    // split(String regex, int limit)
    // Encodes a list of strings to a single string.
    /*
    The limit parameter controls the number of times the pattern is applied and therefore affects the length of the 
    resulting array. If the limit n is greater than zero then the pattern will be applied at most n - 1 times, the 
    array's length will be no greater than n, and the array's last entry will contain all input beyond the last matched
    delimiter. If n is non-positive then the pattern will be applied as many times as possible and the array can 
    have any length. 
    */
    
    public String encode(List<String> strs) {
        
        /*
        String res = "";
        if (null == strs) return null;
        
        for (int i = 0; i < strs.size(); i ++) {
            String temp = strs.get(i);
            res += temp.length() + "#" + temp;
        } 
        return res;
        */
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.size(); i ++) {
            String temp = strs.get(i);
            builder.append(temp.length()).append("#").append(temp);
        } 
        
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        List<String> list = new LinkedList<String>();
        int index = 0;
        
        while (index < s.length()) {
            int end = s.indexOf("#", index);
            int len = Integer.valueOf(s.substring(index, end));
            list.add(s.substring(end + 1, end + 1 + len));
            index = end + 1 + len;
        }
        return list;
    }
}
