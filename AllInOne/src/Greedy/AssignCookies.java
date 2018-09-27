package Greedy;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang created on Sep 27, 2018
 *
 */
public class AssignCookies {
	
	public int findContentChildren(int[] g, int[] s) {
        
        // null exception for g and s
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gIdx = g.length - 1;
        int count = 0;
        
        for (int sIdx = s.length - 1; sIdx >= 0; sIdx --) {
            
            // if (s[sIdx] find a match), count ++
            // turn to next sIdx and start with previous gIdx and continue
            while (gIdx >= 0) {
                if (s[sIdx] >= g[gIdx --]) {
                    count ++;
                    break;
                }
            }
        }
        
        return count;
    }

}
