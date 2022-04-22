import java.util.Arrays;

/**
 * 
 * 1710. Maximum Units on a Truck
 *
 * @author jingjiejiang
 * @history Oct 19, 2021
 * 
 * ref: greedy (sort, then get from max to min)
 *
 */
class Solution {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
      
    // assert boxTypes.length >= 1 && boxTypes.length <= 1000
    //         && truckSize >= 1;

    // // sort in reverse order
    // Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);

    // int maxUnit = 0;

    // for (int idx = 0; idx < boxTypes.length; idx ++) {
    //   if (truckSize >= boxTypes[idx][0]) {
    //     maxUnit += boxTypes[idx][0] * boxTypes[idx][1];
    //     truckSize -= boxTypes[idx][0];
    //   } else {

    //     maxUnit += truckSize * boxTypes[idx][1];
    //     break;
    //   }
    // }

    // return maxUnit;


    assert boxTypes.length >= 1 && boxTypes.length <= 1000 && truckSize >= 1;

    Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);

    int maxUnit = 0;

    for (int row = 0; row < boxTypes.length; row ++) {
      if (boxTypes[row][0] >= truckSize) {
        maxUnit += truckSize * boxTypes[row][1];
        break;
      } else {
        truckSize -= boxTypes[row][0];
        maxUnit += boxTypes[row][0] * boxTypes[row][1]; 
      } 
    }

    return maxUnit;
  }
}
