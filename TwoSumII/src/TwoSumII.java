import java.util.HashMap;
import java.util.Map;


public class TwoSumII {
	
	public static int[] twoSum(int[] numbers, int target) {
        // *** matching problem --> hash table. The hash table is from "Two Sum".
        // "Two Sum II" and "Two Sum", the difference is that, "Two Sum II" is sorted.
        // sorted --> means, when two positive num, two number must smaller than target; one positive, one negative, the
        // positive must <= (pos - neg)
        // ***result: 5ms, beat 11.56%, fastest 0 ms, still use hash table method, cut the array a bit using the character of sorted array.
        
        /*
        int boundry = numbers.length - 1;
        for (; boundry >= 0; boundry --) {
            if (numbers[boundry] <= target - numbers[0]) {
                break;
            }
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        
        for (int i = 0; i <= boundry; i ++) {
            
            int complimentary = target - numbers[i];
            if (map.containsKey(complimentary)) {
                result[0] = map.get(complimentary) + 1;
                result[1] = i + 1;
                break;
            }
            map.put(numbers[i], i);
        }
        
        return result;
        */
        
        // *** two pointers method:http://www.cnblogs.com/grandyang/p/5185815.html
        // result: 1ms, beat 40,76%, fastest in the database 0ms: 2.19% 
        int front = 0;
        int rear = numbers.length - 1;
        int[] result = new int[2];
        
        /*
        while (front < rear) {
            
            int sum  = numbers[front] + numbers[rear];
            if (sum == target) {
                result[0] = front + 1;
                result[1] = rear + 1;
                break;
            }
            else if (sum < target) {
                front ++;
            }
            else {
                rear --;
            }
        }
        */
        
        while (numbers[front] + numbers[rear] != target) {
        
            if (target - numbers[front] < numbers[rear])
                rear --;
                
            else if (target - numbers[rear] > numbers[front])
                front++;
        }
        
        
        return new int[]{front + 1, rear + 1};
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {2,3,4,5,6,7,8,9,10};
		int[] b = twoSum(a, 8);

	}

}
