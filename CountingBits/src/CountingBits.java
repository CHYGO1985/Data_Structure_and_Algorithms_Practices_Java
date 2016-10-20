
public class CountingBits {
	
	public static int[] countBits(int num) {
        // * Idea: O(n) solution, cal 1 at a time (n is the 1 to n) --> consider find the connection between n - 1 and 
        // n --> use ^ to find differences
        // 1. draw on paper to find the following 4 laws
        // 1) pow of 2, count = 1
        // 2) pre ^ cur > 2 (111, 1111, 11111,....) cur.next = cur - ( result[111 / 1111/ 11111] - 2)
        // 3) pre ^ cur = 1, cur.next = cur；
        // 4) pre ^ cur = 2, cur.next = cur + 1；
        // *** result: 20 - 22ms, beat 4 - 5%, fastest is 3ms.    
    
        
        int[] result = new int[num + 1];
        result[0] = 0;
        
        for (int i = 1; i <= num; i ++) {
            
            int temp = (i - 1) ^ i;
            
            /*
            // method 1:
            // power of 2
            // *** check whether a number is power of 2 https://leetcode.com/problems/power-of-three/
            int max = (int) Math.pow( 2, (int) (Math.log(Integer.MAX_VALUE) / Math.log(2) ) );
            if ( 0 == max % i ) {
                result[i] = 1;
            } 
            else if (temp > 3 && temp <= num) {
                result[i] = result[i - 1] - (result[temp] - 2);
            }
            else if (1 == temp) {
                result[i] = result[i - 1] + 1;
            }
            else if (3 == temp){
                result[i] = result[i - 1];
            }
            */
            
            // method 2: optmise the core part:
            // result: 4ms, 27.68%
            /*
            if (1 == temp) {
                result[i] = result[i - 1] + 1;
            }
            else if (3 == temp){
                result[i] = result[i - 1];
            }
            else if ( temp > 3 ) {
                // if temp > i, means it i is 4(100), 8(1000)....
                if (temp > i) {
                    result[i] = 1;
                }
                else {
                    result[i] = result[i - 1] - (result[temp] - 2);
                } 
            } 
            */
            
            // method 3: further optimsie 2
            // still 4 ms.
            /*
            if (1 == temp) {
                result[i] = result[i - 1] + 1;
            }
            else if (3 == temp){
                result[i] = result[i - 1];
            }
            else if ( temp > i ) {
                result[i] = 1;
            }
            else {
                result[i] = result[i - 1] - (result[temp] - 2);
            } 
            */
            
            // 3ms solution: https://discuss.leetcode.com/topic/61827/share-my-3ms-java-solution-with-explanation
            // the fastest solution was trying to find the law between index and result. (make the index change a bit.)
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
