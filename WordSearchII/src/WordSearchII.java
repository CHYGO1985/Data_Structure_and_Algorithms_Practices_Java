import java.util.LinkedList;
import java.util.List;


public class WordSearchII {
	
    public List<String> findWords(char[][] board, String[] words) {
        // idea: trie + dfs
        // 1) how to recording matching? 
        // a. StringBuilder/string recording: use a stringbuilder when doing dfs, if succeed, return stringbuilder as a string
        // b. https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00/2
        // add another field in the trienode, for its leaf node, add a field to record the whole
        // 2) status map: do not need to build a seperate map use words directly
        // *** optimise of dfs
        // https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00/2
        // 3) I first use builder, then use the words itself to put in List<String>
        // result: 37 ms
        
        // things learned: 1) the core idea of dfs
        // 2) dfs method: write the search part (four directions in this question), then the status memo, 
        // then the quit condition 
        // 3) optimise of dfs, without using status map, change board value in place
        
        // edge case
        List<String> res = new LinkedList<String>();
        if (null == words || 0 == words.length || null == board
                || 0 == board.length || 0 == board[0].length)
            return res;
        
        Trie trie = new Trie();
        
        // add words into trie
        for (String str : words) {
            trie.insert(str);
        }
        
        // dfs search in board
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                dfsHelper(board, i, j, trie.root, res);
            }
        }
        
        return res;
    }
    
    // *** dfs funcs normally does not return any value, the accumulation is normally used as a parameter
    private void dfsHelper(char[][] board, int row, int col, TrieNode node, List<String> res) {
        
        // *** How to escape a dfs search
        char temp = board[row][col];
        if (temp == '#' || node.array[temp - 'a'] == null) {
            return ;
        }
        node = node.array[temp - 'a'];
        if (node.word != null) {
            res.add(node.word);
            // to prevent repeat
            node.word = null; 
        }
        
        // *** the current cell has been searched
        board[row][col] = '#';
        // dfs search four direction
        if (row + 1 < board.length) {
            dfsHelper(board, row + 1, col, node, res);
        }
        if (row - 1 >= 0) {
            dfsHelper(board, row - 1, col, node, res);
        }
        if (col - 1 >= 0) {
            dfsHelper(board, row, col - 1, node, res);
        }
        if (col + 1 < board[0].length) {
            dfsHelper(board, row, col + 1, node, res);
        }
        board[row][col] = temp;
    }
    
    class TrieNode {
        // to focus on the algorithm (all the fields I set them as public)
        // use array to represent pair infor, the index is used as the value of char
        public TrieNode[] array;
        // to check whether it is a leaf Node of word
        public String word;
        public TrieNode() {
            array = new TrieNode[26];
            for (int i = 0; i < array.length; i ++) {
                array[i] = null;
            }
            word = null;
        }
    }

    class Trie {

        public TrieNode root;
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
            // *** to prevent repeated words then assign null
            curNode.word = word;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String a = "oaan";
		String b = "etae";
		String c = "ihkr";
		String d = "iflv";
		
		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();
		char[] c1 = c.toCharArray();
		char[] d1 = d.toCharArray();
		char[][] board = {a1,b1,c1,d1};
		String[] words = {"oath","pea","eat","rain"}; 
		*/
		char[][] board = {{'a'}};
		String[] words = {"a", "a"};

	}

}
