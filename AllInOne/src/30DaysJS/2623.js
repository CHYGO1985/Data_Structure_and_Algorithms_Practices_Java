/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
  let cache = {};
  return function(...args) {
      
      const argsStr = args.join('#');

      if (argsStr in cache) {
          return cache[argsStr];
      } else {
          const res = fn(...args)
          cache[argsStr] = res;

          return res;
      }
  }
}


/** 
* let callCount = 0;
* const memoizedFn = memoize(function (a, b) {
*	 callCount += 1;
*   return a + b;
* })
* memoizedFn(2, 3) // 5
* memoizedFn(2, 3) // 5
* console.log(callCount) // 1 
*/