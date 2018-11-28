package PreviousQuestions;

import javax.swing.tree.FixedHeightLayoutCache;

/**
 * 
 * @author jingjiejiang Nov 27, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static int candy(int[] ratings) {
        
		int[] candies = new int[ratings.length];
		int res = ratings.length;
		
		for (int idx = 0; idx < ratings.length - 1; idx ++) {
			if (ratings[idx] < ratings[idx + 1]) {
				candies[idx + 1] += candies[idx] + 1;
			}
			else {
				int start = idx + 1;
				int temp = idx + 1;
				while (temp < ratings.length - 1 && ratings[temp] >= ratings[temp + 1]) {
					temp ++;
				}
				int end = temp;
				while (temp >= start) {
					if (ratings[temp - 1] > ratings[temp]) {
						candies[temp - 1] = Math.max(candies[temp - 1], candies[temp] + 1);
					}
					temp --;
				}
				idx = end - 1;
			}
		}
		
		for (int candy : candies) {
			res += candy;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,4,5,2};
		int[] nums1 = new int[] {3, 4, 6, 5};
		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
		System.out.print(candy(arr));
//		maxNumber(nums1, nums2, 5);
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
