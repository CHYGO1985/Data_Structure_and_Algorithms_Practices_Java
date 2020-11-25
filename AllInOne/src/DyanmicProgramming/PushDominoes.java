/**
 * 
 * 838. Push Dominoes
 * 
 * @CHYGO1985
 * @history Nov 25, 2020
 * 
 */
class Solution {
    public String pushDominoes(String dominoes) {
        
        if (dominoes == null || dominoes.length() <= 1) return dominoes;
        
        int len = dominoes.length();
        char[] rightToLeft = new char[len];
        char[] leftToRight = new char[len];
        
        char[] domiChars = dominoes.toCharArray();

        // RL -> RR (left to right)
        for (int idx = 0; idx < domiChars.length - 1; idx ++) {
            
            if (domiChars[idx] == 'R') leftToRight[idx + 1] = 'R';
            leftToRight[idx] = (leftToRight[idx] == 'R' ? leftToRight[idx] : domiChars[idx]);
        }

        for (int idx = domiChars.length - 1; idx > 0; idx --) {
            
            if (domiChars[idx] == 'L') rightToLeft[idx - 1] = 'L';
            rightToLeft[idx] = (rightToLeft[idx] == 'L' ? rightToLeft[idx] : domiChars[idx]);
        }

        StringBuilder builder = new StringBuilder();
        for (int idx = 0; idx < domiChars.length; idx ++) {

            if (rightToLeft[idx] == 'L' && leftToRight[idx] == 'R') {
                builder.append(domiChars[idx]);
            } else if (rightToLeft[idx] == 'L') {
                builder.append('L');
            } else if (leftToRight[idx] == 'R') {
                builder.append('R');
            } else {
                builder.append('.');
            }
        }

        return builder.toString();
    }
}