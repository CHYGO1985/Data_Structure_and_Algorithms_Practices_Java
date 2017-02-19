
public class StringToInteger {
	
	public int myAtoi(String str) {
        // possible input:
        // Valid input: 
        // 1) float number: 2.33
        // 2) integer number: 233
        // 3) negative number: -1
        // Invalid:
        // 1) invalid char: 0 - 9 (30 - 39) and - (2D)
        // 2) out of int range: 2^31 - 1 and - 2^32
        // 3) invalid zero: 00002 || 00002.22
        // 4) invalid '.' and '-' : 4.3.2, 4-3-2 
        // 5) *** I didn't consider empty spaces
        
        // 1. first, consider valid input 233 - from right to left get ele from str and *10
        // 2. second, consider float number: 2.33
        
        // https://discuss.leetcode.com/topic/12473/java-solution-with-4-steps-explanations
        // I was thinking invalid input like float number, but according to the answer the inputs are limited as integer
        // result: 39ms, beat 88.90%
        // *** things learned: 1) use simple way to handle invalid input: digits[index] >= '0' && digits[index] <= '9'
        // 2) handle overflow problem (when meet numbers (convert, algebra)), always think about overflow
        
        // edge cases
        if (null == str || 0 == str.length())
            return 0;
        
        int res = 0;
        int sign = 1;
        int index = 0;
        // trim the string, eliminate spaces
        str = str.trim();
        char[] digits = str.toCharArray();
        
        // check signs whether it is + or -
        // it might be the case that the string does not contain any signs
        if (index < digits.length && (digits[index] == '-' || digits[index] == '+')) {
            if (digits[index] == '-')
                sign = -1;
            index ++;
        }
        
        // check overflow and check invalid char in the array
        // *** invalid input:  digits[index] >= '0' && digits[index] <= '9' can use this to decide return 0 or not
        while (index < digits.length && digits[index] >= '0' && digits[index] <= '9' ) {
            
            int temp = digits[index] - '0';
            if (Integer.MAX_VALUE / 10 < res || ( Integer.MAX_VALUE / 10 == res && temp > 7) ) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
            }
            
            res = res * 10 + temp;
            index ++;
        }
        
        return sign * res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
