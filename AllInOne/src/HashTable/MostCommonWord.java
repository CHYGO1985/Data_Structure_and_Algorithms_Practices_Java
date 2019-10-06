package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author jingjiejiang Feb 10, 2019
 *
 */
public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<String> banSet = new HashSet<>();
		int maxCount = 0;
		String res = "";
        
		paragraph = paragraph.replace(",", "").replace(".", "").replace("!", "")
				.replace("?", "").replace("'", "").replace(":", "");
		
		String[] words = paragraph.toLowerCase().split("\\s+");
		
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		for (String banWord : banned) {
			banSet.add(banWord);
		}
		
		for (String key : map.keySet()) {
			if (banSet.contains(key)) continue;
			
			if (map.get(key) > maxCount) {
				res = key;
			}
		}
		
		return res;
    }
}
