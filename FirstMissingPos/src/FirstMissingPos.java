/**
 * 
 * 41. First Missing Positive
 * 
 * round 1: unsolved, 3 hours, used two pointers tech and quick sort method, still TLE
 * 
 * idea: locate the gap, use the fact that if it is full length array, then 
 * nums[nums.length - 1] = nums.length - 1
 * 
 * *** so i go and find min and max, then i stuck here for finding O(n) solution.
 * options considered: 
 * 1) (tradition) sorting -> abosultely > O(N)
 * 2) binary search (tradition) -> > O(n)
 * 
 * 3. i go back to check what i can do with one round --> i found i can split
 * positive and negative.
 * then I think what if i used the fact of nums[X] = X- 1, to check half of the
 * positive each time, so 
 * the solution if n + n/2 + n/4 + n/8 ... still O(n)  
 * 
 * 4. *** however it still generate TLE
 * 
 * *** the thing is, go back to sorting, we can use the fact nums[X] = X-1, to 
 * put those N back to where they are in the nums, then we can get the first 
 * one that is not nums[N] = N - 1 
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 23, 2017
 */
public class FirstMissingPos {
	
	// my implementaion of two pointers tech (divide pos and neg) + quick sort method 
	// n + n/2 + n/4 + n/8 ...but still TLE
	/*
	public int firstMissingPositive(int[] nums) {
        
        if (null == nums || 0 == nums.length) return 1;
        
        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            
            while (left < nums.length && nums[left] >= 0) {
                
                // swap positive and negative
                small = Math.min(small, nums[left]);
                big = Math.max(big, nums[left]);
                left ++;
            }
            
            while (right >= 0 && nums[right] < 0) right --;
            if (left < right)
                swap(left, right, nums);
        }
            
        if (big <= 0 || small > 1)  return 1;
        if (small == big) return small + 1;
        // left -= 1 first
        return findMissing(0, -- left, small, big, nums);
    }
    
    // at the begining, start == small == 0, big == end
    private int findMissing(int start, int end, int small, int big, int[] nums) {
        
        if (start + 1 == end) 
        	if (nums[start] + 1 != nums[end]) 
        		return nums[start] + 1;
        	else 
        		// for case 1 2 -1
        		return nums[end] + 1; 
            
        int pivot = (small + big) / 2;
        int mid = (start + end) / 2;
        sorting(start, end, pivot, nums);
        
        if (nums[mid] <= pivot)
            return findMissing(mid, end, pivot + 1, big, nums);
        else 
            return findMissing(start, mid, small, pivot - 1, nums);
    }
    
    private void sorting(int start, int end, int pivot, int[] nums) {
        
        while (start < end) {
            
            // *** used  nums[start] <= pivot, make the sorting of 1,2,0 to 1,0,2
            while (start < nums.length && nums[start] < pivot) start ++;
            while (end >= 0 && nums[end] > pivot) end --;
            
            if (start < end)
                swap(start, end, nums);
        }
    }
    
    private void swap(int a, int b, int[] nums) {
         int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
	 */
	
public int firstMissingPositive(int[] nums) {
        
        if (null == nums || 0 == nums.length) return 1;
        
        int i = 0;
        while (i < nums.length) {
            if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            // *** skip repeated
            // also we do not need to check nums[i] - 1 >= 0, coz we checked
            // in previous condition (nums[i] <= 0)
            // else if(nums[i] - 1 >= 0 && nums[nums[i] - 1] != nums[i]) swap(i, nums[i] - 1, nums);
            else if(nums[nums[i] - 1] != nums[i]) swap(i, nums[i] - 1, nums);
            
            else i ++;
        }
        
        i = 0;
        
        while(i < nums.length && nums[i] == i + 1) 
            i ++;
        
        return i + 1;
    }
    
    private void swap(int a, int b, int[] nums) {
         int temp = nums[b];
         nums[b] = nums[a];
         nums[a] = temp;
    }
}
