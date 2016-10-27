import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {
        // method1: if use TreeMap, then the complexity is O(nlogn)
        // for loop for nums n, sort them is logn
        
        // method2: use hashmap. O(2n)
        // *** bucket sort: https://discuss.leetcode.com/topic/44237/java-o-n-solution-bucket-sort/2
        // http://blog.csdn.net/houapple/article/details/6480100
        // *** result: 26ms, beat 88.63%, fastest in the database is 6ms.
        List<Integer>[] bucket = new List[nums.length + 1];
    	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    
    	for (int n : nums) {
    		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    	}
    
    	for (int key : frequencyMap.keySet()) {
    		int frequency = frequencyMap.get(key);
    		// *** here the author use frequency as the index, so the highest index will appear at the rear of the bucket.
    		if (bucket[frequency] == null) {
    			bucket[frequency] = new ArrayList<>();
    		}
    		bucket[frequency].add(key);
    	}
    
    	List<Integer> res = new ArrayList<>();
    
    	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
    		if (bucket[pos] != null) {
    			res.addAll(bucket[pos]);
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {

		int[] a = {1,1,1,2,2,2,2,3,3,3,3,3,3,4,4,4};
		List<Integer> list = topKFrequent(a, 2);
	}

}
