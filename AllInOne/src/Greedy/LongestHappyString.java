/**
 * 
 * 1405. Longest Happy String
 * 
 * @author jingjiejiang
 * @history Nov 15, 2020
 * 
 * ref: https://leetcode.com/problems/longest-happy-string/discuss/564273/Java-Happy-Greedy-String-without-PQ
 * 
 */
class Solution {
    public String longestDiverseString(int a, int b, int c) {

        StringBuilder builder = new StringBuilder();
        int size = a + b + c;
        // record the continuous occurance of 'a', 'b' and 'c'
        int A = 0, B = 0, C = 0;

        for (int idx = 0; idx < size; idx ++) {

            if ((a >= b && a >= c && A != 2) || (B == 2 && a > 0) || (C == 2 && a > 0)) {
                builder.append('a');
                a --;
                A ++;
                B = 0;
                C = 0; 
            } else if ((b >= c && b >= a && B != 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                builder.append('b');
                b --;
                B ++;
                A = 0;
                C = 0;
            } else if ((c >= a && c >= b && C != 2) || (B == 2 && c > 0) || (A == 2 && c > 0)) {
                builder.append('c');
                c --;
                C ++;
                A = 0;
                B = 0;
            }
        }

        return builder.toString();
    }
}