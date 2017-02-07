
public class FindMinRotatedSortedArr {
	
	public int findMin(int[] nums) {
        // idea: use the method similar to 	(33.Search in Rotated Sorted Array)
        // as the find the min value, so search from rear
        // result: 0ms, beat 63.42%
        
        if (null == nums || 0 == nums.length) {
            return Integer.MIN_VALUE;
        }
        
        return search(nums, 0, nums.length - 1);
    }
    
    private int search(int[] nums, int front, int rear) {
        
        // when nums[front] < nums[rear], means the array is in asending order
        if (nums[front] < nums[rear]) {
            return nums[front];
        }
        else if (rear - front <= 1) {
            return Math.min(nums[front], nums[rear]);
        }
        
        int mid = (front + rear) / 2;
            
        return nums[mid] < nums[rear] ? search(nums, front + 1, mid) : search(nums, mid + 1, rear);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
