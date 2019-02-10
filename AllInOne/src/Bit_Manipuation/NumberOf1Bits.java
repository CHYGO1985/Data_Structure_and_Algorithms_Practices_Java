package Bit_Manipuation;

/**
 * 
 * @author jingjiejiang Feb 10, 2019
 *
 */
public class NumberOf1Bits {
	/*
    public static int hammingWeight(int n) {
        
        // straight forward: & 1 from bit 1 to 32
        // *** result: 2ms, beat around 16%
        int oneBits = 0;
        
        for (int i = 0; i < 32; i ++) {
            
            int mask = 1 << i;
            // to note that, as n can be negative (java does not support unsigned int, so numbers like 2147483648,is
            // transformed as -2147483648 to pass to hammingWeight(int n), in this case (mask & n) < 0), i used the condition
            // (mask & n) > 0, so when the parameter is 2147483648, my algorithm returns 0 not 1.
            
            if ((mask & n) != 0) {
                oneBits += 1;
            }
        }
    
        return oneBits;
         // you need to treat n as an unsigned value
         // http://bookshadow.com/weblog/2015/03/10/leetcode-number-1-bits/
         // *** result: 1ms, beat 89.42%, the fatest solution.
         // This method is better than mine is that it iterate through the binary bits from another direction, so when there is only 0 left, there is no need to iterate through them.
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n >>>= 1;
        }
        return ans;
    }
    */
	// 1111 1111 1111 1111 1111 1111 1111 1101
	// 1000 0000 0000 0000 0000 0000 0000 0000
	// 111  1111 1111 1111 1111 1111 1111 1111
	// 1111 1111 1111 1111 1111 1111 1111 1111
	public static int hammingWeight(int n) {
        
//		int comNum = 1 << 31;
//		int count = 32, sum = 0;
//		
//		while (count -- >= 0) {
//			sum += (comNum & n) != 0? 1 : 0;
//			n = n << 1;
//		}
//		
//		return sum;
		
		// Best
		int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n >>>= 1;
            System.out.println("count: " + ans + " n: " +Integer.toBinaryString(n));
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(1101));
		
		System.out.println(Integer.parseInt("01111111111111111111111111111111", 2));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(-2147483648));
		
	}
}
