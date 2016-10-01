
public class NthDigit {
	
	// Solution from :https://discuss.leetcode.com/topic/59314/java-solution/2
	
	public static int findNthDigit(int n) {
        // * idea: caculate the numbers on paper, find the law
        
        // construct factors 1*(10^0)*9, 2*(10^1)*9, 3*(10^3)*9
        // then use n % factor, if n - n%factor = 0 (means n is less than the factor) stop
        // *** I wanted to find an very easy way, but didn't success. I should try to find a workable version first. 
        /*
        if (n <= 9) {
            return n;
        }
        
        int base = 0;
        int factor = 0;
        
        do {
            
            base ++;
            n = n - factor * 9;
            factor = base * (int)Math.pow(10, base - 1);
        }
        while (n - factor * 9 > 0);

         // if (n - factors) is an even num , return n %  base * (int)Math.pow(10, base - 1) / 2 - 1 , special if == 0 , then return 9
        if ( n % 2 == 0) {
            
            int num = n % (base * 10) / base;
            if ( 0 == num ) {
                return 9;
            }
            else {
                return num - 1;
            }
        }
        // if after (n - factors) is an odd num, return n / base * (int)Math.pow(10, base - 1) + 1
        else {
            return n / (base * 10) + 1;
        }
        */
        
        // *** straight forward solution: https://discuss.leetcode.com/topic/59314/java-solution/2
        // result: 6ms, with other 48%, beat 38%
        int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(findNthDigit(54));
	}

}
