import java.util.Arrays;

/**
 * 
 * 315. Count of Smaller Numbers After Self
 * 
 * @author jingjiejiang
 * @history Apr 22, 2021
 * 
 * BST: TLE ref : https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76580/9ms-short-Java-BST-solution-get-answer-when-building-BST
 * 
 */
public class CountOfSmallerNumAfterSelf {
    // BST: TLE
    public List<Integer> countSmaller1(int[] nums) {

        assert nums != null && nums.length >= 1;

        Node root = null;
        Integer[] res = new Integer[nums.length];
        for (int idx = nums.length - 1; idx >= 0; idx --) {
            root = insert(num, root, res, idx, 0);
        }

        return Arrays.asList(res);
    }

    private Node insert(int num, Node node, Integer[] res, int idx, int preSumOfSmall) {

        if (node == null) {
            node = new Node(num, 0);
            res[idx] = preSumOfSmall;
        } else if (node.val == num) {
            node.dup ++;
            res[idx] = preSumOfSmall + node.sum; 
        } else if (node.val > num) {
            node.sum ++;
            node.left = insert(num, node.left, res, idx, preSumOfSmall);
        } else {
            node.right = insert(num, node.right, res, idx, 
                preSumOfSmall + node.sum + node.dup);
        }

        return node;
    }
}

public class Ndoe {

    Node left, right;
    int val, numOfSmall, dup = 1;
    
    public Node(int val, int numOfSmall) {
        this.val = val;
        this.numOfSmall = numOfSmall;
    }
} 
