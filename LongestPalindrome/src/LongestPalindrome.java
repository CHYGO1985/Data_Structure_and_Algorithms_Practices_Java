
public class LongestPalindrome {
	
	public static int longestPalindrome(String s) {
        // * idea: palindrome --> chars in palindrome appears in *even* number except the one in the middle.
        // --> find chars appears in string as even times and if there is still chars left, length add 1 
        // (for the one in the middle)
        // method : hash table --> get even chars
        
        // result: 11ms
        
        int sum = 0;
        
        // a-z: 41 - 5A , A-Z: 61 - 7A so 41 -- 7A  == 16*3 + 10 = 58
        int[] table = new int[58];
        for (int i = 0; i < table.length; i ++) {
            table[i] = 0;
        }
        
        // iterate through string, build repeating infor hash table
        for (int i = 0; i < s.length(); i ++) {
            
            int temp = s.charAt(i) - 'A';
            table[temp] += 1;
        }
        
        // get all the chars that appeat in even number
        for (int i = 0; i < table.length; i ++) {
            
            if (0 == table[i] % 2) {
                sum += table[i]; 
            }
            else {
                // *** be careful that a char with odd opearance can also be used in palindrome. 
                if (table[i] > 2) {
                    sum += table[i] - 1;
                }
            }
        }
        
        if (sum < s.length()) {
            sum += 1;
        }
        
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
