import java.util.HashSet;
import java.util.Set;


public class MaxXORInArray {
	
	class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        // round 1: no idea
        // method 1: TLE error -->> improve, search from the highest bit in the array
        // ref: https://discuss.leetcode.com/topic/63213/java-o-n-solution-using-bit-manipulation-and-hashmap/22
        // basic idea: start from the most significant bit, find the temp max, use a^b=c ->> a^c=b to check
        // whether the current most max fix the rule
        
        // method 2: use trie
        // idea: construct each number with trie, then use a^c=b --> a^c=b to check each of the most significant bit
        // ref: https://discuss.leetcode.com/topic/63207/java-o-n-solution-using-trie
        
        // *** 1. how to represent negative value: https://www.calvin.edu/academic/rit/webBook/chapter5/negative.htm
        // *** 2. Integer.bitCount(): count number of one-bit, Integer.highestOneBit(): return the value of the highest
        // one-bit, NB: not the position
    	// *** 3. using bit to solve bit manipulation problem
        
        // round 2:
        /*
        // *** improved method 1:
        if (nums == null)
            return -1;
        
        int max = 0, mask = 0, maxNum = nums[0];
        
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        
        int availPos = 31 - Integer.numberOfLeadingZeros(maxNum);
        
        for (int i = availPos; i >= 0; i --) {
            
            mask |= (1 << i);
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask);
            }
            
            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(prefix ^ temp))
                    max = temp;
            }
        }
        
        return max;
        */
        
        //***  method 2
        // Init Trie.
        if (nums == null)
            return -1;
        
        int maxNum = nums[0];
        
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        
        int availPos = 31 - Integer.numberOfLeadingZeros(maxNum);
        
        Trie root = new Trie();
        for(int num: nums) {
            Trie curNode = root;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            Trie curNode = root;
            int curSum = 0;
            // *** use the feature: a^b=c --> a^c=b
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                }else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// int[] nums = {11, 2,13,14,15};
		int[] nums = {32,18,33,42,29,20,26,36,15,46};

	}

}
