/**
 * 
 * 948. Bag of Tokens
 * 
 * @CHYGO1985
 * @history Oct 24, 2020
 * 
 */
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        if (tokens == null || tokens.length == 0 || P == 0) return 0;

        int score = 0;
        Arrays.sort(tokens);

        // two pointers tech, face up as many as possible from small idx, if not face down from big idx to gain P
        int smallIdx = 0, bigIdx = tokens.length - 1;

        while (smallIdx < bigIdx) {

            if (P >= tokens[smallIdx]) {
                P -= tokens[smallIdx ++];
                score ++;
            } else { // P < tokens[smallIdx]
                if (score > 0) {
                    P += tokens[bigIdx --];
                    score --;
                } else { // score == 0
                    return 0;
                }
            }
        }

        // when small idx == big idx, and P > [small], we can get another score
        return P >= tokens[smallIdx] ? score + 1 : score;
    }
}