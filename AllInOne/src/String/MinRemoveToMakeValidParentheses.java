/**
 * 
 * 1249. Minimum Remove to Make Valid Parentheses
 * 
 * @author jingjiejiang
 * @history Feb 19, 2021
 * 
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        
        assert s != null && s.length() >= 1;

        StringBuilder optStr = getValidString(s, '(', ')');
        optStr = getValidString(optStr.reverse().toString(), ')', '(');

        return optStr.reverse().toString();
    }

    private StringBuilder getValidString(String s, char open, char close) {
        
        StringBuilder builder = new StringBuilder();
        int balance = 0;
        
        for (int idx = 0; idx < s.length(); idx ++) {
            
            char curChar = s.charAt(idx);
            if (curChar == open) {
                balance ++;
            } else if (curChar == close) {
                if (balance == 0) continue;
                balance --;
            }
            builder.append(curChar);
        }

        return builder;
    }
}
