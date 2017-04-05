import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class UniqueWordAbbreviation {
	
	// round 1: used 3 hours to reach to method 2
	// idea: match problem --> hashMap + linkedlist<String> to solve collison (same pair + same length)
    // 1.use hashMap <char[], Integer>: char[]: the char paris; Integer: the num of char in the middle of a word
    // test case: empty dictionary, one char / two char word(keep as it is)
    // *** I wasted my half an hour, as it is not allow to use plain array as key in java.
    // 2nd improve: according to previous mistakeuse <String, Integer>
    // Test case:
    // *** mistake regarding understanding requirements: two identical words is considered as unique abbr, cause they are 
    // 3th improve: according to previous mistake, change to <String (pair), String(original)>
    // *** did not consider the case that in dic, two words have same pair and same length, but they are different word
    // use preivous hash will cause replace "abc", "aec" --> "aec", should return false, but in 3. will return true which
    // will cause wrong judgement
    // 4th improve: one pair may be connected to multiple strings, so use String[] <String(pair), String[]>
    // result: 253ms, beat 47%
    // test case:
    // 1) *** two identical words is considered as unique abbr
    // 2) *** same pair, same length
    
	// method 2: HashMap<String(pair + length), Integer(different word count)> + Set to store dic 
    // 239 ms, beat 63%
    
    // method 3: only used one hashMap
    // ref: https://discuss.leetcode.com/topic/30533/java-solution-with-one-hashmap-string-string-beats-90-of-submissions
    // handle collisoon: set "" value; 
    
    Map<String, Integer> map;
    Set<String> words;
    
    public UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<String, Integer>();
        words = new HashSet<String>();
        
        for (int i = 0; i < dictionary.length; i ++) {
            // assume that there is no null string in dictionary
            String temp = dictionary[i];
            int len = temp.length();
            // edge case
            if (len == 0) 
                continue;
            
            // add to set
            boolean isAdd = words.add(temp);
            
            // even if len = 1 / 2, -1 and 0 can still be stored in the hash
            // *** to handle same pair, same length
            String cur = buildKey(temp);
            // if same words, then still return 1, if same pair+length and not same words, return 2 (means there is dif 
            // words for same pair+length)
            int count = (map.containsKey(cur) == true) && (isAdd == true) ? 2 : 1;
            map.put(cur, count);
        }
    }
    
    public boolean isUnique(String word) {
        
        if (word == null || word.length() == 0)
            return true;
            
        String cur = buildKey(word);
        
        // only when the pairs are the same and the num of chars in the middle are the same
        if (map.containsKey(cur) == true) {
            if ( (map.get(cur) == 2) || ((map.get(cur) == 1) && words.contains(word) == false) )
                return false;
        }
        
        return true;
    }
    
    private String buildKey(String string) {
        StringBuilder builder = new StringBuilder();
        // store the front and rear char
        builder.append(string.charAt(0));
        builder.append(string.length());
        builder.append(string.charAt(string.length() - 1));
        return builder.toString();
    }
    /*
     * method 1
    private Map<String, List<String>> map;
    
    public UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<String, List<String>>();
        
        for (int i = 0; i < dictionary.length; i ++) {
            // assume that there is no null string in dictionary
            String temp = dictionary[i];
            int len = temp.length();
            // edge case
            if (len == 0) 
                continue;
            StringBuilder builder = new StringBuilder();
            // store the front and rear char
            builder.append(temp.charAt(0));
            builder.append(len);
            builder.append(temp.charAt(len - 1));
            // even if len = 1 / 2, -1 and 0 can still be stored in the hash
            // *** to handle same pair, same length
            String cur = builder.toString();
            List<String> list = map.containsKey(cur) == true ? map.get(cur) : new LinkedList<String>();
            list.add(temp);
            map.put(cur, list);
        }
    }
    
    public boolean isUnique(String word) {
        
        if (word == null || word.length() == 0)
            return true;
            
        StringBuilder builder = new StringBuilder();
        // store the front and rear char
        builder.append(word.charAt(0));
        builder.append(word.length());
        builder.append(word.charAt(word.length() - 1));
        
        String cur = builder.toString();
        // only when the pairs are the same and the num of chars in the middle are the same
        if (map.containsKey(cur) == true) {
            List<String> list = map.get(cur);
            for (int i = 0; i < list.size(); i ++) {
                // do nothing is word = list.get(i)
                if (word.equals(list.get(i)) == false)
                    return false;
            }
        }
        
        return true;
    }
    */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
