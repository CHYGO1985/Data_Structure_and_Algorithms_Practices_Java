
public class FindTheDifference {

	public static char findTheDifference(String s, String t) {
        // * idea: hash table. find the one that has value - 1.
        
        // Method 1: iterate through s and t
        // *** result: 9ms, beat 40.71%, fastest: 5ms.
        // special case: s.length() = 0 or t.length() = 0
        /*
        if (0 == t.length()) {
            return 'a';
        }
        
        int[] chars = new int[26];
        
        for (int i = 0; i < chars.length; i ++) {
            chars[i] = 0;
        }
        
        for (int i = 0; i < s.length(); i ++) {
            chars[s.charAt(i) - 'a'] += 1; 
        }
        
        for (int i = 0; i < t.length(); i ++) {
            
            int index = t.charAt(i) - 'a';
            chars[index] -= 1;
            if (-1 == chars[index]) {
                return t.charAt(i);
            }
        }
        
        return t.charAt(0);
        */
        
        // Method 2: optimise method 1, use one iteration (only iterate through s)
        // result: 8ms, beat 55.57%.
        /*
        if (0 == t.length()) {
            return 'a';
        }
        
        int[] chars = new int[26];
        
        for (int i = 0; i < chars.length; i ++) {
            chars[i] = 0;
        }
        
        for (int i = 0; i < s.length(); i ++) {
            
            chars[s.charAt(i) - 'a'] += 1; 
            chars[t.charAt(i) - 'a'] -= 1;
        }
        
        for (int i = 0; i < chars.length; i ++) {
            if (-1 == chars[i]) {
                return (char)(i + 'a');
            }
        }
        
        return t.charAt(t.length() - 1);
        */
        
        // Method 3: sum differences.
        // *** result: 7ms. beat 74.57%
        /*
         if (0 == t.length()) {
            return 'a';
        }
        
        long sum = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            sum += s.charAt(i);
            sum -= t.charAt(i);
        }
        
        sum -= t.charAt(t.length() - 1);
        
        return (char)(0 - sum);
        */
        
        // method 4: exclusive or (find difference)
        // http://blog.csdn.net/qq508618087/article/details/52352635
        // 8ms
        s += t;
        int extra = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            extra ^= s.charAt(i);
        }
        
        return (char)extra;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
