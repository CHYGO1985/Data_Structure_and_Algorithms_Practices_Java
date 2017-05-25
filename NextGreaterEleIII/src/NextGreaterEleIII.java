
public class NextGreaterEleIII {
	
	public static int nextGreaterElement(int n) {
		// round 1: 1.5 hours, unsolved
        // observation: 
        // 1021 - 1102
        // 2019 - 2091
        // 2091 - 2109
        // 1921 - 2119
        
        // method 1: from right to left, find the one that is smaller, swap, the ones between, cause they are al 
        // ref: https://discuss.leetcode.com/topic/86049/simple-java-solution-4ms-with-explanation/3
        char[] arr = String.valueOf(n).toCharArray();
    
        // compare the paried two, return the index of the one that is not larger than previous one
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
    
        if (i < 0) return -1;
    
        // from i to end, find tne one that is bigger then arr[i] (coz previous check confirm that they are in ascending order)
        int j = arr.length - 1;
        while (arr[j] <= arr[i])
            j--;
    
        swap(arr, i, j);
        
        // after swap, they will still in ascending order, so just reverse them
        reverse(arr, i + 1, arr.length - 1);
    
        try {
            return Integer.valueOf(String.valueOf(arr));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void swap(char[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    
    static void reverse(char[] arr, int i, int j) {
        int l = i, h = j;
        while (l < h)
            swap(arr, l++, h--);
    }

	public static void main(String[] args) {
		
		int a = nextGreaterElement(1345761);
	}

}
