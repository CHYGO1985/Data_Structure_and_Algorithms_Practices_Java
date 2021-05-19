/**
 * 
 * 84. Largest Rectangle in Histogram
 * 
 * @author jingjiejiang
 * @history May 18, 2021
 * 
 */
public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {

    assert heights != null && heights.length >= 1;

    Stack<Integer> idxStack = new Stack<>();
    // the condition is for checking whether to push ele into the stack
    idxStack.push(-1);
    int res = 0;

    for (int idx = 0; idx < heights.length; idx ++) {
      while ( (idxStack.peek() != -1) && 
        idxStack.peek() >= heights[idx]) {

          int curHeight = heights[idxStack.pop()];
          // as there is one ele is poped, so we minus 1 2 3, the width of 2 is 3 - 1 - 1
          int curWidth = heights.length - idxStack.peek() - 1;
          res = Math.max(res, curHeight * curWidth);
      }
    }

    while (idxStack.peek() != -1) {
      int curHeight = heights[idxStack.pop()];
      int curWidth = heights.length - idxStack.peek() - 1;
      res = Math.max(res, curHeight * curWidth);
    }

    return res;
  }
}
