import java.util.LinkedList;
import java.util.List;


public class FizzBuzz {
	
	public static List<String> fizzBuzz(int n) {
        // %3 and %5
        
        List<String> list = new LinkedList<String>();
        
        for (int i = 1; i <= n; i ++) {
            
            String temp = "";
            
            if (0 == (i % 3) && 0 == (i % 5)) {
                temp = "FizzBuzz";
            }
            else if (0 == (i % 3)) {
                temp = "Fizz";
            }
            else if (0 == (i % 5)) {
                temp = "Buzz";
            }
            else {
                temp = Integer.toString(i);
            }
            list.add(temp);
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
