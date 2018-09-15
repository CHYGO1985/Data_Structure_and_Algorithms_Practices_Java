package Greedy;

public class Candy {
	
	// [1,3,2,2,1] if start from 1, did not count i > i -1
	public static int candy(int[] ratings) {
		
		if (ratings == null || ratings.length == 0) return 0;
        int sum = 1;
        if (ratings.length == 1) return sum; 
        if (ratings[0] > ratings[1]) sum += 1;
        
        for (int index = 0; index < ratings.length; index ++) {
        	sum += (ratings[index] > ratings[index + 1]) ? 2 : 1;
        }
        
        return sum;
    }

	public static void main(String[] args) {
		int[] ratings = new int[]{1,1,1};
		System.out.println(candy(ratings));
	}
}
