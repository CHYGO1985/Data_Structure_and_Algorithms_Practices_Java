
public class CountNumbersWithUniqueDigits {
	
	public static int countNumbersWithUniqueDigits(int n) {
        // * permutation and combination problem 
        // method: thematical induction: the regulation is 
        // when n: 9*(9-0)*(9-1)*...*(9 - (n-2)) + f(n-1) (f(n-1) is a recursive method)
        // ***result: 0ms, fastest in the database. 
        if (0 == n) {
            return 1;
        }
        else if (1 == n) {
            return 10;
        }
        
        int temp = 9;
        int reduce = 0;
        while (reduce <= (n - 2) ) {
           temp = temp*(9 - reduce);
           reduce += 1;
        }
        int sum = temp + countNumbersWithUniqueDigits(n - 1);
        
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
