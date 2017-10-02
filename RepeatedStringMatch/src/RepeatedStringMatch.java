/**
 * 
 * 686. Repeated String Match
 * 
 * round 1: solved, 42m, 3 attemps, sliding window 
 * idea: match -> hash (it cannot record pos infor)
 * 
 * so i think about brutal force, from 1 to n, check all every possible
 * sliding window.
 * 
 * optimisation:
 * 1)sliding window + last visit place 300ms
 * 2)sliding window + only compare when fst letter match + last visit point 260ms
 * 
 * *** test case:
 * I stucked at the condition to end the loop to duplicate A
 * *** should not use condition builder.length() <= window * 2 "aaa", "a"
 * *** condition: builder.length() <= 20000 TLE
 * 
 * better solution
 * StringBuilder indexOf(String str) method
 * Returns the index within this string of the first occurrence of the specified substring.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 2, 2017 
 */
public class RepeatedStringMatch {

	// *** stuck on how to end the loop of duplicating A
    // sliding window + last visit place 300ms
    // sliding window + only compare when fst letter match + last visit point 260ms
    public int repeatedStringMatch(String A, String B) {
        // sliding window
        
        //*** should not use this condition "aa", "a" return 1
        // if (A.length() > B.length()) return -1;
        StringBuilder builder = new StringBuilder();
        int window = B.length();
        int count = 0;
        // build an string which length >= B
        while (builder.length() < window) {
            builder.append(A);
            count ++;
        }
        
        int limit = A.length() >= window ? A.length() * 2 : window * 2;
    
        // *** should not use condition builder.length() <= window * 2 "aaa", "a"
        // *** condition: builder.length() <= 20000 TLE
        int lastVisit = 0;
        while (builder.length() <= limit) {
            String res = builder.toString(); 
            // check all avail sliding window to see whether there is a match
            for (; lastVisit <= res.length() - window; lastVisit ++) {
                if (res.charAt(lastVisit) == B.charAt(0)) {
                    String tmp = res.substring(lastVisit, lastVisit + window);
                    if (tmp.equals(B)) return count;
                }
            }
            builder.append(A);
            count ++;
        }
        
        return -1;         
    }
}
