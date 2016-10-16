
public class AddStrings {
	
    public static String addStrings(String num1, String num2) {
        // * idea: 
        // method 1: straight forward, add bits one by one. 
        // 1) if have carries. add it to the next addiction.
        // 2) if lengths are dif, add the rest to the end of a string
        
        
        // method 1: add bits one by one
        // special cases: num1.length = 0 || num2.length = 0
        // result: 55 - 80ms, do not have distribution yet.
        /*
        if (0 == num1.length()) {
            return num2;
        }
        else if (0 == num2.length()) {
            return num1;
        }
        
        // num1 represents the longers one
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        int num1Len = num1.length();
        int num2Len = num2.length();
        int index = num1Len;
        int dif= num1Len - num2Len;
        String result = "";
        int carry = 0;
        int count = 1;
        
        // iterate through num1 and num2
        // *: the index of a string counted from left to right, when doing addition for numbers, should do from right to left.
        while (count <= num2Len) {
            
            // add two chars directly
            int char1 = num1.charAt(index - 1) - '0';
            int char2 = num2.charAt(index - 1 - dif) - '0';
            
            // if have any carries add it to next addition
            int temp = char1 + char2 + carry;
            carry = temp / 10;
            result = Integer.toString(temp % 10) + result;
            index --;
            count ++;
        }
        
        // num1 = 999, num2 = 1 (num1Len > num2Len & carry != 0)
        while (carry != 0 && index > 0) {
            
            int char1 = num1.charAt(index - 1) - '0';
            int temp = char1 + carry;
            carry = temp / 10;
            result = Integer.toString(temp % 10) + result;
            index --;
        }
        
        // if (carry != 0 and is out of max length (num2 == num1 || num1 = 999 and num2 = 1))
        if (carry != 0) {
            
            return Integer.toString(carry) + result;
        }
       
        return num1.substring(0, index) + result;
        */
        
        // method 2: when num1Len and num2Len, treat them as the same length by adding '0'. it can be seen from method 1
        // that if when num1Len != num2Len, treat them differently will significantly increase the code that needst to write.
        // increase the complesity.
        // *** result: 61-65ms
        /*
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        int num1Len = num1.length();
        int num2Len = num2.length();
        int index1 = num1Len;
        int index2 = num2Len;
        String result = "";
        int carry = 0;
        int count = 1;

        // iterate through num1 and num2
        // *: the index of a string counted from left to right, when doing addition for numbers, should do from right to left.
        while (index1 > 0) {
            
            // add two chars directly
            int char1 = num1.charAt(index1 - 1) - '0';
            int char2 = 0;
            if (index2 > 0) {
                char2 = num2.charAt(index2 - 1) - '0';
                index2 --;
            }
            
            // if have any carries add it to next addition
            int temp = char1 + char2 + carry;
            carry = temp / 10;
            result = Integer.toString(temp % 10) + result;
            index1 --;
        }
        
        // if (carry != 0 and is out of max length (num2 == num1 || num1 = 999 and num2 = 1))
        if (carry != 0) {
            
            return Integer.toString(carry) + result;
        }
       
        return num1.substring(0, index1) + result;
        */
        
        // method 3: use StringBuilder instead of "+" in String.
        // result: 30 - 38ms
        // *** for multiple operation of connecting two strings, StringBuilder will significantly decrease time.
        
        // num1 represents the longers one
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        int num1Len = num1.length();
        int num2Len = num2.length();
        int index1 = num1Len;
        int index2 = num2Len;
        StringBuilder result = new StringBuilder();
        int carry = 0;

        // iterate through num1 and num2
        // *: the index of a string counted from left to right, when doing addition for numbers, should do from right to left.
        while (index1 > 0) {
            
            // add two chars directly
            int char1 = num1.charAt(index1 - 1) - '0';
            int char2 = 0;
            if (index2 > 0) {
                char2 = num2.charAt(index2 - 1) - '0';
                index2 --;
            }
            
            // if have any carries add it to next addition
            int temp = char1 + char2 + carry;
            carry = temp / 10;
            result.insert(0, Integer.toString(temp % 10));
            index1 --;
        }
        
        // if (carry != 0 and is out of max length (num2 == num1 || num1 = 999 and num2 = 1))
        if (carry != 0) {
            
            result.insert(0, Integer.toString(carry));
        }
        
        return result.toString();
    }

	public static void main(String[] args) {

		String a = "23423";
		String b = "29999";
		System.out.println(addStrings(a , b));
	}

}
