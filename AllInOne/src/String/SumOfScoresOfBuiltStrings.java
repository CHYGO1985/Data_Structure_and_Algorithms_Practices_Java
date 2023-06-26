package src.String;

/**
 * 2223. Sum of Scores of Built Strings
 */
public class SumOfScoresOfBuiltStrings {
   // calculate Z array
    public int[] calculateZ(char[] input) {
       
       assert input != null && input.length > 0;

       int[] zArr = new int[input.length];

        // init z[0] = 0
        // if k > right
        // move right boundry
        // left = right = k
        // while [right] == [right - left], right ++
        // z[k] = right - left
        // right -- (move back to the boundry)
        // else k<= right. copy the previous array 
        // int kInCopyArr = k - left
        // if (z[k] < right - k + 1) within the boundry
        // z[kInCopyArr] = z[k]
        // if not, need to recalc the zarray
        // left = k
        // while [right] == [right - left], right ++
        // z[k] = right - left
        // right --
       int left = 0, right = 0;
       zArr[0] = 0;

       for (int curIdx = 1; curIdx < input.length; curIdx ++) {
           
           if (curIdx > right) {
               // build the boundry by moving right boundry
               left = right = curIdx;
               while (right < input.length && input[right] == input[right - left]) {
                   right ++;
               }
               zArr[curIdx] = right - left;
               right --;
           } else { 
               int preIdx = curIdx - left;
               // if within the boundry
               if (zArr[preIdx] < right - curIdx + 1) {
                   zArr[curIdx] = zArr[preIdx];
               } else {
                    // if out of the boundry, rebuild the z array
                    left = curIdx;
                    while (right < input.length && input[right] == input[right - left]) {
                        right ++;
                    }
                    zArr[curIdx] = right - left;
                    right --;
                }    
           }
       }

       return zArr;
    }

    public long sumScores(String s) {
        
        assert s != null && s.length() > 0;

        int[] zArr = calculateZ(s.toCharArray());

        long sum = 0;
        for (int ele : zArr) {
            sum += ele;
        }

        sum += s.length();

        return sum;
    }
}
