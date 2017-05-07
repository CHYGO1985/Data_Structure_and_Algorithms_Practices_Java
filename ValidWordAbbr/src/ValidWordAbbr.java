
public class ValidWordAbbr {
	
	public static boolean validWordAbbreviation(String word, String abbr) {
        // round 1: took 4 hours
        // *** test case: 1. did not think about with digital 0
        // 2. abbr length < word.length(), abbr: 1 word: ac
        // idea: iterate througn abbr, check available char and number
        
        // *** string to integer (should think about overflow problem)
		
		// 24ms
        int wordIndex = 0;
        
        if (null == word || null == abbr)
            return false;
        /*
        for (int i = 0; i < abbr.length(); i ++) {
            char temp = abbr.charAt(i);
            StringBuilder builder = new StringBuilder();
            if ( (temp >= '1' && temp <= '9') == true ) {
            	while ( (i < abbr.length()) && (abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') == true ) {
                    builder.append(abbr.charAt(i));
                    i++;
                }
                
                if (i < abbr.length())
                    i --;
                
                int shift = Integer.valueOf(builder.toString());
                if (wordIndex + shift > word.length() && word.length() - wordIndex != shift)
                    return false;
                // wordIndex pointed to next word
                wordIndex += shift;         
            }
            // contains characters
            else if (temp - 'a' >= 0 && temp - 'a' <= 25) {
                if (wordIndex >= word.length() || temp != word.charAt(wordIndex ++))
                    return false;
            }
            else {
                // *** if the abbr contains char other than 1-9,a-z, return false
                return false;
            }
        }
        
        // *** add check whether wordIndex reach the end
        return wordIndex < word.length() ? false : true;
        */
        
        /*
        // 22ms
        for (int i = 0; i < abbr.length();) {
            char temp = abbr.charAt(i);
            StringBuilder builder = new StringBuilder();
            if ( (temp >= '1' && temp <= '9') == true ) {
                while ( (i < abbr.length()) && (abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') == true ) {
                    builder.append(abbr.charAt(i));
                    i++;
                }
                
                int shift = Integer.valueOf(builder.toString());
                if (wordIndex + shift > word.length() && word.length() - wordIndex != shift)
                    return false;
                // wordIndex pointed to next word
                wordIndex += shift;  
                
            }
            // contains characters
            else if (temp - 'a' >= 0 && temp - 'a' <= 25) {
                if (wordIndex >= word.length() || temp != word.charAt(wordIndex ++))
                    return false;
                i ++;
            }
            else {
                // *** if the abbr contains char other than 1-9,a-z, return false
                return false;
            }
        }
        
        // *** add check whether wordIndex reach the end, for case word, w2
        return wordIndex < word.length() ? false : true;
        */
        
        // 21 ms
        for (int i = 0; i < abbr.length();) {
            char temp = abbr.charAt(i);
            StringBuilder builder = new StringBuilder();
            if ( (temp >= '1' && temp <= '9') == true ) {
                do {
                    builder.append(temp);
                    temp = ( (++ i) < abbr.length() ) ? abbr.charAt(i) : '#';
                }
                while ( (temp >= '0' && temp <= '9') == true );    
                
                wordIndex += Integer.valueOf(builder.toString());
                // in case: word: w5
                if (wordIndex > word.length())
                    return false; 
            }
            // contains characters
            else if (temp - 'a' >= 0 && temp - 'a' <= 25) {
                // wordIndex >= word.length() for case: word: w3d
                if (wordIndex >= word.length() || temp != word.charAt(wordIndex ++))
                    return false;
                i ++;
            }
            else {
                // *** if the abbr contains char other than 1-9,a-z, return false
                return false;
            }
        }
        
        // *** add check whether wordIndex reach the end, for case word: w2
        return wordIndex < word.length() ? false : true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
