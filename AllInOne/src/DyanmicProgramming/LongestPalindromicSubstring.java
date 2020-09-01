public class LongestPalindromicSubstring {
    // method 1: Manachers Algorithm
    // public String longestPalindrome(String s) {
    //     if (s == null || s.length() == 0) return "";
  
    //     StringBuilder builder = new StringBuilder();
    //     builder.append('$');
    
    //     for (int idx = 0; idx < s.length(); idx ++) {
    //         builder.append('#').append(s.charAt(idx));
    //     }
    
    //     builder.append('#').append('@');
    //     String[] convertStr = builder.toString().split("");
        
    //     int palinMidPos = 0, maxPalinLen = 0;
    //     int center = 1, rightBound = 1; 
    //     int[] palinArr = new int[convertStr.length];
    //     palinArr[0] = palinArr[1] = 0;
    
    //     for (int curBound = 2; curBound < convertStr.length - 1; curBound ++) {
    //         int mirOfRight = 2 * center - curBound;
    
    //         if (curBound < rightBound) palinArr[curBound] = Math.min(palinArr[mirOfRight], rightBound - curBound);
    
    //         while (convertStr[curBound + (1 + palinArr[curBound])].equals(convertStr[curBound - (1 + palinArr[curBound])])) {
    //         palinArr[curBound] ++;
    //         }
    
    //         if (curBound > rightBound) {
    //         center = curBound;
    //         rightBound = curBound + palinArr[curBound];
    //         }
    
    //         if (palinArr[curBound] > maxPalinLen) {
    //         maxPalinLen = palinArr[curBound];
    //         palinMidPos = curBound;
    //         }
    //     }
    
    //     int maxPalinStartPos = (palinMidPos / 2 - 1) - (maxPalinLen - 1) / 2;
    
    //     return s.substring(maxPalinStartPos, maxPalinStartPos + maxPalinLen);
    //   }

    public String longestPalindrome(String s) {
        
    }
}