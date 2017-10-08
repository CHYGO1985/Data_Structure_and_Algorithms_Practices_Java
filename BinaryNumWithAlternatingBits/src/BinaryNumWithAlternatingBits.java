/**
 * 
 * 693. Binary Number with Alternating Bits
 * 
 * round 1: solved, 60 minutes, 3 attemps
 * 
 * idea: I first think about move bit from right to left
 * however it cannot differentiate the start '1' of a num
 * e.g.,00...000100. it move bit from right to left,
 * it cannot tell the beginning one.
 * 
 * *** the max length of an int is 30 (30 + 1), not 31
 * so to get the highest bit as 1 is 1 << 30, not 1 << 31
 * 
 * @author jingjiejiang
 * @history
 * 1.Oct 8, 2017
 */
public class BinaryNumWithAlternatingBits {
	
	public static boolean hasAlternatingBits(int n) {
        
		// *** I used 31
        int pivot = 1 << 30;
        int count = 30;
        while (count >= 0) {
            
            if ( (n & pivot) > 0) break;
            n = n << 1;
            count --;
        }
        
        // at sign n & pivot > 0
        int sign = count % 2;
        
        while (count >= 0) {
            // use count % 2 to check whether the current pos should be 1 or 0
            if ( ( count % 2 == sign && (n & pivot) == 0) || 
               (count % 2 != sign && (n & pivot) > 0) )
                return false;
            n = n << 1;
            count --;
        }
        
        return true;
    }
	
}
