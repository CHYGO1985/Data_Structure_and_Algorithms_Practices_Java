
public class ReverseStringII {
	
	public String reverseStr(String s, int k) {
        // round 1: solved, 50 minutes, 7ms, 65.32%
        // misunderstood : every 2k "abcdefg" 2 : "bacdfeg" and "abcdefgh" 3: cbadefhg
        // test case: 
        // 1. "abcde" 3 : "cbade"
        // 2. "de" 3 : "ed"
        // 3. "" / "a" 2 : "" / "a"
		
        if (null == s || 0 == s.length() || 1 == s.length() || 0 == k) return s;
        char[] lets = s.toCharArray();
        int from = 0;
        // reverse every k eles in lets
        while (from < lets.length) {
            if (from % (2 * k) == 0) {
                int shift = Math.min(k, lets.length - from);
                reverse(lets, from, from + shift);
            }
            from += k;
        }
        return String.valueOf(lets);
    }
    
    private void reverse (char[] lets, int from, int to) {
        
        int front = from;
        int rear = to - 1;
        while (front < rear) {
            char temp = lets[rear];
            lets[rear --] = lets[front];
            lets[front ++] = temp;
        }
    }
}
