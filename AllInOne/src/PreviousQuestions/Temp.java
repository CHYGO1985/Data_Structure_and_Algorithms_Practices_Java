package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Jan 15, 2019
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end; 
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int maxA(int N) {
		
		int[] res = new int[N + 1];
		res[0] = 0;
		
		for (int idx = 1; idx <= N; idx ++) {
			if (idx <= 6) {
				res[idx] = idx;
			} else {
				res[idx] = Math.max(res[idx - 3] * 2, Math.max(res[idx - 4] * 3, 
						Math.max(res[idx - 5] * 4, idx)));
			}
			
		}
		
		return res[N];
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
