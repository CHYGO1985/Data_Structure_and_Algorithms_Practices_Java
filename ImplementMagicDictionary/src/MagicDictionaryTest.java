import java.util.HashSet;
import java.util.Set;

/**
 * 676. Implement Magic Dictionary
 * 
 * round 1: 1. 5 hours, unsolved, was trying trie methods.
 * 
 * round 1: used trie. but it is hard to search the match with one mismatch word.
 * I did not fully understand the question, the question asks for a word that if
 * we change a char, then we can find a match in the dictionary, that is why
 * "hello" return false.
 * 
 * method 1: trie: ref solution, used java 8 Stream for searching match
 * ref: https://discuss.leetcode.com/topic/102975/efficient-trie-and-java-8
 * 
 * method 2: hashet. My second thought wast o use HashSet, but did not go further
 * ref: https://discuss.leetcode.com/topic/102972/easy-java-solution
 * 
 * @author jingjiejiang
 * @history 
 * 1. Sep 10, 2017 
 */
public class MagicDictionaryTest {
	
	/*
	class MagicDictionary {
	    // trie:
	    class TrieNode {
	        public TrieNode[] nodes;
	        public String word;
	        public int nextCount;
	        
	        public TrieNode() {
	            nodes = new TrieNode[26];
	            Arrays.fill(nodes, null);
	            word = null;
	            nextCount = 0;
	        }
	    }
	    
	    private TrieNode root;

	    // Initialize your data structure here.
	    public MagicDictionary() {
	        
	        root = new TrieNode();
	    }
	    
	    // Build a dictionary through a list of words
	    public void buildDict(String[] dict) {
	        
	        if (null == dict || 0 == dict.length) return ;
	        
	        for (int i = 0; i < dict.length; i ++) {
	            String word = dict[i];
	            TrieNode preNode = root;
	            if (null == word || 0 == word.length()) continue;
	            for (int j = 0; j < word.length(); j ++) {
	                
	                char temp = word.charAt(j);
	                TrieNode newNode = new TrieNode();
	                preNode.nodes[temp - 'a'] = newNode;
	                preNode.nextCount ++;
	                preNode = newNode;
	            }
	            
	            preNode.word = word;
	        }
	    }
	    
	    // Returns if there is any word in the trie that equals to the given word after modifying exactly one character
	    public boolean search(String word) {
	        
	        if (null == word || 0 == word.length()) return true;
	        
	        // count;
	        int revise = 1;
	        TrieNode curNode = root;
	        
	        for (int i = 0; i < word.length(); i ++) {
	            char temp = word.charAt(i);
	            if (curNode == null || curNode.nextCount == 0) return false;
	            if (curNode.nodes[temp - 'a'] != null) { 
	                curNode = curNode.nodes[temp - 'a'];
	                continue;
	            }
	            else {
	                if (revise > 0) revise --;
	                else return false;
	            }
	        }
	        
	        return true;
	    }
	}
   */
	
	// brutal force: change char in the word one by one to find match in a hashset
	class MagicDictionary {
	    
	    private Set<String> set;

	    /** Initialize your data structure here. */
	    public MagicDictionary() {
	        set = new HashSet<>();
	    }
	    
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        
	        if (null == dict || 0 == dict.length) return ;
	        
	        for (String temp : dict)
	            set.add(temp);
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	        
	        if (null == word || 0 == word.length()) return true;
	        
	        char[] wordArr = word.toCharArray();
	        
	        for (int i = 0; i < wordArr.length; i ++) {
	            char cur = wordArr[i];
	            for (char temp = 'a'; temp < 'z'; temp ++) {
	                if (wordArr[i] == temp) continue;
	                else {
	                    wordArr[i] = temp;
	                    if (set.contains(new String(wordArr)) == true) return true;
	                    wordArr[i] = cur;
	                }
	            }
	                
	        }
	        
	        return false;
	    }
	}

	public static void main(String[] args) {
		
	   /*
		MagicDictionaryTest test = new MagicDictionaryTest();
		
		MagicDictionary magicDictionary = test.new MagicDictionary();
		magicDictionary.buildDict(new String[]{"hello","leetcode"});
		String[] res = {"hhllo", "hell", "leetcoded"};
		for (int i = 0; i < res.length; i ++)
			System.out.println(magicDictionary.search(res[i]));
		*/
	}

}
