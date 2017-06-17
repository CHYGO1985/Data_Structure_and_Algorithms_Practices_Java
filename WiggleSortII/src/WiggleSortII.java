/**
 * round 1: unsolved, virtual index + three pointers tech
 * 
 * *** virtual index: (1 + 2*index) % (n | 1) 
 * ref: https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java
 * 
 * @author jingjiejiang
 * @history Jun 17, 2017
 */
public class WiggleSortII {
	
	public static void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
        	// even if the matched index is at %2 != 0 pos, left can still increase
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private static int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
	
	public static int findKthLargest(int[] nums, int k) {

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
    
    public static int selectElem(int[] nums, int front, int rear) {
        
        // front is the index of pivot
        // variable bigger than pivot
        int big = front;
        // variable samller than pivot
        int small = rear + 1;
        
        while (true) {
            
            while (big < rear && true == nums[++ big] < nums[front]);
            while (small > front && true == nums[-- small] > nums[front]);
            if (big < small) {
                swap(nums, big, small);
            }
            else {
                break;
            }
        }
        
        // swap the pivot with the index which rep the samll num
        swap(nums, front, small);
        
        return small;
    }
    
    public static void swap(int[] nums, int front, int rear) {
        
        int temp = nums[front];
        nums[front] = nums[rear];
        nums[rear] = temp;
    }

	public static void main(String[] args) {
		
		wiggleSort(new int[]{6,13,5,4,5,2});

	}

}
