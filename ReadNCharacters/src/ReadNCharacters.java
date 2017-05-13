import java.util.Arrays;


public class ReadNCharacters {
	public int read4(char[] buf) {return 0;};
	
	public int read(char[] buf, int n) {
        // round 1: 15 m, 1ms, fastest 
        // the question is very confusion, the buf is to used to store data
        
        // *** java: 1. copy an array: int[] b = a.clone();
        // Arrays.copyOfRange() and copyOf()
        char[] temp = new char[4];
        int sum = 0;
        // num of chars read each time
        int num = 0;
        
        do {
        
            num = read4(temp);
            // *** for case that when first round num > n
            int count = Math.min(num, n - sum);
            for (int i = 0; i < count ; i ++) {
                buf[sum + i] = temp[i];
            }
            sum += count;
        }
        while (num == 4 && sum < n);
        
        return sum;
    }

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = Arrays.copyOf(a, 2);
		// b = {1,2}
		int[] c = Arrays.copyOfRange(a, 0, 5);
		// c = {1,2,3,4,0}
	}

}
