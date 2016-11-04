
public class HIndex {

	public static int hIndex(int[] citations) {
        /*
        // I tried non hash table method, it does not work
        // * idea: sorting the array + draw on paper to find regularities
        // * result : unsolved, used time and run time, % in the db, fastest in the db
        // * things learned: used too much time on this problem, stick on 1 hour policy
        
        if (0 == citations.length) {
            return 0;
        }
        
        Arrays.sort(citations);
        int mid = citations.length / 2;
        
        return findHIndex(citations, mid);
        */
        
        // method 1: sort, then get value >= index
        
        // method 2: without sorting (hash + bucket sort idea)
        // https://discuss.leetcode.com/topic/40765/java-bucket-sort-o-n-solution-with-detail-explanation/2
        // result: 1ms, beat 59.36%, fastest: 0ms, 5.36%
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
            
        }
    
    /*
    private int findHIndex(int[] citations, int pos) {
        
        int length = citations.length;
        
        // if pos = 0, return length
        // *** I did not consider the special cases of [0], [0,...,0], [1,1]
        // I was wronr for [0], then for [0, 1]
        if (0 == pos) {
            if (citations[pos] < length)
                return citations[pos];
            else
                return length;
        }
        else if (length - 1 == pos) {
            if (0 == citations[pos])
                return 0;
            else
                return Math.min(citations[]);
        }
        
        // citations[pos] - (length - pos) >= 0
        if (citations[pos] - (length - pos) >= 0) {
            
            if ( (length - pos) == citations[pos]) {
                // if citations[mid] = length -mid + 1, return citations[mid]
                return citations[pos];
            }
            else if (citations[pos] - citations[pos - 1] >= (citations[pos] - (length - pos)) ) {
                // if citations[mid] - citations[mid - 1] >= citations[mid] - (length - mid + 1)
                // return (length - mid + 1)
                return length - pos; 
            }
            
            return findHIndex(citations, pos - 1);
        }
        
        // if citations[pos] - (length - pos) >= 0   
        return findHIndex(citations, pos + 1);
    }
    */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
