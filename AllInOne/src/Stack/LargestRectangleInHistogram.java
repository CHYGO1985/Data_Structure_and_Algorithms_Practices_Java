import jdk.javadoc.internal.doclets.toolkit.taglets.IndexTaglet;

/**
 * 
 * 84. Largest Rectangle in Histogram
 * 
 * @author jingjiejiang
 * @history May 18, 2021
 * 
 * ref: https://leetcode.com/problems/largest-rectangle-in-histogram/solution/
 *
 */
public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {

    assert heights != null && heights.length >= 1;

    Stack<Integer> idxStack = new Stack<>();
    // if do not push -1 as init, then for case like [2,3,1,1,1], as 1 < 2 & 3, when 2,3 is pop out
    // then for 1 (1 is the min of the array, as only the min val will cause the stack to be empty), the record of the length of 2, 3 will lost
    // if there is -1 left, then we can always count the length of min val in the array
    idxStack.push(-1);
    int res = 0;

    for (int idx = 0; idx < heights.length; idx ++) {
      while ( (idxStack.peek() != -1) && 
        heights[idxStack.peek()] >= heights[idx]) {

          int curHeight = heights[idxStack.pop()];
          // as there is one ele is poped, so we minus 1 2 3, the width of 2 is 3 - 1 - 1
          int curWidth = idx - idxStack.peek() - 1;
          res = Math.max(res, curHeight * curWidth);
      }

      idxStack.push(idx);
    }

    while (idxStack.peek() != -1) {
      int curHeight = heights[idxStack.pop()];
      int curWidth = heights.length - idxStack.peek() - 1;
      res = Math.max(res, curHeight * curWidth);
    }

    return res;
  }

  // if do not use dummy -1, it will cause lots of problem
  public int largestRectangleArea2(int[] heights) {
    assert heights != null && heights.length >= 1;

    Stack<Integer> idxStack = new Stack<>();
    // if do not push -1 as init, then when there is only one ele left, we pop(), then peek(), 
    // the peek() will get invalid address
    int res = 0;
    int min = Integer.MAX_VALUE;

    for (int idx = 0; idx < heights.length; idx ++) {
    
        min = Math.min(min, heights[idx]);
        
      while ( (!idxStack.isEmpty()) && 
        heights[idxStack.peek()] >= heights[idx]) {

          int preIdx = idxStack.peek();
          int curHeight = heights[idxStack.pop()];
          // as there is one ele is poped, so we minus 1 2 3, the width of 2 is 3 - 1 - 1
          int curWidth = idx - preIdx;
          res = Math.max(res, curHeight * curWidth);
      }

      idxStack.push(idx);
    }

    while (!idxStack.isEmpty()) {
      int preIdx = idxStack.peek();
      int curHeight = heights[idxStack.pop()];
      // as there is one ele is poped, so we minus 1 2 3, the width of 2 is 3 - 1 - 1
      int curWidth = heights.length - preIdx;
      res = Math.max(res, curHeight * curWidth);
    }

    return Math.max(min * heights.length, res);
  } 
}
