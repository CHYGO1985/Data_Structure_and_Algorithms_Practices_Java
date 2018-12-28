package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Dec 28, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end; 
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int minPatches(int[] nums, int n) {
		int count = 0;
        long sum = 0;
        int idx = 0;
        
        while (sum < n){
//        	int limit = idx < nums.length ? Math.min(nums[idx] - 1, n) : n;
//        	if (sum < limit) {
//        		sum += sum + 1;
//        		count ++;
//        	} else {
//        		sum += idx < nums.length ? nums[idx ++] : sum + 1;
//        	}
        	
        	if (idx >= nums.length || sum < nums[idx] - 1) {
        		sum += sum + 1;
        		count ++;
        	} else {
        		sum += nums[idx ++];
        	}
        	
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,4,5,2};
		int[] nums1 = new int[] {3, 4, 6, 5};
		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
		System.out.println(1);
//		System.out.print(candy(arr));
//		maxNumber(nums1, nums2, 5);
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
