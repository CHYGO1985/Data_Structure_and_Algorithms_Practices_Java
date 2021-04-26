import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public class Node {

        Node left, right;
        int val, numOfSmall, dup = 1;
        
        public Node(int val, int numOfSmall) {
            this.val = val;
            this.numOfSmall = numOfSmall;
        }
    } 

    public List<Integer> countSmaller1(int[] nums) {

        assert nums != null && nums.length >= 1;

        Node root = null;
        Integer[] res = new Integer[nums.length];
        for (int idx = nums.length - 1; idx >= 0; idx --) {
            root = insert(nums[idx], root, res, idx, 0);
        }

        return Arrays.asList(res);
    }

    private Node insert(int num, Node node, Integer[] res, int idx, int preSumOfSmall) {

        if (node == null) {
            node = new Node(num, 0);
            res[idx] = preSumOfSmall;
        } else if (node.val == num) {
            node.dup ++;
            res[idx] = preSumOfSmall + node.numOfSmall; 
        } else if (node.val > num) {
            node.numOfSmall ++;
            node.left = insert(num, node.left, res, idx, preSumOfSmall);
        } else {
            node.right = insert(num, node.right, res, idx, 
                preSumOfSmall + node.numOfSmall + node.dup);
        }

        return node;
    }

    // merger sort like method
    private int[] counts;

    public List<Integer> countSmaller2(int[] nums) {

        List<Integer> res = new ArrayList<>();
        counts = new int[nums.length];

        int[] indice = new int[nums.length];

        for (int idx = 0; idx < indice.length; idx ++) {
            indice[idx] = idx;
        }

        mergeSort(nums, indice, 0, nums.length - 1);

        for (int idx = 0; idx < counts.length; idx ++) {
            res.add(counts[idx]);
        }

        return res;
    }

    private void mergeSort(int[] nums, int[] indice, int start, int end) {

        if (end <= start) return ;

        int mid = start + (end - start) / 2;

        mergeSort(nums, indice, start, mid);
        mergeSort(nums, indice, mid + 1, end);

        merge(nums, indice, start, end);
    }

    private void merge(int[] nums, int[] indice, int start, int end) {

        int mid = start + (end - start) / 2;
        int leftIdx = start;
        int rightIdx = mid + 1;
        int rightCount = 0;
        int[] tmpIndice = new int[end - start + 1];

        int shiftIdx = 0;
        // tmpIndice will be sorted by index 
        while (leftIdx <= mid && rightIdx <= end) {
         
            if (nums[indice[leftIdx]] <= nums[indice[rightIdx]]) {
                tmpIndice[shiftIdx] = indice[leftIdx];
                counts[indice[leftIdx]] += rightCount;
                leftIdx ++;
            } else {
                tmpIndice[shiftIdx] = indice[rightIdx];
                rightCount ++;
                rightIdx ++;
            }

            shiftIdx ++;
        }

        while (leftIdx <= mid) {
            tmpIndice[shiftIdx] = indice[leftIdx];
            counts[indice[leftIdx]] += rightCount;
            shiftIdx ++;
            leftIdx ++;
        }

        while (rightIdx <= end) {
            tmpIndice[shiftIdx ++] = indice[rightIdx ++];
        }

        // copy new index order to the original one
        for (int idx = start; idx <= end; idx ++) {
            indice[idx] = tmpIndice[idx - start];
        }
    }
}


