
public class WaterAndJugProblem {
	
	// round 2: still unsolved
    
    // idea: unsolved
    // things learned: Bézout's identity and how to cal GCD
    // ref: https://discuss.leetcode.com/topic/49238/math-solution-java-solution
	
	public static boolean canMeasureWater(int x, int y, int z) {
	    //limit brought by the statement that water is finallly in one or both buckets
	    if(x + y < z) return false;
	    //case x or y is zero
	    if( x == z || y == z || x + y == z ) return true;
	    
	    //get GCD, then we can use the property of Bézout's identity
	    return z%GCD(x, y) == 0;
	    }
	    
    public static int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		canMeasureWater(4, 6 ,8);

	}

}
