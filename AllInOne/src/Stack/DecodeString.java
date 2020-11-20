/**
 * 
 * 394. Decode String
 * 
 * @CHYGO1985
 * @history Nov 19, 2020
 * 
 * idea: one stack for num, one stack for letters
 */
class Solution {
    public String decodeString(String s) {
        
      Stack<Integer> numStack = new Stack<>();
      Stack<String> charStack = new Stack<>();

      StringBuilder builder = new StringBuilder();
      int idx = 0;
      while (idx < s.length()) {

        char character = s.charAt(idx);
          
        if (Character.isDigit(character)) {

          int num = 0;
          while (Character.isDigit(s.charAt(idx))) {
            num = num * 10 + (s.charAt(idx) - '0');
            idx ++;
          }
          numStack.push(num);
        } else if (character == '[') {
          charStack.push(builder.toString());
          builder.setLength(0);
          idx ++;
        } else if (character == ']') {
          StringBuilder temp = new StringBuilder(charStack.pop());
          int repeatTimes = numStack.pop();
          while (repeatTimes -- > 0) {
            temp.append(builder.toString());
          }
          builder = new StringBuilder(temp);
          idx ++;
        } else {
          builder.append(character);
          idx ++;
        }
      }

      return builder.toString();
    }
}
