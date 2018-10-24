package PreviousQuestions;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang Oct 24, 2018
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
        // init res array
		// int sum = ratings.len
		// for (1 to len) --> 0 to len - 1 is much better
		// 1) if [i] > [i - 1]
		// res[i] ++;
		// sum + res[i]
		// 2) else 
		// find the acsend one or the end of ratings while ([i] <= [i - 1] && i < len) i ++
		// from (new idx - 1) to cur i, i --
		// if ([iidx] > [idx] - 1) res[idx] ++, sum + res[i]
		// return sum;
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
		int[] arr = new int[]{1,2,3,3};
		candy(arr);
	}
}
