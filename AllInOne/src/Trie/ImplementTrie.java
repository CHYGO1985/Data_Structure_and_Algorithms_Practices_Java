package src.Trie;

import java.util.Arrays;

// idea: use array to build TrieNode
// result: 188ms. beat 28%
/**
 * 208. Implement Trie (Prefix Tree)
 * 
 */
class TrieNode {
    private TrieNode[] nodesArray;
    private boolean isWord;

    public TrieNode() {
        this.nodesArray = new TrieNode[26];
        Arrays.fill(this.nodesArray, null);
        this.isWord = false;
    }

    public TrieNode getTrieNode(char letter) {
        return this.nodesArray[letter - 'a'];
    }

    public void setTrieNode(char letter) {
        this.nodesArray[letter - 'a'] = new TrieNode();
    }

    public boolean containsKey(char letter) {
        return this.nodesArray[letter - 'a'] != null;
    }

    public boolean getIsWord() {
        return this.isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    
    public void insert(String word) {
        
        assert word != null && word.length() > 0;

        TrieNode curNode = root;

        for (int idx = 0; idx < word.length(); idx ++) {
            char curChar = word.charAt(idx);

            if (curNode.containsKey(curChar) == false) {
                curNode.setTrieNode(curChar);
            }
            
            curNode = curNode.getTrieNode(curChar);
        }

        curNode.setIsWord(true);
    }
    
    public boolean search(String word) {
        
        assert word != null && word.length() > 0;

        TrieNode curNode = root;

        for (int idx = 0; idx < word.length(); idx ++) {

            char curChar = word.charAt(idx);

            if (curNode.containsKey(curChar) == false) {
                return false;
            }

            curNode = curNode.getTrieNode(curChar);
        }

        return curNode.getIsWord();         
    }
    
    public boolean startsWith(String prefix) {
        
        assert prefix != null && prefix.length() > 0;

        TrieNode curNode = root;

        for (int idx = 0; idx < prefix.length(); idx ++) {

            char curChar = prefix.charAt(idx);

            if (curNode.containsKey(curChar) == false) {
                return false;
            }

            curNode = curNode.getTrieNode(curChar);
        }

        return true;     
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

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
