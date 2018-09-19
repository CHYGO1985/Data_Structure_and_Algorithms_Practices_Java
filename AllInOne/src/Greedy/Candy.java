package Greedy;

import java.util.Arrays;

/**
 * 
 * solved
 * @author jingjiejiang created on Sep 19, 2018
 *
 */
public class Candy {
	
	// [1,3,2,2,1] if start from 1, did not count i > i -1
	// 1234, 4321 
	public static int candy(int[] ratings) {
		
		if (ratings == null || ratings.length == 0) return 0;
		int[] carries = new int[ratings.length];
		Arrays.fill(carries, 1);
        int sum = 0;
        int index = 0;
        
        for (; index < ratings.length - 1; index ++) {
        	if (ratings[index] < ratings[index + 1]) {
        		carries[index + 1] = carries[index] + 1;
        	}
        	else if (ratings[index] > ratings[index + 1]) {
        		int start = index;
        		do {
        			index ++;
        		}
        		while (index < ratings.length - 1 && ratings[index] > ratings[index + 1]);
        		for (int end = index - 1; end >= start; end --) {
        			if (carries[end] <= carries[end + 1]) carries[end] = carries[end + 1] + 1;
        		}
        		index --;
        	}
        }
        
        for (int carry: carries) sum += carry;
        
        return sum;
    }

	public static void main(String[] args) {
//		int[] ratings = new int[]{1,1,1};
//		int[] ratings = new int[]{1,3,2,2,1};
		int[] ratings = new int[]{1,2,3,4};
//		int[] ratings = new int[]{4,3,2,1}; 
//		int[] ratings = new int[]{1,0,2};
//		int[] ratings = new int[]{1,3,4,5,2};
		System.out.println(candy(ratings));
	}
}
