/**
 * 
 * 56. Merge Intervals
 * 
 */
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
 var merge = function(intervals) {
    
  if (!intervals.length) return [];
  intervals.sort((a, b) => a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]);

  const res = [intervals[0]];
  const prev = intervals[0];

  for (let [start, end] of intervals) {
    if (start <= prev.end) {
      prev.end = Math.max(prev.end, end);
    } else {
      res.push([start, end]);
      prev = [start, end];
    }
  }

  return res;
};