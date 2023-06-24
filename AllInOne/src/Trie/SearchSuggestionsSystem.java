package src.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 1268. Search Suggestions System
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
    static final int CAPACITY = 3;
    List<String> resultBuffer;

    public Trie() {
        this.root = new TrieNode();
    }

    // insert()
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

    private void dfsWithPrefix (TrieNode curNode, String word) {

        if (resultBuffer.size() == 3) return ;

        if (curNode.getIsWord() == true) {
            resultBuffer.add(word);
        }

        for (char c = 'a'; c <= 'z'; c ++) {
            if (curNode.containsKey(c) == true) {
                dfsWithPrefix(curNode.getTrieNode(c), word + c);
            }
        }

        // System.out.println(resultBuffer.size());

    }

    // matchTop3Words(): return top three match words
    public List<String> getWordsStartingWith(String word) {
        assert word != null && word.length() > 0;

        TrieNode curNode = root;
        resultBuffer = new ArrayList<>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : word.toCharArray()) {
            
            if (curNode.containsKey(c) == false)
                return resultBuffer;
            curNode = curNode.getTrieNode(c);
        }

        dfsWithPrefix(curNode, word);

        return resultBuffer;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        assert products != null && products.length >= 1 && searchWord != null;

        Trie trie = new Trie();
        List<List<String>> resList = new ArrayList<>();

        for (int idx = 0; idx < products.length; idx ++) {
            trie.insert(products[idx]);
        }

        for (int idx = 0; idx < searchWord.length(); idx ++) {
            String curStr = searchWord.substring(0, idx + 1);
            resList.add(trie.getWordsStartingWith(curStr));
        }

        return resList;
    }

    public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
        
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> productsMap = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int idx = 0; idx < productsList.size(); idx ++) {
            productsMap.put(products[idx], idx);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = productsMap.ceilingKey(key);
            String floor = productsMap.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(productsMap.get(ceiling), Math.min(productsMap.get(ceiling) + 3, productsMap.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());

        return res;
    }
}