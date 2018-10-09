package PreviousQuestions;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang Oct 9, 2018
 *
 */
public class Temp {
	
	// find the min
	// from min to left, and from min right, get the the final array
	public int candy(int[] ratings) {
	   
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
		
	}
}
