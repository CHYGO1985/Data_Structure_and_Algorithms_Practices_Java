
public class ConvertANumberToHexadecimal {
	
	// fastest solution: https://discuss.leetcode.com/topic/61391/beat-90-java-solution-long-but-easy-understand-any-advice
    // 7ms. the author didn't use hash table and implement the way i want to handle negative number.
    public static String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return sb.append(0).toString();
        int sign = 1;
        int bitNum = 8;
        // JJJ: the author handle negative num in a different way
        if (num < 0) {
            num = -num - 1;
            sign = -1;
        }
        
        while (sign == 1 && num != 0) {  // num is positive
            int rest = num % 16;
            if (rest < 10) {
                sb.append(rest);
            }
            else {
                sb.append((char)('a' + rest - 10));
            }
            num /= 16;
        }
        
        while (sign == -1 && bitNum > 0) {  // num is negative
            int rest = num % 16;
            if (rest < 6) {
                sb.append((char)('f' - rest));
            }
            else {
                sb.append(15 - rest);
            }
            num /= 16;
            bitNum--;
        }
        
        return sb.reverse().toString();
    }

    /*
    public static String toHex(int num) {
        // * idea 1: 
        // 1) for pos, build a hashtable for code, then use traditional / and % to cal the result.
        // 2) for neg, use 2^(bit num) + n = pos num, cal pos num for result.
        // result: *** 10ms, beat 15%, fastest in the databse is 7ms.
        // optimised: use string instead stringbuilder, 8 ms, beat 51.92%
  
        // build a hash table for code.
        char[] code = new char[16];
        
        for (int i = 0; i < 10; i ++) {
            code[i] = (char) (48 + i);
        }
        code[10] = 'a';
        code[11] = 'b';
        code[12] = 'c';
        code[13] = 'd';
        code[14] = 'e';
        code[15] = 'f';
        
        // StringBuilder builder = new StringBuilder();
        String result = "";
        
        // if it is a neg number (if the question ask for long type, then my method won't work)
        long testNum = (long)num;
        if (testNum < 0) {
            testNum = (long)Math.pow(2, 32) + testNum;
        }
        
        while (testNum >= 16) {
                
                // char temp = code[(int)(testNum % 16)];
                // testNum = testNum / 16;
                // builder.insert(0, temp);
                
                // 
                result = code[(int)(testNum % 16)] + result;
                testNum = testNum / 16;
        }
        
        //builder.insert(0, code[(int)testNum]);
        result = code[(int)(testNum % 16)] + result;
        
        return result;
	}
	*/
	
	// * another method with bit manipulation without using / and %
	// https://discuss.leetcode.com/topic/60414/java-solution
	// in this example, use String is 9ms, use StringBuilding will be 12-14ms, string is a bit faster than stringbuilder.
	
	/*
	char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(toHex(-2147483648));
        
        int a = -2147483648; 
        int b = -a - 1;
        System.out.println(b);
	}

}
