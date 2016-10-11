
public class FactorialTrailingZeroes {
	
	public static int trailingZeroes(int n) {
        // *** hints from internet: solve the problem from the fact that only 5 can generate a 0.
        // 1) every 5 in n! (5, 10 ) will generate one 0;
        // 2) every 25 will generate one extra 0;
        // 3) every 125 will generate one extra 0;
        // ...evert power of 5 will generate one extra 0
        
        // *** result: 1ms, the fatest solution.
        
        int sum = 0;
        
        while (n != 0) {
            
            sum += n / 5;
            n = n / 5;
        }
        
        return sum;
    }

	public static void main(String[] args) {

	}

}
