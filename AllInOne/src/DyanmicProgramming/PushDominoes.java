/**
 * 
 * 838. Push Dominoes
 * 
 * @CHYGO1985
 * @history Nov 25, 2020
 * 
 * ref: https://leetcode.com/problems/push-dominoes/discuss/132520/Java-one-pass-no-extra-storage-detailed-explanation
 * 
 */
class Solution {

    // algorithm 2018/05/20: playing with a few samples, it is easy to find the rule
    // if there is NO dot (meaning every domino is pushed), then the final state is the initial state
    // for example, all "LLL" => "LLL", all "RRR" => "RRR",
    //                mixed "LLLRR" => "LLLRR" (falling domino having no effect on already-fallen domino)
    // if there is only ONE dot, we have a few possibilities:
    //   "L.R" => "L.R", "R.L" => "R.L" (center-one standing), "L.L" => "LLL", "R.R" => "RRR"
    // if there are TWO dots, we have the following possibilities:
    //   "L..R" => "L..R", "R..L" => "RRLL", "L..L" => "LLLL", "R..R" => "RRRR"
    // if there are THREE dots, we have the following possibilities:
    //   "L...R" => "L...R", "R...L" => "RR.LL" (center-one standing), "L...L" => "LLLLL", "R...R" => "RRRRR"
    // Therefore the rule is:
    // for each region of dots (a substring "P....Q"), check its left and right
    //   if left is "L" and right is "R", the substring remains as is;
    //   if left is "R" and right is "L", the substring is converted into either "RRRLLL" or "RR.LL"
    //   if left and right are the same, the substring is converted into either "RRRRR" or "LLLLL"
    public String pushDominoes(String dominoes) {
        
        assert(null != dominoes);
        // place a sentinel "L" + dominoes + "R", as this does not impact the final outcome
        dominoes = "L" + dominoes + "R";

        StringBuilder builder = new StringBuilder();

        // scan the string and split it into multiple groups, |groupStart, groupEnd| ... |groupStart, groupEnd| ...
        // 'groupStart' and 'groupEnd' designates a number of chars solely with 'L' or 'R'
        int strLen = dominoes.length();
        int groupStart = 0;
        int dominoIdx = 0;    

        while (dominoIdx < strLen) {

            // find start idx of a group
            while (dominoIdx < strLen && '.' != dominoes.charAt(dominoIdx)) dominoIdx ++;
            
            int startIdx = dominoIdx - 1;
            char startChar = dominoes.charAt(startIdx);

            // copy this part of susbtring as is (no DOT in the middle), e.g. LLRR, RRLL, their final status will as it is
            builder.append(dominoes.substring(groupStart, startIdx + 1));

            // either we reach the end of the string or we find a dot
            if (dominoIdx == strLen) {
                break;
            }

            // find the end idx of a group
            // now we meet a DOT; scan until we meet the next "L" or "R"
            while ('.' == dominoes.charAt(dominoIdx)) {
                dominoIdx++;        // we have the sentinel "R", so this will not reach the end of string
            }
            char endChar = dominoes.charAt(dominoIdx);

            // L ... L or R ... R
            if (startChar == endChar) {
                // replace dot with the same char
                // dominoIdx - startIdx - 1: as 0 1 2 3 4, get the len of 1 2 3, we have 4 - 0 - 1 (4 is not counted)
                for (int count = 0; count < dominoIdx - startIdx - 1; count ++) {
                    builder.append(startChar);
                }
            } else if ('L' == startChar) { 
                // the first is to check start == end, so if start == L, now right = R 
                // L ... R : keep all the dots as they are
                for (int count = 0; count < dominoIdx - startIdx - 1; count ++) {
                    builder.append('.');
                }
            } else {
                // the case is R .... L, we check the dots in mid are even num or odd num
                int dotsCount = dominoIdx - startIdx - 1;

                // left half are R
                for (int count = 0; count < dotsCount / 2; count ++) {
                    builder.append('R');
                }

                // keep centre dot if are odd num
                if (1 == dotsCount % 2) {
                    builder.append('.');
                }

                // right half are L
                for (int count = 0; count < dotsCount / 2; count ++) {
                    builder.append('L');
                }
            }

            groupStart = dominoIdx;
        }

        return (builder.toString()).substring(1, strLen - 1);
    }
}
