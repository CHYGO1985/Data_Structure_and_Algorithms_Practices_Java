/**
 * 
 * 215. Kth Largest Element in an Array
 * 
 * @author jingjiejiang
 * @history Feb 7, 2021
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // method 1: heap sort  O(nlogn), and method that reduce the question to sort problem, will meet
        // the O(nlogn) bound
        
        // method 2: selection algorithm -- based on quick sort O(n)
        // ref: https://discuss.leetcode.com/topic/14597/solution-explained
        // things learned: 1) the implementation of quicksort (in place)
        // https://github.com/CHYGO1985/DataStructure_Java/blob/master/Sort_QuickSort/src/QuickSort.java
        
        // method 3: median of medians 
        // implement it for next round
        // ref: https://interviewalgorithm.wordpress.com/sortingordering/median-of-medians-algorithm/

        final int ERROR_CODE = -1;
        
        if (0 == nums.length || k > nums.length) {
            return ERROR_CODE;
        }
        
        k = nums.length - k;
        int front = 0;
        int rear = nums.length - 1;
        
        while (front < rear) {
            
            int leftSize = selectElem(nums, front, rear);
            
            if (leftSize < k) {
                front = leftSize + 1;
            }
            else if (leftSize > k) {
                rear = leftSize - 1;
            }
            else {
                break;
            }
        }
        
        return nums[k];
    }
    
    private int selectElem(int[] nums, int start, int end) {

        int pivotIdx = start;
        start ++;

        while (true) {
            // it does not matter if it is < or <=
            while (start < end && nums[start] <= nums[pivotIdx]) start ++;
            // *** here must be start <= end, as we need K elements, so right + 1 = K, e.g, 0 1 2 3, until 2, we have 3 eles, if we got 3, then we have 4 eles, so right idx must move another pos
            while (start <= end && nums[end] >= nums[pivotIdx]) end --;

            // means all sorted
            if (start >= end) break;
            swap(nums, start, end);
        }

        swap(nums, pivotIdx, end);
        return end;
    }
    
    public void swap(int[] nums, int front, int rear) {
        
        int temp = nums[front];
        nums[front] = nums[rear];
        nums[rear] = temp;
    }
}
