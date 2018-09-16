package Greedy;

import java.util.function.IntPredicate;

import javax.swing.InputMap;

public class Candy {
	
	// [1,3,2,2,1] if start from 1, did not count i > i -1
	public static int candy(int[] ratings) {
		
		if (ratings == null || ratings.length == 0) return 0;
		int[] carries = new int[ratings.length];
		int[] candies = new int[ratings.length];
        int sum = 0;
        int index = 0;
        
        for (; index < ratings.length - 1; index ++) {
        	if (ratings[index] > ratings[index + 1] && carries[index] < 1) {
        		carries[index] = -1;
        		candies[index] = 1 + carries[index];
        	}
        	else if (ratings[index] < ratings[index + 1]) {
        		carries[index + 1] = carries[index] + 1;
        	}
        	
        }
        
        sum += 1 + carries[index];
        return sum;
    }

	public static void main(String[] args) {
//		int[] ratings = new int[]{1,1,1};
//		int[] ratings = new int[]{1,3,2,2,1};
		int[] ratings = new int[]{1,2,3,4};
		System.out.println(candy(ratings));
	}
}
