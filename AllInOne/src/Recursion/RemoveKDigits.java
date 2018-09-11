package Recursion;

/**
 * sloved within 3 hours
 * @author jingjiejiang created on Sep 11, 2018
 *
 */
public class RemoveKDigits {
	
	// Recursion
	// 2314535: k = 2 (k <= 0 - samllest), find 1 first (the smallest), 23 = 2, then delete 23
	// if 234, then delete 34, the bigger one
	// 561234 : k = 3 (k > digits 0 - samllest), find 1 first, 56 = 2
	// delete left of 1, then delete k - left(num of digist of 1's left) at 1's right
	/*
	public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        char[] numArr = num.toCharArray();
        StringBuilder builder = new StringBuilder();
        
        // k = 1
        numArr = findAndRemove(numArr, 0, numArr.length - 1, k);

        for (char cur : numArr) {
        	if (cur != '#') builder.append(cur);
        }
        int i = 0;
        while (i < builder.length() && builder.charAt(i) == '0') i ++;
        return i == builder.length() ? "0" : builder.substring(i);
    }
	
	public static char[] findAndRemove(char[] numArr, int start, int end, int k) {

		if (k == 0) return numArr;
		// for case like 1173
		if (end - start + 1 == k) {
			for (int index = start; index <= end; index ++) {
				numArr[index] = '#';
			}
			return numArr;
		}
		
		int min = Integer.MAX_VALUE;
		int minPos = start;
		for (int index = start; index <= end; index ++) {
			if (numArr[index] - '0' < min) {
				minPos = index;
				min = numArr[index] - '0';
			}
		}
		
		if (minPos - start <= k) { // including minpos = 0
			for (int index = start; index < minPos; index ++) {
				numArr[index] = '#';
			}
			findAndRemove(numArr, minPos + 1, end, k - minPos + start);
		}
		else {
			// find the k's bigger ones and remove
			findAndRemove(numArr, start, minPos - 1, k);
		}
		
		return numArr;
	}
	*/

	// Greedy
	// ref: https://leetcode.com/problems/remove-k-digits/discuss/88660/A-greedy-method-using-stack-O(n)-time-and-O(n)-space
	public static String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }
	
	public static void main(String[] args) {
//		String num = "100000";
//		String num = "10200";
//		String num = "456123";
		String num = "1432219";
//		String num = "1173";
		System.out.println(removeKdigits(num, 2));
	}

}
