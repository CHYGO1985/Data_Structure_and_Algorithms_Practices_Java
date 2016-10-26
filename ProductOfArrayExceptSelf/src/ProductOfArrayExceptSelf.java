import java.util.Random;


public class ProductOfArrayExceptSelf {
	
	public static int[] productExceptSelf(int[] nums) {
        // *** I could not find the solution myself.
        // * method: two direction method https://discuss.leetcode.com/topic/25121/java-solution-with-constant-space
        // result: 2ms, beat 37.60%, fatest in the database
        int n = nums.length;
        int[] output = new int[n];
        int temp = 1;
        output[0] = 1;
        for (int i = 1; i < n; i++)
        {
            output[i] = output[i-1] * nums[i-1];
        }
        for (int i = n - 1; i >= 0 ; i--)
        {
            output[i] = temp * output[i];
            temp = temp * nums[i];
        }
        return output;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test
		
		Random ran = new Random();
		for (int i = 2; i < 10; i ++) {
			
			//System.out.println((int)(Math.random()*2));
			/*
			int a = (int)Math.random()*2;
			if (0 == a) {
			    System.out.println(" "+ i + ":" + a);
			}
			*/
			
			System.out.println(ran.nextInt(20));
		}

	}

}
