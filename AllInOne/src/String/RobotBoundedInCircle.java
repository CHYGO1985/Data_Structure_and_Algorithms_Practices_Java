/**
 * 
 * @author jinejiejiang
 * @history Oct 5, 2021
 * 
 */
public class RobotBoundedInCircle {
  public boolean isRobotBounded(String instructions) {
        
    assert instructions != null && instructions.length() > 0;

    // north = 0, east = 1, south = 2, west = 3
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int xAixs = 0, yAxis = 0;
    int idx = 0;

    for (int strIdx = 0; strIdx < instructions.length(); strIdx ++) {

      char curChar = instructions.charAt(strIdx);

      if (curChar == 'L') {
        idx = (idx + 3) % 4;
      } else if (curChar == 'R') {
        idx = (idx + 1) % 4;
      } else {
        xAixs += dirs[idx][0];
        yAxis += dirs[idx][1];
      }
    }

    return (xAixs == 0 && yAxis == 0) || (idx != 0);
  }
}
