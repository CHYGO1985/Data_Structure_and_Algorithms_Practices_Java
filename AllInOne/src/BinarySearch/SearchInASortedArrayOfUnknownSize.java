/**
 * 
 * 702. Search in a Sorted Array of Unknown Size
 * 
 * @CHYGO1985
 * @history Oct 22, 2020 
 * 
 */
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int left = 0, right = (int)Math.pow(10, 4) - 1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            int readNum = reader.get(mid);
            if (readNum == 2147483647) {
                
                right = mid - 1;
                continue;
            } 
                
            if (readNum == target) return mid;
            
            if (readNum < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
}
