
public class SearchInRotatedSortedArray {
	
	public int search(int[] nums, int target) {
        // idea: binary search 
        // 1) rotate --> do not which direction to go
        // 2) array like problem (either use mid, front or rear as the start point) --> use the fact that front and 
        // rear can be used to divide the two partial order 
        // if target > front or target < rear can decide which direction to go
        // result: 13ms, beat 93.32%
        
        if (null == nums || 0 == nums.length) {
            return -1;
        }
        
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    private int binarySearch(int[] nums, int front, int rear, int target) {
        
        int mid = (front + rear) / 2;
        
        if (target == nums[front]) {
            return front;
        }
        else if (target == nums[rear]) {
            return rear;
        }
        else if (target == nums[mid]) {
            return mid;
        }
        
        if (front + 1 == rear || front == rear) {
            return -1;
        }
        
        if ((target > nums[front] && nums[mid] > nums[front]) || (target < nums[rear] && nums[mid] < nums[rear])) {
            
            return target < nums[mid] ? binarySearch(nums, front, mid - 1, target) : 
                    binarySearch(nums, mid + 1, rear, target);
        }
        else if (target > nums[front] && nums[mid] < nums[front]) {
            return binarySearch(nums, front, mid - 1, target);
        }
        // target < nums[rear] && nums[mid] > nums[rear] 
        else {
            return binarySearch(nums, mid + 1, rear, target);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
