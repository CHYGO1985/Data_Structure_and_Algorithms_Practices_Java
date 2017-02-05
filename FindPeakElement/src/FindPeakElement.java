
public class FindPeakElement {
	
	public int findPeakElement(int[] nums) {
        // idea: method 1: from start to end, find a ele A that A > nums[pre] and < nums[after]
        // *** error 1: I did not consider that pre > cur, when there is only two elements
        // result: 1ms, majority on 0ms
        /*
        if (null == nums || 0 == nums.length) {
            return Integer.MIN_VALUE;
        }
        
        if (1 == nums.length) {
            return 0;
        }
        
        int preInd = 0;
        int curInd = 1;
        if (nums[preInd] > nums[curInd]) {
            return 0;
        }
        
        for (int i = 2; i < nums.length; i ++) {
            int postInd = i;
            
            if (nums[curInd] > nums[preInd] && nums[curInd] > nums[postInd]) {
                return curInd;
            }
            
            preInd = postInd - 1;
            curInd = postInd;
        }
        
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        
        return Integer.MIN_VALUE;
        */
        
        // method 2: the complexity of method 1 is O(n), try to get a O(log(n)) solution
        // logn --> binary search
        // ref: https://discuss.leetcode.com/topic/5848/o-logn-solution-javacode
        // *** the question assume that there is always a peak in the array --> I did not know the condition
        // *** I also ignore the conditio in the question that num[i] != nums[i + 1]
        
        if (null == nums || 0 == nums.length) {
            return Integer.MIN_VALUE;
        }
        
        return findPeakHelper(nums, 0, nums.length - 1);
    }
    
    private int findPeakHelper(int[] nums, int start, int end) {
        
        // *** handle special case: start == end, and start + 1 == end
        if(start == end) {
            return start;
        }
        else if(start+1 == end) {
            if(nums[start] > nums[end]) return start;
            return end;
        }
        else {
            
            int m = (start+end)/2;
            if(nums[m] > nums[m-1] && nums[m] > nums[m+1]) {
                return m;
            }
            else if(nums[m-1] > nums[m] && nums[m] > nums[m+1]) {
                return findPeakHelper(nums,start,m-1);
            }
            else {
                return findPeakHelper(nums,m+1,end);
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
