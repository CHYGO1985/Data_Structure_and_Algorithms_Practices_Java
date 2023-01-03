/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    
  const stack = [];
  stack[0] = -1;
  let res = 0;

  for (let idx = 0; idx < heights.length; idx ++) {
    while (stack[stack.length - 1] != -1 && heights[stack[stack.length - 1]] >= heights[idx]) {
      const curHeight = heights[stack.pop()];
      const curWidth = idx - stack[stack.length - 1] - 1;
      res  = Math.max(res, curHeight * curWidth);
    }
    stack.push(idx);
  }

  while (stack[stack.length - 1] != -1) {
    const curHeight = heights[stack.pop()];
    const curWidth = heights.length - stack[stack.length - 1] - 1;
    console.log(curHeight)
    res  = Math.max(res, curHeight * curWidth);
  }

  return res;
};