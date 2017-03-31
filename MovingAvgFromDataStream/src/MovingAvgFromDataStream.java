
public class MovingAvgFromDataStream {
	
	// idea: dp like. use an array to store bucket data, replace the most recent one , replace place = (index % siz)
    // round 1:  
    // 1) *** did not consider the double to int problem, to get double, the left must also has at least one double
    // 2) *** edge case which lead to use 0 as divisor
    // result : 35m, 132ms, beat 99.73%
    private int[] arr;
    int count;
    double sum;

    /** Initialize your data structure here. */
    public MovingAvgFromDataStream(int size) {
        arr = new int[size];
        count = 0;
        sum = 0.0;
    }
    
    public double next(int val) {
        
        double avg = 0.0;
        int size = arr.length;
        // always consider edge case
        if (size == 0)
            return avg;
        
        if (count < size) {
            arr[count] = val;
            sum += arr[count];
            // *** avoid use 0 as divisor
            count += 1;
            // *** I did not consider that when use 0 as start, then I will use 0 as divisor
            // *** left must also be double
            avg = sum / count;
        }
        else {
            int replace = count % size;
            sum -= arr[replace];
            arr[replace] = val;
            sum += val;
            count += 1;
            avg = sum / size;
        }
        
        return avg;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
