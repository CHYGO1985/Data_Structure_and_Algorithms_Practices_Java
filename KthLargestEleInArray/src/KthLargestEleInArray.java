
public class KthLargestEleInArray {
	
	public static int findKthLargest(int[] nums, int k) {
        // method 1: heap sort O(nlogn), and method that reduce the question to sort problem, will meet
        // the O(nlogn) bound
        
        // method 2: selection algorithm -- based on quick sort O(n)
        // ref: https://discuss.leetcode.com/topic/14597/solution-explained
        
		// the partition is from min to max, so the (new k) num of k's small num than kth largest = length - (old k)kth largest
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        
        // *** why we need this condition? low < high?
        // for the example: {3,2,1,5,6,4}, the first time, find inde 2, and the second time find index 4, the last time low = high
        // which means j must be = k = 3, so there is no need to go into the loop, just return arr[k].
        while (low < high) {
        	// j represent the length of the left part
        	// kth largest: 1,2,3,4,5,6,7 if kth largest = 3, then kth smallest is 4, so in this case, if j = 4 (pivot = a[5]), then
        	// a[5] is the kth largest ele
            final int j = partition(nums, low, high);
            // if left part is shorter than k, then go to the right part
            if(j < k) {
                low = j + 1;
            }
            // if left part is longer than k, then go to the left part
            else if (j > k) {
                high = j - 1;
            }
            // if j == k, j is the ele that we are looking for
            else {
                break;
            }
        }
        
        return nums[k];
    }
    
	// This function is to partition the array according to pivot a[lo], the return value indicate the length
	// of the left part of the pivot
    private static int partition(int[] a, int lo, int high) {

        int i = lo;
        int j = high + 1;
        while(true) {
        	// from left to right, locate the ele that is not less than the ele in index lo
            while(i < high && less(a[++i], a[lo]));
            // from right to left, locate the ele that is not bigger than the ele in index lo
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            
            // same function as quick sort: put the bigger ele to right part and smaller ele to left part.
            exch(a, i, j);
        }
        
        // this swap is to put the pivot a[lo] to the middle of the sperated array
        // e.g. {4,2,1,5,3,6,7} --> {4,2,1,3,5,6,7} --> swap {3,2,1,4,5,6,7}
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {3,2,1,5,6,4,7};
		// int[] arr = {1,2,3,4,5,6};
		// int[] arr = {3,1,2,6,7,8,9};
		
		int b = findKthLargest(arr, 2);
	}

}
