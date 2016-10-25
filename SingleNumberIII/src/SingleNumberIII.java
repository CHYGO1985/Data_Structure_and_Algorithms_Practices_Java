
public class SingleNumberIII {

	public static int[] singleNumber(int[] nums) {
        // 1. linear run time --> O(n) --> sorting won't work, O(nlogn)
        // 2. constant space --> hashtabl won't work
        // 3. according to character that numbers only repeat twice, use "SUM" method, calculate the sum of the array
        // use the fact of a + b = c and 
        // *** difference --> bit manipulation (I could not remember the bit manipulation to solve the problem)
        // *** solution is here: http://bookshadow.com/weblog/2015/08/17/leetcode-single-number-iii/
        /*
        首先计算nums数组中所有数字的异或，记为xor

        令lowbit = xor & -xor，lowbit的含义为xor从低位向高位，第一个非0位所对应的数字
        
        例如假设xor = 6（二进制：0110），则-xor为（二进制：1010，-6的补码，two's complement）
        
        则lowbit = 2（二进制：0010）
        
        根据异或运算的性质，“同0异1”
        
        记只出现一次的两个数字分别为a与b
        
        可知a & lowbit与b & lowbit的结果一定不同
        
        通过这种方式，即可将a与b拆分开来
        */
        int num = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            num ^= nums[i];
        }
        
        int lowbit = num & -num;
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i ++) {
            if ( (nums[i] & lowbit) != 0) {
                result[0] ^= nums[i];
            }
            else {
                result[1] ^= nums[i];
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
