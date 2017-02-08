// idea: use array to build TrieNode
// result: 188ms. beat 28%
class TrieNode {
    
    // to focus on the algorithm (all the fields I set them as public)
    // use array to represent pair infor, the index is used as the value of char
    public TrieNode[] array;
    // to check whether it is a leaf Node of word
    public boolean isEnd;
    
    public TrieNode() {
        array = new TrieNode[26];
        for (int i = 0; i < array.length; i ++) {
            array[i] = null;
        }
        isEnd = false;
    }
}
 
class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        if (null == word || 0 == word.length()) {
            return ;
        }
        
        TrieNode curNode = root;
        
        for (int i = 0; i < word.length(); i ++) {
            
            char temp = word.charAt(i);
            
            // if there is not a match in curNode.array, then assign a value
            if (null == curNode.array[temp - 'a']) {
                TrieNode newNode = new TrieNode();
                curNode.array[temp - 'a'] = newNode;
            }
            
            // go to next TriNode of current one
            curNode = curNode.array[temp - 'a'];
        }
        
        curNode.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        if (null == word || 0 == word.length()) {
            return false;
        }
        
        /*
        // refactoring to a method, as it duplicates in startsWith
        TrieNode curNode = root;
        
        for (int i = 0; i < word.length(); i ++) {
        
            char temp = word.charAt(i);
            if (curNode.array[temp - 'a'] != null) {
                curNode = curNode.array[temp - 'a'];
            }
            else {
                return false;
            }
        }
        */
        TrieNode node = searchNode(word);
        
        return node == null ? false : node.isEnd == true ? true : false; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        if (null == prefix || 0 == prefix.length()) {
            return false;
        }
        
        /*
        TrieNode curNode = root;
        
        for (int i = 0; i < prefix.length(); i ++) {
        
            char temp = prefix.charAt(i);
            if (curNode.array[temp - 'a'] != null) {
                curNode = curNode.array[temp - 'a'];
            }
            else {
                return false;
            }
        }
        */
        
        return searchNode(prefix) == null ? false : true;
    }
    
    public TrieNode searchNode (String para) {

        if (null == para || 0 == para.length()) {
            return null;
        }
        
        TrieNode curNode = root;
        for (int i = 0; i < para.length(); i ++) {
        
            char temp = para.charAt(i);
            if (curNode.array[temp - 'a'] != null) {
                curNode = curNode.array[temp - 'a'];
            }
            else {
                return null;
            }
        }
        
        return curNode;
    }
}


public class ImplementTrie {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "word";
		Trie obj = new Trie();
		obj.insert(s);
		obj.startsWith("wo");
		obj.search("word");
	}

}
