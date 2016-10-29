
public class IntegerBreak {

	 public int integerBreak(int n) {
        // * brain teasing problem: draw draft on paper to find regularities
        // * half solved: --> draw from 5 to 10, find that f(n) = f(3 + f(rest)), split a number as 3 and other parts will 
        // get the maximum
        // * result: 0ms, beat 52%. 
        if (2 == n) {
            return 1; 
        }
        else if (3 == n){
            return 2;
        }
        
        return breakHelper(n);
    }
	    
	public int breakHelper(int n) {
	        
        if (n < 5) {
            return n;    
        }
        
        return 3*breakHelper(n - 3);
	}
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
