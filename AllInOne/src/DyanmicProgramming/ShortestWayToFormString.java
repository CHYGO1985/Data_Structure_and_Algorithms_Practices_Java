/**
 * 
 * 1055. Shortest Way to Form String
 * 
 * @CHYGO1985
 * @history Nov 11, 2020
 *
 * ref: https://leetcode.com/problems/shortest-way-to-form-string/discuss/330938/Accept-is-not-enough-to-get-a-hire.-Interviewee-4-follow-up
 * 
 */
class Solution {
    public int shortestWay(String source, String target) {
        
        char[] sourceChars = source.toCharArray(), targetChars = target.toCharArray();
        int[] maps = new int[26];

        for (int idx = 0; idx < source.length(); idx ++) {
            maps[sourceChars[idx] - 'a'] += 1;
        }

        // ** count init as 1, for example ab : ab, because when last match happens, tarIdx >= target.len, it wont get into if (srcIdx == sourceChars.length)
        int srcIdx = 0, count = 1;

        for (int tarIdx = 0; tarIdx < targetChars.length; tarIdx ++, srcIdx ++) {

            if (maps[targetChars[tarIdx] - 'a'] < 1) return -1;

            while (srcIdx < sourceChars.length && sourceChars[srcIdx] != targetChars[tarIdx]) {
                srcIdx ++;
            }
            
            // if the last char matches, abc : acde, then srcIdx will ++ and tarIdx will ++
            if (srcIdx == sourceChars.length) {
                
                count ++;
                srcIdx = -1;
                tarIdx --;
            }
        }

        return count;
    }
}
