import java.util.LinkedList;
import java.util.List;


public class FlipGame {

	public List<String> generatePossibleNextMoves(String s) {
       // idea: the num of possibilities = length of continuous "+"  - 1
       // loop, when meet two ++, flip, add the string to list
       // runime: 1ms, 32%
       
       // *** 1. Strng: substring() (lowerase, not uppercase)
       // *** 2. substring(), if lower bound exceed the length, it will not throw an exception
       // *** 3. learn to use replace() and subSequnce
       
       List<String> list = new LinkedList<String>();
       
       // *** if length == 1, then it is not a valid move, should return []
       if (null == s || 0 == s.length() || 1 == s.length())
          return list;
       
       // method 1 : substring()
       for (int i = 0; i < s.length() - 1; i ++) {
           if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
               /*
               // the i + 2 < s.length() condition can be skipped
               String temp = s.substring(0, i) + "--";
               if ( i + 2 < s.length() )
                   temp += s.substring(i + 2, s.length());
               */
               list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()) );
           }
       }
       
       return list;
    }
}
