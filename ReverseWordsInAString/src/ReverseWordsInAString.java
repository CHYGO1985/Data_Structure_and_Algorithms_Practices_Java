
public class ReverseWordsInAString {
	
	public static String reverseWords(String s) {
		// idea: method 1
        // 1) get rid of extra spaces 
        // 2) reverset the whole array
        // 3) reverse each word in the array
        // this one must be quicker
		
        // method 2: use string builder
        // result: 13ms, beat 36.86%
        
        // handle false parameter: s=null or s.length = 0, s length = 1
        if (null == s || 0 == s.length()) {
            return s;
        }
        
        StringBuilder builder = new StringBuilder();    
        int strLen = s.length();
        
        // get startPos
        int startPos = -1;
        for (int i = 0; i < strLen; i ++) {
             
             if (-1 == startPos && s.charAt(i) != ' ') {
                  startPos = i;
                  break;
             }
        }
        
        // if it is a string that contains only spaces
        if (startPos == -1) {
            return "";
        }
        
        int insertPos = 0;
        for (int i = strLen - 1; i > startPos; i --) {
            
            char temp = s.charAt(i);
            if (temp != ' ') {
            
                builder.insert(insertPos, temp);
            }
            
            if (temp != ' ' && ' ' == s.charAt(i - 1)) {
                builder.append(" ");
                insertPos = builder.length(); 
            }   
        }
        
        char zeroc = s.charAt(startPos);
        if (zeroc != ' ') {
            builder.insert(insertPos, zeroc);
        }
        
        return builder.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  the sky  is   blue   "; 
		s = reverseWords(s);
		System.out.println(s);
	}

}
