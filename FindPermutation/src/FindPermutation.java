/**
 * 
 * round 1: solved, 25m, IDE debug
 * 
 * idea: greedy base, iterate through the string 
 * 1) if it is "I", then get assign current small
 * update small and big
 * small = big; big ++;
 * 2)  if it is "D",
 * fst check continues D : "DD..D"
 * 1 D then big + 1;
 * start from first D to last D
 * assign big, big - 1, big - 2...
 * update big with big ++ at the end
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 24, 2017
 */
public class FindPermutation {
	
    // round 1: solved, 25m, IDE debug
    // greedy base, need to hanlde continues D : "DD..D"
    public int[] findPermutation(String s) {
        
        if (null == s || 0 == s.length()) 
            return new int[]{1};
        
        int[] res = new int[s.length() + 1];
        
        int small = 1;
        int big = 2;
        
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == 'D') {
                int temp = i;
                // *** if there is multiple D
                while (temp < s.length() - 1 && s.charAt(temp + 1) == 'D') {
                    big ++;
                    temp ++;
                }
                res[i] = big;
                while ( ++ i <= temp) {
                    res[i] = res[i - 1] - 1;
                }
                // left the i go back to its place at temp
                i --;
                // update big
                big ++;
            }
            else {
                res[i] = small;
                small = big;
                big ++;
            }
        }
        
        // if the last is D, then the last one is small; if the last is I, then the last avail big has assign to small
        // so the last is small anyway
        res[res.length - 1] = small;
        
        return res;
    }
}
