package Bit_Manipuation;

/**
 * 
 * @author jingjiejiang Feb 23, 2019 
 *
 */
public class ReverseBits {
	public static int reverseBits(int n) {
        
		 // * the important thing is to get the bit value of int n,
        // Solution1: get binary string -->  char array --> swap data --> to string --> to int
        // Method 1: Java Integer.toBinaryString or toString(n, 2)
        // String strBinary = Integer.toBinaryString(n);
        
        // Method 2: manually 
        
        // The process to get method of convert an int to a binary string 
        // cal some number on paper, then will find the algorithm.
        /*
        int[] binaryArray = new int[32];
        int index = 31;
        
        while (n >= 1 && index >= 0) {
            
            if (n % 2 == 0)
                binaryArray[index] = 0;
            else 
                binaryArray[index] = 1;
                
            n = n / 2; // until 1 / 2 = 0
            index --;
        }
        

        // *** always use a simple example to test the algorithm
        // calculate the int value from start to end in the array
        int sum = binaryArray[0];
		int factor = 1;
		for (int i = 1; i < 32; i ++) {
		            
		    factor = factor * 2;
		    // element = element * 2 * binaryArray[i];
		    // when ele = 0, then it always = 0
		    sum += factor * binaryArray[i];

	    }
	        
        return sum;
        */
        
        // https://discuss.leetcode.com/topic/16845/java-solution-only-use-shift
        int reverse = 0;
        // like a stack, >>> 31 is to get the left most 1, if it is 1 at 32 bit
        for(int i = 0; i < 32; i++){
            int temp = n << i;
            System.out.println(Integer.toBinaryString(temp));
            temp = (temp >>> 31) << i;
            System.out.println(Integer.toBinaryString(temp));
            reverse += temp;
            System.out.println(i + " ***** " + Integer.toBinaryString(reverse));
        }
        
//        int temp = n;
//        for (int i = 0; i < 32; i ++) {
//        	temp >>>= 1;
//        	System.out.println(Integer.toBinaryString(temp));
//        }
        
//        int xx = 7;
//        for(int i = 0; i < 32; i++){
//            int temp = xx << i;
//            System.out.println(Integer.toBinaryString(temp));
//            System.out.println(">>> 31 " + Integer.toBinaryString(temp >>> 31));
//            temp = (temp >>> 31) << i;
//            System.out.println("XXXX " + Integer.toBinaryString(temp));
//        }
        
        return reverse;
    }
	
	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
	}
}
