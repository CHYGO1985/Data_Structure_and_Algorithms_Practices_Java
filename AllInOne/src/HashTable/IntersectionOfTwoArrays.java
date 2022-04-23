/**
 * 
 * 349. Intersection of Two Arrays
 * 
 * @author jingjiejiang
 * @history Apr 23, 2022
 * 
 */
public class IntersectionOfTwoArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
        
    assert nums1.length >= 1 && nums1.length <= 1000 && nums2.length >= 1 && nums2.length <= 1000;

      Set<Integer> num1Set = new HashSet<>();
      List<Integer> resList = new LinkedList<>();

      for (int num : nums1) {
        num1Set.add(num);
      }

      for (int num : nums2) {
        if (num1Set.contains(num)) {
          num1Set.remove(num);
          resList.add(num);
        }
      }

      return resList.stream()
          .mapToInt(Integer::intValue)
          .toArray();
  }
}
