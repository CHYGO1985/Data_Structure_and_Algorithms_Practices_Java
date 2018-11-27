package Greedy;

import java.util.Arrays;

/**
 * 
 * solved
 * @author jingjiejiang created on Sep 19, 2018
 *
 */
public class Candy {
	
//	public int candy(int[] ratings) {
//        if (ratings == null || ratings.length == 0) return 0;
//		int[] carries = new int[ratings.length];
//		Arrays.fill(carries, 1);
//        int sum = 0;
//        int index = 0;
//        
//        for (; index < ratings.length - 1; index ++) {
//        	if (ratings[index] < ratings[index + 1]) {
//        		carries[index + 1] = carries[index] + 1;
//        	}
//        	else if (ratings[index] > ratings[index + 1]) {
//        		int start = index;
//        		do {
//        			index ++;
//        		}
//        		while (index < ratings.length - 1 && ratings[index] > ratings[index + 1]);
//        		for (int end = index - 1; end >= start; end --) {
//        			if (carries[end] <= carries[end + 1]) carries[end] = carries[end + 1] + 1;
//        		}
//        		index --;
//        	}
//        }
//        
//        for (int carry: carries) sum += carry;
//        
//        return sum;
//    }
	
	// [1,3,2,2,1] if start from 1, did not count i > i -1
	// 1234, 4321 
	public static int candy(int[] ratings) {
		
		int[] candies = new int[ratings.length];
        int res = 0;
        
        for (int idx = 0; idx < ratings.length - 1; idx ++) {
        	
        	if (ratings[idx] < ratings[idx + 1]) {
        		candies[idx + 1] = candies[idx] + 1;
        	} 
        	else {
        		int start = idx + 1;
        		int temp = idx + 1;
        		while (temp < ratings.length - 1 && ratings[temp] >= ratings[temp + 1]) 
        			temp ++;
        		// get temp as end of descending pos
        		int end = temp;
        		while (temp >= start) {
        			if (ratings[temp] < ratings[temp - 1]) candies[temp - 1] = Math.max(candies[temp] + 1, candies[temp - 1]);
        			temp --;
        		}
        		idx = end - 1;
        	}
        }
        
        for (int candy : candies) {
        	res += candy;
        }
        return res + ratings.length; 
    }

	public static void main(String[] args) {
		int[] ratings = new int[]{1,3,5,2,3};
//		int[] ratings = new int[]{1,3,2,2,1};
//		int[] ratings = new int[]{1,2,3,4};
//		int[] ratings = new int[]{4,3,2,1}; 
//		int[] ratings = new int[]{1,0,2};
//		int[] ratings = new int[]{1,3,4,5,2};
		System.out.println(candy(ratings));
	}
}
