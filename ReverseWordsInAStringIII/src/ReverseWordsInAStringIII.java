
public class ReverseWordsInAStringIII {
	
	public String reverseWords(String s) {
        // idea: find the index of space, sort each section between them
        // *** java String: indexOf(string, index) if not find match, return -1 
        if (null == s || 0 == s.length() || 1 == s.length()) return s;
        
        char[] words = s.toCharArray();
        // skip the leading space;
        int index = (s.charAt(0) == ' ') ? 1 : 0;
        while (index < words.length) {
            int end = s.indexOf(" ", index);
            // *** did not think about the end of string case
            if (end == -1) end = words.length;
            reverse(words, index, end - 1);
            index = end + 1;
        }
        
        return String.valueOf(words);
    }
    
    private void reverse(char[] words, int from, int to) {
        while (from < to) {
            char temp = words[to];
            words[to --] = words[from];
            words[from ++] = temp;
        }
    }
}
