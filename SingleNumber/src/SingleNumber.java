
public class SingleNumber {
	
	public static int singleNumber(int[] nums) {
        // *** idea: find differences --> bit manipulation (exclusive or) or math calculation
        // *** result: 1ms, beat 40.05% the fastest in the database.
        int num = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            num ^= nums[i];
        }
        
        return num;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
