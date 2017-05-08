
public class DetectCapital {

	public boolean detectCapitalUse(String word) {
        // round 1: 30 minutes, 29ms, 85.54%
        
        // round 2: try optimised method
        
        // optimize code: method 2
        // ref: https://discuss.leetcode.com/topic/79912/3-lines/2
        /*
        // count the number of capital letter, if there is only one, then the one must be at the beginning
        int cnt = 0;
        for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
        */
        
        if (null == word || 0 == word.length() || 1 == word.length())
            return true;
            
        int i = 0;
        if (isLowerCase(word.charAt(i)) == true) {
            return isAllLower(word, i);
        }
        
        if (i + 1 < word.length()) {
            if (isLowerCase(word.charAt(i + 1)) == true) {
                return isAllLower(word, i + 1);
            }
            
            return isAllUpper(word, i + 1);
        }
        
        return true;
        
    }
    private boolean isLowerCase(char alpha) {
        return alpha >= 'a' && alpha <= 'z' ? true : false;
    }
    
    private boolean isUpperCase(char alpha) {
        return alpha >= 'A' && alpha <= 'Z' ? true : false;
    }
    
    private boolean isAllLower(String word, int index) {
        
        do {
            if (isLowerCase(word.charAt(index)) == false)
                return false;
            index ++;
        } 
        while (index < word.length());
        
        return true;
    }
    
    private boolean isAllUpper(String word, int index) {
        
        do {
            if (isUpperCase(word.charAt(index)) == false)
                return false;
            index ++;
        } 
        while (index < word.length());
        
        return true;
    }
}
